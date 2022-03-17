package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
/**
 * this class will read the data from property file and return it to user
 * @author Rafeek
 *
 */
public class PropertyFileUtility {
	/**
	 * this method will read data from property file for the key given by user and return value to user
	 * @author 
	 *@param key
	 *@throws Throwable
	 *@return
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

	}


