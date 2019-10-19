package com.xicheng.jvm.test.jvmdemo.jvm01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-09-07 07:48
 */
public class ExecutorServiceTest {

    @Test
    public void test() {
        int coreCnt = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreCnt, coreCnt,
                5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        threadPoolExecutor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1自己获取自己状态：" + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(threadPoolExecutor);
        System.out.println("main线程获取线程1状态：" + new Thread("pool-1-thread-1").getState());
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    @Test
    public void test02() {
        int coreCnt = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreCnt, coreCnt,
                5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, this.getClass().getPackage().getName() + "-" + threadNumber.getAndIncrement());
            }
        });
        threadPoolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        int coreCnt = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreCnt, coreCnt, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        List<String> fileList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fileList.add("fileName" + i);
        }

        for (final String fileName : fileList) {

            threadPoolExecutor.submit(() -> {
                map.put(fileName, Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName());
            });
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Thread(map.get("fileName5")).getState());
    }

    class MyThreadFactory implements ThreadFactory {

        private AtomicInteger threadNumber = new AtomicInteger(1);

        private String fileName;

        public MyThreadFactory(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,fileName + "-" + threadNumber.getAndIncrement()) ;
        }
    }

}
