package com.xicheng.jvm.mashibing;

import java.util.LinkedList;
import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-07 09:57
 */
public class C01_HelloGC {

    public static void main(String[] args) {
        System.out.println("Hello GC!");
        List<byte[]> byteArrayList = new LinkedList<>();
        for (; ; ) {
            // 1M空间
            byte[] byteArray = new byte[1024 * 1024];
            byteArrayList.add(byteArray);
         }
    }
}
