package account.lock;

import java.util.concurrent.locks.ReentrantLock;

//同步锁
//使用Lock与使用同步方法类似，只是使用Lock时显式使用Lock对象作为同步锁，而使用同步方法时系统隐式使用当前对象作为同步监视器，都符合：加锁-修改-释放锁
public class AccountLock {

	private final ReentrantLock lock = new ReentrantLock();

	private String accountNo;// 账户编号

	private double balance;// 余额

	public AccountLock(String accountNo, double balance) {
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

	// 提供一个线程安全的draw方法完成操作
	public void draw(double drawAmount) {
		// 加锁
		lock.lock();
		try {
			// 账户余额大于取钱数目
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName()
						+ "取钱成功，吐出钞票：" + drawAmount);

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				balance -= drawAmount;
				System.out.println("余额为：" + balance);
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "取钱失败，余额不足.");
			}
		} finally {
			// 修改完成，释放锁
			lock.unlock();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNo == null) ? 0 : accountNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountLock other = (AccountLock) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double
				.doubleToLongBits(other.balance))
			return false;
		return true;
	}

}
