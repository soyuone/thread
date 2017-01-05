package account.DeadLock;

//当两个线程相互等待对方释放同步监视器时就会发生死锁，Java虚拟机没有监测，也没有措施来处理死锁情况，所以多线程编程时应该采取措施避免死锁出现
public class DeadLock implements Runnable {

	A a = new A();

	B b = new B();

	public void init() {
		Thread.currentThread().setName("主线程");
		// 调用A对象的foo方法
		a.foo(b);
		System.out.println("进入了主线程之后");
	}

	@Override
	public void run() {
		Thread.currentThread().setName("副线程");
		// 调用b对象的bar方法
		b.bar(a);
		System.out.println("进入副线程之后");
	}

	public static void main(String[] args) {
		DeadLock d1 = new DeadLock();
		// 以d1为target启动新线程
		new Thread(d1).start();
		// 调用init方法
		d1.init();
	}

}

class A {

	public void foo(B b) {
		System.out.println("当前线程名:" + Thread.currentThread().getName() + " 进入A实例的foo()方法");
		try {
			Thread.sleep(200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("当前线程名:" + Thread.currentThread().getName() + " 企图调用B实例的last()方法");
		b.last();
	}

	public void last() {
		System.out.println("进入A类的last()方法内部");
	}
}

class B {
	public void bar(A a) {
		System.out.println("当前线程名:" + Thread.currentThread().getName() + " 进入B实例的bar()方法");
		try {
			Thread.sleep(200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("当前线程名:" + Thread.currentThread().getName() + " 企图调用A实例的last()方法");
		a.last();
	}

	public void last() {
		System.out.println("进入B类的last()方法内部");
	}
}
