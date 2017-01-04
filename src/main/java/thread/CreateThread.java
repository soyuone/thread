package thread;

//继承Thread类创建线程类
//使用继承Thread类的方法来创建线程类时，多个线程之间无法共享线程类的实例变量

//定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务。因此把run()方法称为线程执行体。
//创建Thread子类的实例，即创建了线程对象
//调用线程对象的start()方法来启动该线程

//当Java程序开始运行后，程序至少会创建一个主线程，主线程的线程执行体不是由run()方法确定的，而是由main()方法确定的。main()方法的方法体代表主线程的线程执行体
//程序可以通过setName()方法为线程设置名字，也可以通过getName()方法返回指定线程的名字。在默认情况下，主线程的名字为main，用户启动的多个线程的名字依次为Thread-0,···Thread-n等
public class CreateThread extends Thread {

	private int i;

	// 重写run方法，run()方法的方法体就是线程执行体
	@Override
	public void run() {
		for (; i < 100; i++) {
			// 当线程类继承Thread类时，直接使用this即可获取当前线程
			// Thread对象的getName()返回当前线程的名字
			// 因此可以直接使用调用getName()方法返回当前线程的名字
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			// 调用Thread的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 20) {
				// 线程的生命周期： New,Runable,Running,Blocked,Dead 5种状态

				// 创建并启动第一个线程
				new CreateThread().start();
				// 创建并启动第二个线程
				new CreateThread().start();
				// 如果想在调用子线程的start方法后子线程立即开始执行，程序可以使用Thread.sleep(1)来让当前运行的线程（主线程）睡眠1毫秒
				Thread.sleep(1);

				// 不要对处于死亡状态的线程调用start方法，程序只能对新建状态的线程调用start方法，对新建状态的线程两次调用start方法也是错误的，都会引起异常
			}
		}
	}

}
