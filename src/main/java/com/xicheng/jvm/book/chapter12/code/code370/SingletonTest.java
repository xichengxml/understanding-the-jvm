package com.xicheng.jvm.book.chapter12.code.code370;

/**
 * description
 *
 * @author liubin52
 * @date 2019-08-28 09:16:44
 */
public class SingletonTest {

	private static /*volatile*/ SingletonTest instanse;

	private SingletonTest() {
	}

	public static SingletonTest getInstance() {
		if (instanse == null) {
			synchronized (SingletonTest.class) {
				if (instanse == null) {
					instanse = new SingletonTest();
				}
			}
		}
		return instanse;
	}

	public static void main(String[] args) {
		SingletonTest.getInstance();
	}
}
