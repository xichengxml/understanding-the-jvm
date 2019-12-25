package com.xicheng.jvm.book.chapter07.code213;

import lombok.extern.slf4j.Slf4j;

/**
 * description
 * 常量在编译阶段会存入调用类（NotInitialization）的常量池中，本质上并未引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @author liubin52
 * @date 2019-12-25 17:33:50
 */
@Slf4j
public class NotInitialization {

	/**
	 * 输出结果：
	 * 17:35:38.292 [main] INFO com.xicheng.jvm.book.chapter07.code213.NotInitialization - constant
	 * @param args
	 */
	public static void main(String[] args) {
		log.info(ConstantClass.CONSTANT);
	}
}

@Slf4j
class ConstantClass {

	static {
		log.info("ConstantClass init...");
	}

	public static final String CONSTANT = "constant";
}



