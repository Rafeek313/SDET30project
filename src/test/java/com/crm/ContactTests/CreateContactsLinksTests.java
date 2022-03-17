package com.crm.ContactTests;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactsPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactsLinksTests extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
		String ContName = elib.readDataFromExcel("Contacts", 1, 2)+jlib.getRandomNumber();
		/*create contact with mandatory field*/
		HomePage hp=new HomePage(driver);
		hp.contactlink();
		ContactsPage cp=new ContactsPage(driver);
		cp.ContactPage();
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.CreateNewContactWithLastName(ContName);
	}
}
