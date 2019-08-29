package com.xicheng.jvm.chapter12.code.code389;

import java.util.Vector;

/**
 * 也抛出异常了，原因未明
 *
 * @author liubin52
 * @date 2019-08-28 10:09:12
 */
public class SafeVectorTest {

	private static Vector<Integer> vector = new Vector<>();

	private static final int CNT = 10;

	public static void main(String[] args) {
		while (Thread.activeCount() < 20) {
			for (int i = 0; i < CNT; i++) {
				vector.add(i);
			}

			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (vector) {
						for (int i = 0; i < CNT; i++) {
							vector.remove(i);
						}
					}
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (vector) {
						for (int i = 0; i < CNT; i++) {
							System.out.println(vector.get(i));
						}
					}
				}
			}).start();
		}
	}
}
