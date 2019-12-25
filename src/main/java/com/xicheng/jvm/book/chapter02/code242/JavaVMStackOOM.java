package com.xicheng.jvm.book.chapter02.code242;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建线程导致的内存溢出异常
 * VM args：-Xss2m
 *
 * @author xichengxml
 * @date 2019-08-17 06:56
 */
public class JavaVMStackOOM {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaVMStackOOM.class);

    private static void running() {
        while (true) {
        }
    }

    private static void stackLeak() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    running();
                }
            });
            thread.start();
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
