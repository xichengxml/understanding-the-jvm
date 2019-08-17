package com.xicheng.jvm.chapter02.code.code242;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VM args： -Xss128k
 *
 * @author xichengxml
 * @date 2019-08-17 06:27
 */
public class JavaVMStackSOF {

    private static int stackLength = 1;

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaVMStackSOF.class);

    private static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Throwable e) {
            LOGGER.error("error: {}, stackLength: {}", e, stackLength);
        }
    }
}
