package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePracticeTest {
@Test
public void propertyFilePractice() throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pObj=new Properties();
	 pObj.load(fis);
	String URL = pObj.getProperty("url");
	 System.out.println(URL);
	
}
}
