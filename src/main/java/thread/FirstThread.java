package thread;

public class FirstThread extends Thread {

	private int i;

	// 重写run方法，run()方法的方法体就是线程执行体
	@Override
	public void run() {
		for (; i < 20; i++) {
			// 当线程类继承Thread类时，直接使用this即可获取当前线程
			// Thread对象的getName()方法返回当前线程的名字
			System.out.println("run：" + getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// 为主线程设置名称，默认名称为main
		Thread.currentThread().setName("main：");

		for (int i = 0; i < 20; i++) {
			// 调用Thread类的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 10) {
				// 创建并启动第一个线程
				FirstThread firstThread = new FirstThread();
				firstThread.setName("first：");
				firstThread.start();

				// 创建并启动第二个线程
				FirstThread secondThread = new FirstThread();
				secondThread.setName("second：");
				secondThread.start();
			}
		}
	}

}
