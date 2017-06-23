package thread;

public class SecondThread implements Runnable {

	private int i;

	// 重写run方法，run()方法同样是线程执行体
	@Override
	public void run() {
		for (; i < 20; i++) {
			// 当线程类实现Runable接口时，如果想获取当前线程，只能用Thread.currentThread()方法
			// Thread对象的getName()方法返回当前线程的名称
			System.out.println("run：" + Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {

		// 为主线程设置名称，默认名称为main
		Thread.currentThread().setName("main：");

		for (int i = 0; i < 20; i++) {
			// 调用Thread类的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 10) {
				SecondThread st = new SecondThread();

				// 通过new Thread(target, name)方法创建新线程
				// 创建并启动第一个线程
				Thread firstThread = new Thread(st, "first：");
				firstThread.start();

				// 创建并启动第二个线程
				Thread secondThread = new Thread(st, "second：");
				secondThread.start();
			}
		}
	}

}
