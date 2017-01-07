package threadlocal;

//ThreadLocal--Thread Local Variable,为每一个使用该变量的线程都提供一个变量值的副本，使每一个线程都可以独立的改变自己的副本，而不会和其他线程的副本冲突
//从线程的角度看，就好像每一个线程都完全拥有该变量一样

//ThreadLocal并不能替代同步机制，两者面向的问题领域不同。同步机制是为了同步多个线程对相同资源的并发访问，是多个线程之间进行通信的有效方式
//而ThreadLocal是为了隔离多个线程的数据共享，从根本上避免多个线程之间对共享资源的竞争，也就不需要对多个线程进行同步
public class ThreadLocalTest {
	public static void main(String[] args) {
		// 启动两个线程，两个线程共享同一个Account
		Account at = new Account("初始名");

		new MyTest(at, "线程甲").start();
		new MyTest(at, "线程乙").start();

	}

}

class Account {

	// 定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
	private ThreadLocal<String> name = new ThreadLocal<String>();

	// 定义一个初始化的name成员变量的构造器
	public Account(String str) {
		// 设置此线程局部变量中当前线程副本中的值
		this.name.set(str);
		System.out.println("----" + this.name.get());
	}

	public String getName() {
		// 返回此线程局部变量中当前线程副本的值
		return name.get();
	}

	public void setName(String str) {
		// 设置此线程局部变量中当前线程副本中的值
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
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				account.setName(getName());
			}
			System.out.println(account.getName() + " 账户的i值: " + i);
		}
	}
}
