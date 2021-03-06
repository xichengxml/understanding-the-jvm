package com.xicheng.jvm.book.chapter02.code243;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助cglib使方法区出现内存溢出异常
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 没有成功
 *
 * @author xichengxml
 * @date 2019-08-17 07:48
 */
@Slf4j
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    log.info("still running...");
                    return methodProxy.invokeSuper(objects, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
