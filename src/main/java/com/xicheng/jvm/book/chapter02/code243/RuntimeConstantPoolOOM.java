package com.xicheng.jvm.book.chapter02.code243;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk8应该是优化过了，调成1m也没有异常
 *
 * @author xichengxml
 * @date 2019-08-17 07:11
 */
public class RuntimeConstantPoolOOM {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeConstantPoolOOM.class);

    public static void main(String[] args) {
        // 使用list保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            String string = i++ + "";
            list.add(string);
            LOGGER.info("still running, list: {}", list);
        }
    }
}
