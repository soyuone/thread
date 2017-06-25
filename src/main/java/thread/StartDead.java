package thread;

public class StartDead extends Thread {

	private int i;

	@Override
	public void run() {
		for (; i < 20; i++) {
			// 当线程类继承Thread类时，直接使用this即可获取当前线程
			// Thread对象的getName()方法返回当前线程的名称
			System.out.println("run：" + getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// 为主线程设置名称，默认名称为main
		Thread.currentThread().setName("main：");

		for (int i = 0; i < 20; i++) {
			// 调用Thread类的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 10) {
				// 创建并启动第一个线程
				StartDead sd = new StartDead();
				sd.setName("first：");
				// 判断启动后线程的isAlive()值
				System.out.println(sd.isAlive());

				sd.start();

				// 判断启动后线程的isAlive()值
				System.out.println(sd.isAlive());
				// 再次调用start()，java.lang.IllegalThreadStateException异常
				// sd.start();
			}
		}
	}

}
