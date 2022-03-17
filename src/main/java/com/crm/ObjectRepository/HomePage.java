package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
@FindBy(linkText = "Leads")
private WebElement leadlnk;
@FindBy(linkText = "Organizations")
private WebElement Orglnk;
@FindBy(linkText = "Contacts")
private WebElement contctlnk;
@FindBy(linkText = "Products")
private WebElement Prdctlnk;
@FindBy(linkText = "Opportunities")
private WebElement opprtnlnk;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administrationlnk;
@FindBy(xpath="//a[.='Sign Out']")
private WebElement SignOutlnk;
@FindBy(xpath = "//a[.='More']")
private WebElement morelnk;
@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
private WebElement homeBtn;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getLeadlnk() {
	return leadlnk;
}
public WebElement getOrglnk() {
	return Orglnk;
}
public WebElement getContctlnk() {
	return contctlnk;
}
public WebElement getPrdctlnk() {
	return Prdctlnk;
}
public WebElement getOpprtnlnk() {
	return opprtnlnk;
}
public WebElement getMorelnk() {
	return morelnk;
}
public WebElement getSignOutlnk1() {
	return SignOutlnk;
}

public WebElement getHomeBtn() {
	return homeBtn;
}
public void leadlink() {
	leadlnk.click();
}
public void orglink() {
	Orglnk.click();
}

public WebElement getAdministrationlnk() {
	return administrationlnk;
}
public WebElement getSignOutlnk() {
	return SignOutlnk;
}
public void contactlink() {
	contctlnk.click();
}
public void productlink() {
	Prdctlnk.click();
}
public void opportunitylink() {
	opprtnlnk.click();
}
public void SignOutLnk(WebDriver driver) {
	mousehover(driver, administrationlnk);
	SignOutlnk.click();
}
public void homebtnClick() {
	homeBtn.click();
}

}
