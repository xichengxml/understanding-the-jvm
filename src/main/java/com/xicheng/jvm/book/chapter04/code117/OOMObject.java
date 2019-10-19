package com.xicheng.jvm.book.chapter04.code117;

import java.util.ArrayList;
import java.util.List;

/**
 * description -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * @author xichengxml
 * @date 2019-10-19 10:09
 */
public class OOMObject {

    public static void main(String[] args) throws Exception {
        // 稍作延时，用于给连接jconsole预留时间
        Thread.sleep(10000);
        // 曲线运行五个周期
        for (int i = 0; i < 5; i++) {
            // 填入64MB对象
            fillHeap(1000);
            System.gc();
        }
        // 阻塞等待，使得jconsole保持连接
        System.in.read();
    }

    private static void fillHeap(int num) throws Exception {
        List<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            arrayList.add(new OOMPlaceholder());
        }
    }

    /**
     * 内存占位符对象，一个OOMPlaceholder大约占64KB
     */
    private static class OOMPlaceholder {
        public byte[] placeholder = new byte[64 * 1024];
    }
}
