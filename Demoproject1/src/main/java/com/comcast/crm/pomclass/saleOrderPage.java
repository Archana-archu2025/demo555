package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class saleOrderPage {
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement newsaleorder;

	public saleOrderPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getnewsaleorder() {
		return newsaleorder;
	}
}
