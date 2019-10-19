package com.xicheng.jvm.book.chapter12.code388;

import java.util.Vector;

/**
 * description
 *
 * @author liubin52
 * @date 2019-08-28 10:05:09
 */
public class UnsafeVectorTest {

	private static Vector<Integer> vector = new Vector<>(10);

	public static void main(String[] args) {
		while (Thread.activeCount() < 20) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}

			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						vector.remove(i);
					}
				}
			}).start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						System.out.println(vector.get(i));
					}
				}
			}).start();
		}
	}
}
