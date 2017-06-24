package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {

	private int i;

	// 重写call()方法，call()方法的方法体就是线程执行体
	@Override
	public Integer call() throws Exception {
		for (; i < 20; i++) {
			// Thread对象的getName()方法返回当前线程的名称
			System.out.println("run：" + Thread.currentThread().getName() + " " + i);
		}
		return i;
	}

	public static void main(String[] args) {

		// 为主线程设置名称，默认名称为main
		Thread.currentThread().setName("main：");

		for (int i = 0; i < 20; i++) {
			// 调用Thread类的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 10) {
				Callable<Integer> callable = new ThirdThread();

				// 使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象中call()方法的返回值
				FutureTask<Integer> ft = new FutureTask<Integer>(callable);

				// 创建并启动线程
				Thread thread = new Thread(ft, "thread：");
				thread.start();

				// 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
				try {
					System.out.println("return：" + ft.get());
				}
				catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
