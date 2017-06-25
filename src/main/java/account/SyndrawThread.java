package account;

public class SyndrawThread extends Thread {

	private Account account;// 用户账户

	private double drawAmount;// 取钱金额

	public SyndrawThread(String name, Account account, double drawAmount) {
		super(name);// 线程名称
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		account.draw(drawAmount);
	}

}
