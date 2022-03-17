package com.crm.PRACTICE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandilingCalenderpopupAbhiTests {
@Test
public void calenderpopup() throws Throwable {
	String date = "12";
	String month = "March";
	String depdate = "13";
	String depmonth = "March";
	String leavingfrom = "Bangalore";
	String destination = "Hyderabad";
	String dateXpath = "//span[text()='"+month+"']/ancestor::div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]/descendant::a[text()='"+date+"']";
	String depdatexpath = "//span[text()='"+depmonth+"']/ancestor::div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]/descendant::a[text()='"+depdate+"']";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.abhibus.com/");
	 driver.findElement(By.id("source")).sendKeys(leavingfrom);
	 Actions action=new Actions(driver);	
	 action.moveByOffset(10, 10).click().perform();
	 Thread.sleep(10000);
	driver.findElement(By.id("destination")).sendKeys(destination);
	 action.moveByOffset(10, 10).click().perform();
	 Thread.sleep(10000);

	driver.findElement(By.id("datepicker1")).click();
	for(;;) {
		try {
	driver.findElement(By.xpath(dateXpath)).click();
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		driver.findElement(By.id("datepicker2")).click();
		for(;;) {
			try {
		driver.findElement(By.xpath(depdatexpath)).click();
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
		}	
}
}
}
