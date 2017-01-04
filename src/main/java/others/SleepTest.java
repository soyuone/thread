package others;

import java.util.Date;

public class SleepTest {

	// 如果想让当前正在执行的线程暂停一段时间，并进入阻塞状态，则可以通过调用Thread类的静态sleep方法实现
	// 当当前线程调用sleep方法进入阻塞状态后，在其睡眠时间短内，该线程不会获得执行的机会，即使系统中没有其他可执行的线程，处于sleep中的线程也不会获得执行

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("当前时间:" + new Date());
			// 调用sleep方法让当前线程(主线程)暂停1s
			Thread.sleep(2000);
		}
	}

}
