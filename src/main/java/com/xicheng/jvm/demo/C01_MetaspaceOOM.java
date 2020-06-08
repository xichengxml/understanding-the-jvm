package com.xicheng.jvm.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author liubin52
 * @date 2020-06-08 18:24:11
 */
@Slf4j
public class C01_MetaspaceOOM {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setName("name" + i);
			user.setAge(i % 30);
			log.info("user: {}", toJSONString(user, DATE_FORMAT));
			TimeUnit.SECONDS.sleep(1);
		}
	}

	private static String toJSONString(Object object, String dateFormat) {
		SerializeConfig serializeConfig = LocalConfigHolder.get();
		serializeConfig.put(java.util.Date.class, new SimpleDateFormatSerializer(dateFormat));
		serializeConfig.put(java.sql.Date.class, new SimpleDateFormatSerializer(dateFormat));
		return JSON.toJSONString(object, serializeConfig);
	}

	private static final class LocalConfigHolder {
		private static final ThreadLocal<SerializeConfig> LOCAL_HOLDER = new ThreadLocal<SerializeConfig>() {
			@Override
			protected SerializeConfig initialValue() {
				return new SerializeConfig();
			}
		};

		private static SerializeConfig get() {
			return LOCAL_HOLDER.get();
		}
	}

	@Data
	private static class User {
		private String name;

		private int age;
	}
}
