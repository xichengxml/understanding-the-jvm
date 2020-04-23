package com.xicheng.jvm.book.chapter02.code242;

/**
 * 创建线程导致的内存溢出异常
 * VM args：-Xss2m
 *
 * @author xichengxml
 * @date 2019-08-17 06:56
 */
public class JavaVMStackOOM {

    private static void running() {
        while (true) {
        }
    }

    private static void stackLeak() {
        while (true) {
            new Thread(JavaVMStackOOM::running).start();
        }
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
