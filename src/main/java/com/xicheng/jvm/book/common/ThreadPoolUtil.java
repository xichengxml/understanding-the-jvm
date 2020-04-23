package com.xicheng.jvm.book.common;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * description
 *
 * @author liubin52
 * @date 2020-04-23 16:48:23
 */
public class ThreadPoolUtil {

	private static ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();;

	private static final ExecutorService THREADPOOL = new ThreadPoolExecutor(4, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), namedFactory, new ThreadPoolExecutor.AbortPolicy());

	public static void executeThread(Runnable runnable) {
		THREADPOOL.execute(runnable);
	}
}
