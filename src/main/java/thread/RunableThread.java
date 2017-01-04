package thread;

//实现Runable接口创建线程类

//定义Runable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体
//创建Runable实现类的实例，并以此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象

//采用Runnable接口的方式创建的多个线程可以共享线程类的实例变量，这是因为程序所创建的Runnable对象只是线程的target，而多个线程可以共享同一个target，所以多个线程可以共享供一个线程类
public class RunableThread implements Runnable {

	private int i;

	@Override
	public void run() {

		for (; i < 100; i++) {
			// 当线程类实现Runable接口时
			// 如果想获取当前线程，只能用Thread.currentThread方法
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				RunableThread rt = new RunableThread();

				// 通过new Thread(target, name)方法创建新线程
				new Thread(rt, "新线程1").start();
				new Thread(rt, "新线程2").start();
			}
		}
	}

}
