package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	public static Properties prop;

	/**
	 * This method will read properties file
	 * @param filepath
	 */

	public static void readProperties(String filepath) {

		try {
			FileInputStream fis = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(fis);
			fis.close();// if u wanna close ur stream
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return value of specified key
	 * 
	 * @param String key
	 * @return String value
	 */
	// if u wnna retrive other files create another method
	public static String getProperty(String key) {

		return prop.getProperty(key);
	}

}