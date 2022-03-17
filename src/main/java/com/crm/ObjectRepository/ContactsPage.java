package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath = "//img[@alt=\"Create Contact...\"]")
	private WebElement clickonContactLookUpImg;
	
	public  ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getClickonContactLookUpImg() {
		return clickonContactLookUpImg;
	}
	public void ContactPage() {
		clickonContactLookUpImg.click();
	}
			
}
