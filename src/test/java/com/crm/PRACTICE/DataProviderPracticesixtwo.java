package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticesixtwo {
		@Test(dataProvider ="getData" )
	public void SampleDataProvider(String Name,String model) {
		System.out.println(Name+"---"+model);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] obj=new Object[6][2];
		obj[0][0]="Oneplus";
		obj[0][1]="Nord2";
		
		
		obj[1][0]="iphone";
		obj[1][1]="13 pro";
		
		
		obj[2][0]="Mi";
		obj[2][1]="Note 8";
		
		
		obj[3][0]="Google";
		obj[3][1]="pixel 6";
		
		obj[4][0]="Blackberry";
		obj[4][1]="b05";
		
		obj[5][0]="huwaei";
		obj[5][1]="h6";
		return obj;
		}
	}

