package com.xicheng.jvm.book.chapter07.code212;

import com.xicheng.jvm.book.chapter07.code211.SuperClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * description
 *  通过数组定义来引用类，不会触发
 * @author liubin52
 * @date 2019-12-25 17:16:31
 */
@Slf4j
public class NotInitialization {

	static {
		log.info("NotInitialization init...");
	}

	/**
	 * 打印结果：
	 * 17:31:48.968 [main] INFO com.xicheng.jvm.book.chapter07.code212.NotInitialization - NotInitialization init...
	 * 17:31:48.984 [main] INFO com.xicheng.jvm.book.chapter07.code212.NotInitialization - [null, null, null, null, null, null, null, null, null, null]
	 *
	 * NotInitialization 加载的原因是因为执行main
	 * @param args
	 */
	public static void main(String[] args) {
		SuperClass[] superClasseArr = new SuperClass[10];
		log.info(Arrays.toString(superClasseArr));
	}
}
