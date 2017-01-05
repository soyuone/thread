package account.lock;

public class AccountLockTest {

	public static void main(String[] args) {
		AccountLock al = new AccountLock("2016", 1000);
		new AccountLockThread("刘忠", al, 600).start();
		new AccountLockThread("张忠", al, 600).start();
	}

}
