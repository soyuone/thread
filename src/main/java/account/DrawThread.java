package account;

public class DrawThread extends Thread {

	private Account account;// 用户账户

	private double drawAmount;// 取钱金额

	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	// 当多个线程修改同一个共享数据时，将涉及数据安全问题
	@Override
	public void run() {
		// 账户余额大于取钱数目
		if (account.getBalance() >= drawAmount) {
			System.out.println(getName() + "取钱成功，吐出钞票：" + drawAmount);

			account.setBalance(account.getBalance() - drawAmount);
			System.out.println("余额为：" + account.getBalance());
		}
		else {
			System.out.println(getName() + "取钱失败，余额不足.");
		}
	}

}
