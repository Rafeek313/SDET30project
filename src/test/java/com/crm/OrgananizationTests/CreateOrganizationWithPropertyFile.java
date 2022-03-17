package com.crm.OrgananizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateNewOrgPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithPropertyFile extends BaseClass {
@Test


public void createOrgTest() throws Throwable {
	String orgName = elib.readDataFromExcel("Org", 7, 2)+jlib.getRandomNumber();
	HomePage hp=new HomePage(driver);
	hp.orglink();
	OrganizationPage op=new OrganizationPage(driver);
	op.organizationPage();
	CreateNewOrgPage cnp=new CreateNewOrgPage(driver);
	cnp.createNewOrgWithOrgName(orgName);
	Reporter.log("org created successful",true);
	}

}

