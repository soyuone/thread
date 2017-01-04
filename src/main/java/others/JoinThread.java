package others;

public class JoinThread extends Thread {

	// Thread提供了让一个线程等待另一个线程完成的方法——join方法。当在某个程序执行流中调用其他线程的join（）方法时，调用线程将被阻塞，直到被join方法加入的join线程执行完为止

	// 提供一个有参数的构造器，用于设置该线程的名字
	public JoinThread(String name) {
		super(name);
	}

	// 重写run（）方法，定义线程执行体
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new JoinThread("新线程").start();
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join（）方法，main线程必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	// 该程序共有3个线程，主方法开始时就启动了名为“新线程”的子线程，该子线程将会和main线程并发执行。当主线程的循环变量i为20时启动了名为“被Join的线程”的线程，该线程不会和main线程并发执行
	// main线程必须等该线程执行结束后才可以向下执行。在名为“被Join的线程”执行时，实际上只有两个子线程并发执行，而主线程处于等待状态

}
