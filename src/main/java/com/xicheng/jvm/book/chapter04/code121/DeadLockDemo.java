package com.xicheng.jvm.book.chapter04.code121;

/**
 * description 如何确认死锁等待的对象就是Integer对象，无法打印Integer地址
 * 使用对象可以确定哪个线程等待的是哪个对象
 *
 * @author xichengxml
 * @date 2019-10-19 16:36
 */
public class DeadLockDemo {

    public static void main(String[] args) throws Exception {
        // Integer Cache 对象只有一份
        Integer one = 1;
        Integer two = 2;

        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println(o1 + "--" + o2);

        /**
         * 阻塞等待手动触发
         */
        System.in.read();

        /**
         * 多次循环出现死锁几率更大
         */
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //synchronized (one) {
                //synchronized (two) {
                synchronized (o1) {
                    synchronized (o2) {
                        System.out.println("t1 sum: " + (one + two));
                    }
                }
            }, "t1-" + i).start();

            new Thread(() -> {
                // synchronized (two) {
                //  synchronized (one) {
                synchronized (o2) {
                    synchronized (o1) {
                        System.out.println("t2 sum: " + (one + two));
                    }
                }
            }, "t2-" + i).start();
        }
    }
}
