package account;

public class DrawThread extends Thread {

	private Account account;// 用户账户

	private double drawAmount;// 取钱金额

	public DrawThread(String name, Account account, double drawAmount) {
		super(name);// 线程名称
		this.account = account;
		this.drawAmount = drawAmount;
	}

	// 当多个线程修改同一个共享数据时，将涉及数据安全问题
	@Override
	public void run() {
		// 加锁->修改->释放锁
		synchronized (account) {
			// 账户余额大于取钱数目时
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "取钱成功，吐出钞票：" + drawAmount);

				// 修改余额
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("余额为：" + account.getBalance());
			}
			else {
				System.out.println(getName() + "取钱失败，余额不足.");
			}
		}// 同步代码块结束，该线程释放同步锁
	}

}
