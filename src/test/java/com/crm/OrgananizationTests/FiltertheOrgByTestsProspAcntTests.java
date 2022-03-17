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
import org.testng.annotations.Test;

public class FiltertheOrgByTestsProspAcntTests {
@Test
public void filtertheOrgByTestsProspAcntTests() throws IOException {
	/*generate random number*/
	Random ran = new Random();
	int random = ran.nextInt(500);
	
	/*Step 1: read all neccessary data*/
	//read data from property file
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("username");
	String PASSWORD = pObj.getProperty("password");
	
	//read data from excel sheet
	FileInputStream fi = new FileInputStream("src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Org");
	Row ro = sh.getRow(10);
	Cell cel = ro.getCell(2);
	String ViewName = cel.getStringCellValue();
	
	/*Step 2: launch the browser*/
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	/*Step 3: login to application*/
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	/*Step 4: Navigate to Organizations Link*/
	driver.findElement(By.linkText("Organizations")).click();
	/*filter the organization by "prospect Accounts" */
	  WebElement filter = driver.findElement(By.id("viewname"));
	  Select s=new Select(filter);
	  s.selectByValue("5");
	  /* create the filter */
	  driver.findElement(By.xpath("//a[.='Create Filter']")).click();
	  driver.findElement(By.xpath("//input[@class=\"detailedViewTextBox\"]")).sendKeys(ViewName);
	  WebElement Assgndpdwn = driver.findElement(By.id("column2"));
	  Select s1=new Select(Assgndpdwn);
	  s1.selectByValue("vtiger_account:website:website:Accounts_Website:V");
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
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
