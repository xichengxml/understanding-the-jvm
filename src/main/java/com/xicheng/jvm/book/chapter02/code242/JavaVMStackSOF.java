package com.xicheng.jvm.book.chapter02.code242;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VM args： -Xss128k
 *
 * @author xichengxml
 * @date 2019-08-17 06:27
 */
@Slf4j
public class JavaVMStackSOF {

    private static int stackLength = 1;

    private static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Throwable e) {
            log.error("error: {}, stackLength: {}", e, stackLength);
        }
    }
}
