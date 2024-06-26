package com.mil0812.learnspring.persistence.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static final Properties PROPERTIES = new Properties();

	private PropertiesUtil() {
	}
	static {
		loadProperties();
	}

	public static String getProperty(String key){
		return PROPERTIES.getProperty(key);
	}

	private static void loadProperties() {
		try (InputStream inputStream = PropertiesUtil.class.getClassLoader()
		    .getResourceAsStream("application.properties")) {
			PROPERTIES.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
