package thread;

import java.util.concurrent.Callable;

//通过实现Callable接口创建多线程，该接口提供了一个call方法作为线程执行体
//Callable对象不能直接作为Thread的target。而且call方法还有一个返回值——call方法并不是直接调用，它是作为线程执行体被调用
//Java 5提供了Future接口来代表Callable接口里call方法的返回值，并为Future接口提供了一个FutureTask实现类，该实现类实现了Future接口，并实现了Runnable接口——可以作为Thread类的target
public class CallableThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		return null;
	}

}
