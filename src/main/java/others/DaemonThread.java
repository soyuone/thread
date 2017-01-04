package others;

public class DaemonThread extends Thread {

	// 后台线程(Daemon Thread)：在后台运行，它的任务是为其他的线程提供服务，如JVM的垃圾回收线程，后台线程有个特征：如果所有前台线程死亡，后台线程会自动死亡
	// 调用Thread对象的setDaemon(true)方法可以将指定线程设置成后台线程.

	@Override
	public void run() {
		// 定义后台线程的线程执行体与普通线程没有任何区别
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		// 将此线程设置成后台线程
		dt.setDaemon(true);
		// 启动后台线程
		dt.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		// 程序执行到此结束，前台线程（main）结束
		// 后台线程也随之结束
	}

}
