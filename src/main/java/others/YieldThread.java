package others;

//yield()方法与sleep类似，它也可以让当前正在执行的线程暂停，但它不会阻塞该线程，它只是将该线程转入就绪状态
//当某个线程调用了yield方法暂停之后，只有优先级与当前线程相同，或者优先级比当前线程更高的处于就绪状态的线程才会获得执行的机会
public class YieldThread extends Thread {

	public YieldThread(String name) {
		super(name);
	}

	// 重写run方法
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			// 使用yield方法让当前线程让步
			if (i == 20) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		// 启动两个并发线程
		YieldThread y1 = new YieldThread("高级");
		// 将y1线程设置成最高优先级
		y1.setPriority(MAX_PRIORITY);
		y1.start();

		YieldThread y2 = new YieldThread("低级");
		// 将y2线程设置成最低优先级
		y2.setPriority(MIN_PRIORITY);
		y2.start();
	}

}
