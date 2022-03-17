package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateNewContactsPage;
import com.crm.ObjectRepository.CreateNewOrgPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithMultipleDatatests {
	//Create Obj for all utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "ContacttestData")
	public void createOrgWithMltipleData(String LastName) throws Throwable
	{
		
		
		//read data 
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String lstname = LastName+jLib.getRandomNumber();
	
		//launch the application
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
		
		//navigate to contact
		HomePage hp = new HomePage(driver);
		hp.contactlink();
		Reporter.log("navigated to contact link",true);
		
		//click on new contact
		ContactsPage cp = new ContactsPage(driver);
		cp.ContactPage();;
		Reporter.log("click on create contactlink",true);
		
		//create new contact
		CreateNewContactsPage cop = new CreateNewContactsPage(driver);
		cop.CreateNewContactWithLastName(lstname);
		Reporter.log("create contact with lastname",true);
		//validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actHeader = cip.ContactInfo();
		
		if (actHeader.contains(lstname)) {
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification successful",true);		
		
		//logout
		hp.SignOutLnk(driver);
		
		driver.quit();
	}
	
	@DataProvider(name = "ContacttestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("ContactMultipleData");
		return data;
	}
}
