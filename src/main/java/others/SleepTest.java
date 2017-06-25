package others;

import java.util.Date;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println("当前时间:" + new Date());

			// 调用sleep()方法让当前线程(主线程)暂停2s
			Thread.sleep(2000);
		}
	}

}
