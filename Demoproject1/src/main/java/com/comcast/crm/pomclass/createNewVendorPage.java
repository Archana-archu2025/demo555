package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewVendorPage {
	@FindBy(name = "vendorname")
	private WebElement vendornametextfield;
	@FindBy(name = "button")
	private WebElement savebutton;
	@FindBy(id = "phone")
	private WebElement phonetextfield;
	
	
	public createNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getVendornametextfield() {
		return vendornametextfield;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getPhonetextfield() {
		return phonetextfield;
	}
	
	
}
