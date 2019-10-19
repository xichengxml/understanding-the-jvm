package com.xicheng.jvm.book.chapter04.code119;

/**
 * description 使用jconcole观察线程状态
 *
 * @author xichengxml
 * @date 2019-10-19 16:19
 */
public class ThreadWaitDemo {

    public static void main(String[] args) throws Exception {
        System.in.read();
        /**
         * 死循环线程
         */
        new Thread(() -> {
            while (true) {

            }
        }, "busyThread").start();
        // 阻塞等待
        System.in.read();
        final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "lockedThread").start();
    }
}
