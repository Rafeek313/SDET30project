package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.BaseClass;

public class OrganizationPage extends BaseClass {
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement clickonOrgLookUpImg;
	@FindBy(name="search_text")
	private WebElement searchTbx;
	@FindBy(xpath="(//input[@value=' Search Now '])[1]")
	private WebElement searchnwBtn;
	@FindBy(xpath="(//select[@id='bas_searchfield'])[1]")
	private WebElement orgdrpdwnTbx;
	public  OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickonOrgLookUpImg() {
		return clickonOrgLookUpImg;
	}
	
	public WebElement getSearchTbx() {
		return searchTbx;
	}
	public WebElement getSearchnwBtn() {
		return searchnwBtn;
	}

	public WebElement getOrgdrpdwnTbx() {
		return orgdrpdwnTbx;
	}

	public void organizationPage() {
		clickonOrgLookUpImg.click();
	}
	public void searchBox(String SearchOrgName,String Searchdrpdwn) {
		searchTbx.sendKeys(SearchOrgName);
		wlib.select(Searchdrpdwn, orgdrpdwnTbx);
		searchnwBtn.click();
	}

	
}
