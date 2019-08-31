package com.xicheng.jvm.book.chapter12.code.code332;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-08-27 17:07:24
 */
public class VolatileUse {

	private static final Logger LOGGER = LoggerFactory.getLogger(VolatileUse.class);

	/**
	 *
	 */
	private static volatile boolean shutdown = false;

	private static void shutdown() {
		shutdown = true;
		LOGGER.info("shutdown~");
	}

	private static void dowork() throws Exception {
		while (!shutdown) {
			LOGGER.info("working...");
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void main(String[] args) throws Exception {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					dowork();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				LOGGER.info("ready to shutdown");
				shutdown();
			}
		}).start();



		// 等待执行完成
		Thread.currentThread().join();
	}

}
