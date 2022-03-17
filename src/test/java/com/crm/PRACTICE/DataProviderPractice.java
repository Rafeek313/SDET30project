package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider ="getData" )
public void SampleDataProvider(String Name,String model,int qty) {
	System.out.println(Name+"---"+model+"----"+qty);
}
@DataProvider
public Object[][] getData() {
	Object[][] obj=new Object[4][3];
	obj[0][0]="Oneplus";
	obj[0][1]="Nord2";
	obj[0][2]=50;
	
	obj[1][0]="iphone";
	obj[1][1]="13 pro";
	obj[1][2]=25;
	
	obj[2][0]="Mi";
	obj[2][1]="Note 8";
	obj[2][2]=15;
	
	obj[3][0]="Google";
	obj[3][1]="pixel 6";
	obj[3][2]=5;
	return obj;
	}
}
