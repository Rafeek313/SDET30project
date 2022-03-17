package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility{
	@FindBy(name="accountname")
	private WebElement orgNameTbx;
	@FindBy(name="industry")
	private WebElement industryDrpDwn;
	@FindBy(name="accounttype")
	private WebElement typeDrpDwn;
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;
	public  CreateNewOrgPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
			}


			public WebElement getSaveBtn() {
		return saveBtn;
	}


			public WebElement getOrgNameTbx() {
				return orgNameTbx;
			}
			public WebElement getIndustryDrpDwn() {
				return industryDrpDwn;
			}
			public WebElement getTypeDrpDwn() {
				return typeDrpDwn;
			}

public void createNewOrgWithOrgName(String OrgName) {
	orgNameTbx.sendKeys(OrgName);
	saveBtn.click();	
}
public void createNewOrgWithIndType(String OrgName,String indType) {
	orgNameTbx.sendKeys(OrgName);
	select(indType, industryDrpDwn);
	saveBtn.click();	
}
public void createNewOrgIndTypeWithType(String OrgName,String indType,String type) {
	orgNameTbx.sendKeys(OrgName);
	select(indType, industryDrpDwn);
	typeDrpDwn.sendKeys(type);
	select(type, typeDrpDwn);
	saveBtn.click();	
}	
}
