package indi.javase.concurrent;

/**
 * Created by wangkecheng on 2017/8/16.
 */
public class Singleton {
	private volatile Singleton instance = null;

	public Singleton getInstance() {
		if (instance == null) {
			synchronized (this) {
				if (instance == null) {
					instance = new Singleton ();
				}
			}
		}
		return instance;
	}
}
