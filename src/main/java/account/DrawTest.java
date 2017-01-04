package account;

public class DrawTest {

	// 当有两个进程并发修改同一个文件时就有可能造成异常(当多个线程修改同一个共享数据时，将涉及数据安全问题)

	public static void main(String[] args) {
		// 创建一个账户
		Account account = new Account("2017", 1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("张晓明", account, 800).start();
		new DrawThread("张大明", account, 800).start();
	}
}
