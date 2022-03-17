package com.crm.PRACTICE;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	@Test
	public void practice() throws IOException {
		JavaUtility jLib=new JavaUtility();
		int ran = jLib.getRandomNumber();
		String date = jLib.getSystemDate();
		String dat = jLib.getSystemDateInFormat();
		System.out.println(ran+date);
		System.out.println(dat);
		
		PropertyFileUtility p=new PropertyFileUtility();
		String BROWSER = p.readDataFromPropertyFile("browser");
		String URL = p.readDataFromPropertyFile("url");
		String UN = p.readDataFromPropertyFile("username");
		String PWD = p.readDataFromPropertyFile("password");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);

	}
}
