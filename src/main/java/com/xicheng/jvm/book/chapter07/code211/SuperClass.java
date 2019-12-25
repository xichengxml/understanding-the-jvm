package com.xicheng.jvm.book.chapter07.code211;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * description 被动引用的例子之一
 * 通过子类引用父类的静态字段，不会加载子类
 * @author xichengxml
 * @date 2019-12-25 16:58:26
 */
@Slf4j
@Getter
@Setter
public class SuperClass {

	static {
		log.info("super class init...");
	}

	private int value = 123;

	public static int staticValue = 456;

	/**
	 * 运行结果：
	 * 17:07:26.342 [main] INFO com.xicheng.jvm.book.chapter07.code211.SuperClass - super class init...
	 * 17:07:26.354 [main] INFO com.xicheng.jvm.book.chapter07.code211.SuperClass - static value: 456
	 * 17:07:26.355 [main] INFO com.xicheng.jvm.book.chapter07.code211.SuperClass - ---------------------------------
	 * 17:07:26.355 [main] INFO com.xicheng.jvm.book.chapter07.code211.SubClass - sub class init...
	 * 17:07:26.355 [main] INFO com.xicheng.jvm.book.chapter07.code211.SuperClass - value: 123
	 * @param args
	 */
	public static void main(String[] args) {
		// 不需要加载子类
		log.info("static value: {}", SubClass.staticValue);
		log.info("---------------------------------");
		SubClass subClass = new SubClass();
		log.info("value: {}", subClass.getValue());
	}
}

@Slf4j
class SubClass extends SuperClass {

	static {
		log.info("sub class init...");
	}
}
