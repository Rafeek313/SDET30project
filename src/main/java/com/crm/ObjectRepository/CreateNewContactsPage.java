package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility{
	@FindBy(name="lastname")
	private WebElement lastNameTbx;
	@FindBy(xpath="(//img[@alt=\"Select\"])[1]")
	private WebElement clickonOrgNameLookUpImg;
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;
	@FindBy(name="search_text")
	private WebElement searchTbx;
	@FindBy(name="search")
	private WebElement searchNowBtn;
	public  CreateNewContactsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}


			public WebElement getLastNameTbx() {
		return lastNameTbx;
	}


	public WebElement getClickonOrgNameLookUpImg() {
		return clickonOrgNameLookUpImg;
	}


			public WebElement getSaveBtn() {
		return saveBtn;
	}
			public void CreateNewContactWithLastName(String LastName) {
				lastNameTbx.sendKeys(LastName);
				saveBtn.click();
				
			}
			public void CreateNewContactWithLastName(String LastName,WebDriver driver,String OrgName ) {
				lastNameTbx.sendKeys(LastName);
				switchToWindow(driver, "Accounts");
				searchTbx.sendKeys(OrgName);
				searchNowBtn.click();
				switchToWindow(driver, "Contacts");
				saveBtn.click();
				
			}
			
}
