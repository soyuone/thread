package account;

public class SyndrawTest {

	public static void main(String[] args) {
		// 创建一个账户
		Account account = new Account("2017", 1000);

		// 模拟两个线程对同一个账户取钱
		new SyndrawThread("张晓明", account, 800).start();
		new SyndrawThread("张大明", account, 800).start();
	}
}
