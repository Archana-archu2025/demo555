package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class org_page {
   
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement createneworg;
	@FindBy(name = "search_text")
	private WebElement searchtextfield;
	@FindBy(id = "bas_searchfield")
	private WebElement searchdropdown;
	@FindBy(name = "submit")
	private WebElement searchbutton;
	
	public org_page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateneworg() {
		return createneworg;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}
}
