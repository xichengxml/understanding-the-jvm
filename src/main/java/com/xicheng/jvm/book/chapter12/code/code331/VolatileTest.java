package com.xicheng.jvm.book.chapter12.code.code331;

/**
 * volatile变量自增测试
 *
 * @author xichengxml
 * @date 2019-08-27 14:53:19
 */
public class VolatileTest {

	private static volatile int race = 0;

	private static final int THREAD_CNT = 20;

	private static void increace() {
		race++;
	}

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_CNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						increace();
					}
				}
			}).start();
		}

		// 等待所有线程执行完成
		while (Thread.activeCount() > 2) {
			Thread.yield();
		}

		System.out.println(race);
	}
}
