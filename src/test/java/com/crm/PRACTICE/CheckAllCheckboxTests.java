package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class CheckAllCheckboxTests extends BaseClass {
@Test
public void checkAllCheckboxTests() throws InterruptedException{
	HomePage hp=new HomePage(driver);
	hp.contactlink();
	 List<WebElement> allcheckbox = driver.findElements(By.xpath("//table/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	 for(WebElement checkbox:allcheckbox) {
		 checkbox.click();
	 }
	
	
}
}
