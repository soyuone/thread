package account;

public class Account {

	private String accountNo;// 账户编号

	private double balance;// 账户余额

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 加锁->修改->释放锁
	public synchronized void draw(double drawAmount) {
		// 账户余额大于取钱数目时
		if (balance >= drawAmount) {
			System.out.println(Thread.currentThread().getName() + "取钱成功，吐出钞票：" + drawAmount);

			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 修改余额
			balance -= drawAmount;
			System.out.println("余额为：" + balance);
		}
		else {
			System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足.");
		}
	}

}
