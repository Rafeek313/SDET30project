package com.crm.GenericLibrary;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//create object of all utilities
	public PropertyFileUtility plib=new PropertyFileUtility();
	public ExcelFileUtility elib=new ExcelFileUtility();
	public JavaUtility jlib=new JavaUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;
@BeforeSuite(groups= {"smokesuite","regression"})
public void connectDataBase() throws Throwable {
	//dlib.connectiondb();
	Reporter.log("=====connection db successful====",true);
}
@BeforeClass(groups= {"smokesuite","regression"})
//@Parameters("browser")
//@BeforeTest
public void launchBrowser() throws Throwable {
	//read data from property file
    String BROWSER = plib.readDataFromPropertyFile("browser");
	String URL = plib.readDataFromPropertyFile("url");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
	}
	else {
		System.out.println("invalid browser");
	}
	sdriver=driver;
	wlib.maximizeWindow(driver);
	wlib.waitForPageLoad(driver);
	driver.get(URL);
	Reporter.log("launching browser successful=====",true);
	}
 
@BeforeMethod(groups= {"smokesuite","regression"})
public void login() throws Throwable {
	String USERNAME = plib.readDataFromPropertyFile("username");
	String PASSWORD = plib.readDataFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.Login(USERNAME, PASSWORD);
	Reporter.log("=====login  app successful====",true);
}
	
@AfterMethod(groups= {"smokesuite","regression"})
public void logout() {
	HomePage hp=new HomePage(driver);
	hp.SignOutLnk(driver);
	Reporter.log("======logout app successfull",true);
}
@AfterClass(groups= {"smokesuite","regression"})
//@AfterTest
public void closeBrowser() {
	driver.quit();
	Reporter.log("====== close browser successfull",true);
}
@AfterSuite(groups= {"smokesuite","regression"})
public void closeDb() throws SQLException {
	//dlib.closeDB();
	Reporter.log("======db close successfull",true);
}
}
