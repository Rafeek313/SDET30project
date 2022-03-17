package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MorePage {
	@FindBy(xpath = "//a[.='More']")
	private WebElement morelnk;
	public MorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getMorelnk() {
		return morelnk;
	}
	
}
