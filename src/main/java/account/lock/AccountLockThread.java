package account.lock;

public class AccountLockThread extends Thread {

	private AccountLock accountLock;

	private double drawAmount;

	public AccountLockThread(String name, AccountLock accountLock, double drawAmount) {
		super(name);
		this.accountLock = accountLock;
		this.drawAmount = drawAmount;
	}

	public double getDrawAmount() {
		return drawAmount;
	}

	public void setDrawAmount(double drawAmount) {
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		accountLock.draw(drawAmount);
	}

}
