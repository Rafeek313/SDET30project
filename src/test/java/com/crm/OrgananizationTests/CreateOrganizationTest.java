package com.crm.OrgananizationTests;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass {
@Test

public void createOrganizationTest() throws IOException, Throwable{
	String lastName = elib.readDataFromExcel("Contacts", 1, 2)+jlib.getRandomNumber();
HomePage hp=new HomePage(driver);
hp.contactlink();
ContactsPage cp=new ContactsPage(driver);
cp.ContactPage();
CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
cncp.CreateNewContactWithLastName(lastName);
}
}
