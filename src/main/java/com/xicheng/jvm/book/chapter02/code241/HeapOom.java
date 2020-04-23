package com.xicheng.jvm.book.chapter02.code241;

import java.util.ArrayList;
import java.util.List;

/**
 * description 可以使用jvisualvm打开log文件查看实例情况，明显看出是OutOfMemoryObject对象太多导致的
 *
 * @author xichengxml
 * @date 2019-08-06 17:48:58
 */
public class HeapOom {

	private static class OutOfMemoryObject {

	}

	/**
	 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/heap_oom_dump.log
	 * @param args
	 */
	public static void main(String[] args) {
		List<OutOfMemoryObject> objectList = new ArrayList<>();
		while (true) {
			OutOfMemoryObject object = new OutOfMemoryObject();
			objectList.add(object);
		}
	}
}
