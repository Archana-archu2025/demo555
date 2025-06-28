package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorpage {
	@FindBy(css = "img[title='Create Vendor...']")
	private WebElement newvendor;

	public vendorpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getnewvendor() {
		return newvendor;
	}
	
}
