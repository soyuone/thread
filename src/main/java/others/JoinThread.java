package others;

public class JoinThread extends Thread {

	// 提供一个有参数的构造器，用于设置该线程的名字
	public JoinThread(String name) {
		super(name);
	}

	// 重写run()方法，定义线程执行体
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("run：" + getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 创建并启动第一个子线程
		JoinThread firstThread = new JoinThread("first：");
		firstThread.start();

		for (int i = 0; i < 20; i++) {
			if (i == 10) {
				// 创建并启动第二个子线程
				JoinThread jt = new JoinThread("join：");
				jt.start();

				// main线程调用了jt线程的join()方法，main线程必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
