package com.crm.OrgananizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
@Listeners(com.crm.GenericLibrary.ListenerImplementation.class)
public class SearchByOrgByRatingTests extends BaseClass {
	@Test
	public void searchByOrgByRatingTests() throws Throwable {
		String SearchBar = elib.readDataFromExcel("Org", 7, 2)+jlib.getRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.orglink();
		/*Search the organisation by rating*/
		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(SearchBar);
		WebElement org = driver.findElement(By.id("bas_searchfield"));
		Select s=new Select(org);
		s.selectByVisibleText("rating");
		 driver.findElement(By.xpath("(//input[@onclick=\"callSearch('Basic');\"])")).click();
	     /*Step 7: logout of application*/
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			/* close the browser*/
			driver.quit();	
	}

}
