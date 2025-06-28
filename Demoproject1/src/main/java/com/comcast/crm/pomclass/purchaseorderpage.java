package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class purchaseorderpage
{
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement createneworg;

	public purchaseorderpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateneworg() {
		return createneworg;
	}
	
	
}
