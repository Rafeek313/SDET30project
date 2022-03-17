package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleCalenderPopupTest {
@Test
public void calender() {
	String date = "12";
	String month = "December 2022";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	Actions a=new Actions(driver);
	a.moveByOffset(10,10).click().perform();
	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	 String dateXpath = "//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	String arrowxpath = "//span[@aria-label=\"Next Month\"]";

	for(;;) {
	try {
		driver.findElement(By.xpath(dateXpath)).click();
        break;
	}
	catch(Exception e){
		driver.findElement(By.xpath(arrowxpath)).click();
	}
	}
	
	
	
}
}
