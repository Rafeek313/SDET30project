package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement successfulMsg;
public OrganizationInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getSuccessfulMsg() {
	return successfulMsg;
}
public String OrgNameInfo() {
	 String text = successfulMsg.getText();
	 return text;
}
}
