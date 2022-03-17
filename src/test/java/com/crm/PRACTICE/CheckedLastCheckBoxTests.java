package com.crm.PRACTICE;

import java.util.List;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckedLastCheckBoxTests extends BaseClass {
		@Test
		public void checklastCheckboxTests() throws InterruptedException{
			HomePage hp=new HomePage(driver);
			hp.contactlink();
			 List<WebElement> allcheckbox = driver.findElements(By.xpath("//table/tbody/tr[*]/td[1]/input[@name='selected_id']"));
			 int count = allcheckbox.size();
			 for(int i=count; i>=count;i--) {
			 }
			
		}
}
