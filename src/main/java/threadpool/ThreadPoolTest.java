package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest implements Runnable {

	@Override
	public void run() {
		// 局部变量，多个线程不共享；共享实例变量
		for (int i = 0; i < 15; i++) {
			System.out.println("run：" + Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		// 创建一个具有固定线程数（6）的线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);

		ThreadPoolTest tpt = new ThreadPoolTest();
		// 向线程池中提交三个线程
		pool.submit(tpt);
		pool.submit(tpt);
		pool.submit(tpt);

		// 关闭线程池
		pool.shutdown();
	}

}
