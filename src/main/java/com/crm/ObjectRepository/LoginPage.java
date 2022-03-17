package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(name="user_name")
private WebElement untbx;
@FindBy(name="user_password")
private WebElement pwdbx;
@FindBy(id="submitButton")
private WebElement lgnbtn;
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getUntbx() {
	return untbx;
}
public WebElement getPwdbx() {
	return pwdbx;
}
public WebElement getLgnbtn() {
	return lgnbtn;
}
public void Login(String un,String pw) {
	untbx.sendKeys(un);
	pwdbx.sendKeys(pw);
	lgnbtn.click();
}
}
