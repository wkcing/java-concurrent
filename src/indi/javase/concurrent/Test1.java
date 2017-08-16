package indi.javase.concurrent;

/**
 * Created by wangkecheng on 2017/8/16.
 */
public class Test1 {

	public volatile int inc = 0;

	public void increase() {
		inc++;
	}

	public static void main(String[] args) {
		final Test1 test1 = new Test1 ();
		for (int i = 0; i < 10; i++) {
			new Thread () {
				@Override
				public void run() {
					for (int j = 0; j < 10000; j++) {
						test1.increase ();
					}
				}
			}.start ();
		}
		while (Thread.activeCount () > 2) {	//保证前面的线程都执行完,Thread.activeCount ()是1还是2？？
			Thread.yield ();
		}
		System.out.println(Thread.activeCount ());
		System.out.println (test1.inc);
	}
}
