package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Org_lookup_page {
	@FindBy(id ="search_txt")
	private WebElement searchtextfield;
	@FindBy(name ="search")
	private WebElement searchbutton;
	@FindBy(xpath ="//a[@href='javascript:window.close();']")
	private WebElement orgname;
	
	public Org_lookup_page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getOrgname() {
		return orgname;
	}
	
	
}
