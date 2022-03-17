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
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateNewOrgPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

public class SearchOrgByOrgNameTests extends BaseClass {
	@Test
	public void searchOrgByOrgNameTests() throws Throwable {
		String orgName = elib.readDataFromExcel("Org", 1, 2);
		String Searchdrpdwn = elib.readDataFromExcel("OrgMultipleData", 2, 3);
		
		HomePage hp=new HomePage(driver);
		hp.orglink();
		OrganizationPage op=new OrganizationPage(driver);
		op.searchBox(orgName, Searchdrpdwn);
		
		
}

}
