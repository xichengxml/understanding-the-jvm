package com.xicheng.jvm.chapter03.code;

/**
 * 并没有打印GC日志
 *
 * @author xichengxml
 * @date 2019-08-17 08:16
 */
public class ReferenceCoutingGC {

    private Object instance = null;

    private static final int SIZE_1MB = 1024 * 1024;

    /**
     * 这个成员变量的作用是占用内存，便于在GC日志中查看垃圾回收情况
     */
    private byte[] bigSize = new byte[2 * SIZE_1MB];

    public static void main(String[] args) {
        ReferenceCoutingGC referenceA = new ReferenceCoutingGC();
        ReferenceCoutingGC referenceB = new ReferenceCoutingGC();
        referenceA.instance = referenceB;
        referenceB.instance = referenceA;

        referenceA = null;
        referenceB = null;

        System.gc();
    }
}
