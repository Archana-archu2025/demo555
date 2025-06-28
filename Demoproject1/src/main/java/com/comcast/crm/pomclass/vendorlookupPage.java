package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorlookupPage {

	@FindBy(id  ="search_txt")
	private WebElement VendorNametextfield;
	@FindBy(name  ="search")
	private WebElement button;
	
	public vendorlookupPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNametextfield() {
		return VendorNametextfield;
	}

	public WebElement getButton() {
		return button;
	}

	
	
}
