package com.xicheng.jvm.book.chapter02.code.code244;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM args： -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author xichengxml
 * @date 2019-08-17 08:05
 */
public class DirectMemoryOOM {

    private static final long SIZE_1MB = 1024 * 1024;

    public static void main(String[] args) {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        while (true) {
            unsafe.allocateMemory(SIZE_1MB);
        }
    }
}
