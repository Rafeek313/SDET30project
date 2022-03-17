package com.crm.CreateProductTests;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ListenerImplementation.class)
public class CreateContactWithCampaignTests extends BaseClass {
	@Test
	public void createContactWithCampaignTests() throws Throwable {
		
		ExcelFileUtility elib=new ExcelFileUtility();
		String campaignName = elib.readDataFromExcel("Campaign", 1, 1)+"_"+jlib.getRandomNumber();
		String prodName = elib.readDataFromExcel("Campaign", 1, 2)+"_"+jlib.getRandomNumber();
		String catType = elib.readDataFromExcel("Campaign", 1, 3)+"_"+jlib.getRandomNumber();
		
		
		
		
		/*Step 4: Navigate to product Link*/
		driver.findElement(By.xpath("//a[.='Products']")).click();
		
		/*Step 5: click on create product btn*/
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		Assert.fail();
		/*Step 6: enter mandatory fields and save*/
		driver.findElement(By.name("productname")).sendKeys(prodName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 7:verify for product*/
		String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(header.contains(prodName))
		{
			System.out.println(header);
			System.out.println("product created");
		}
		else
		{
			System.out.println(header);
			System.out.println("product not created");
		}
		/*step 8: navigate to contacts link*/
      driver.findElement(By.xpath("//a[.='More']")).click();
      driver.findElement(By.name("Campaigns")).click();
      driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
      driver.findElement(By.name("campaignname")).sendKeys(campaignName);
      driver.findElement(By.xpath("//img[@title=\"Select\"]")).click();
      /*Step 9: choose product */
       wlib.switchToWindow(driver, "Products");
		driver.findElement(By.name("search_text")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='"+prodName+"']")).click();
		wlib.switchToWindow(driver, "Campaigns");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		/*Step 10: verfify for campaign*/
		String compaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(compaignHeader.contains(campaignName))
		{
			System.out.println(compaignHeader +" campaign created");
		}
		else
		{
			System.out.println("contact not created");
		}
		
		
		
	}
	
	

}
