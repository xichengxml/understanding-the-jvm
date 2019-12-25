package com.xicheng.jvm.book.chapter03.code066;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 此代码演示了两点：
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自救的机会只有一次，因为一个对象的finalize方法只会被系统自动调用一次
 *
 * @author liubin52
 * @date 2019-08-29 15:39:51
 */
public class FinalizeEscapeGC {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinalizeEscapeGC.class);

	private static FinalizeEscapeGC saveHook = null;

	private void isAlive() {
		LOGGER.info("I am still alive");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		LOGGER.info("finalize method executed");
		FinalizeEscapeGC.saveHook = this;
	}

	public static void main(String[] args) throws Exception {
		saveHook = new FinalizeEscapeGC();

		// 对象第一次成功拯救自己
		saveHookTest();
		// 第二次自救失败
		saveHookTest();
	}

	private static void saveHookTest() throws Exception {
		saveHook = null;
		System.gc();
		// finalize方法执行级别较低，等待0.5秒
		TimeUnit.MILLISECONDS.sleep(500);

		if (saveHook != null) {
			saveHook.isAlive();
		} else {
			LOGGER.info("I am collected...");
		}
	}
}
