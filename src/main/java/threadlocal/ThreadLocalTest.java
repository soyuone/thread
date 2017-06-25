package threadlocal;

public class ThreadLocalTest {

	public static void main(String[] args) {
		// 为主线程设置名称，默认名称为main
		Thread.currentThread().setName("main：");

		Account at = new Account("王初始");

		for (int i = 0; i < 20; i++) {
			if (i == 6) {
				at.setName(Thread.currentThread().getName());
			}
			System.out.println(at.getName() + " 账户的i值：" + i);
		}

		// 启动两个子线程，共享同一个Account
		new MyTest(at, "first：").start();
		new MyTest(at, "second：").start();

	}

}

class Account {

	// 定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量，每个线程都会保留该变量的一个副本
	private ThreadLocal<String> name = new ThreadLocal<String>();

	// 定义一个初始化的name成员变量的构造器
	public Account(String str) {
		this.name.set(str);
		System.out.println("---" + this.name.get());
	}

	public String getName() {
		return name.get();
	}

	public void setName(String str) {
		this.name.set(str);
	}

}

class MyTest extends Thread {

	// 定义一个Account类型的成员变量
	private Account account;

	public MyTest(Account account, String name) {
		super(name);
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i == 6) {
				account.setName(Thread.currentThread().getName());
			}
			System.out.println(account.getName() + " 账户的i值：" + i);
		}
	}
}
