package com.xicheng.jvm.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author xichengxml
 * @date 2019-08-06 17:48:58
 */
public class HeapOom {

	static class OutOfMemoryObject {

	}

	/**
	 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
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
