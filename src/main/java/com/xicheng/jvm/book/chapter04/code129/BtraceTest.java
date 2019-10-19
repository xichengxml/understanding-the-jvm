package com.xicheng.jvm.book.chapter04.code129;

import java.util.Random;

/**
 * description 调试方法：调试时，打开BTrace，之后在idea控制台输入内容，可以在BTrace打印出内容
 *
 * @author xichengxml
 * @date 2019-10-19 17:47
 */
public class BtraceTest {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        BtraceTest btraceTest = new BtraceTest();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.in.read();
            int a = random.nextInt(1000);
            int b = random.nextInt(1000);
            System.out.println(btraceTest.add(a, b));
        }
    }
}
