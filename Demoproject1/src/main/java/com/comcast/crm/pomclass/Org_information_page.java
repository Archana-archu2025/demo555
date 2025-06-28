package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Org_information_page {
	@FindBy(className ="dvHeaderText")
	private WebElement headermassage;
	@FindBy(xpath  ="//td[text()='Organization No']/following-sibling::td")
	private WebElement orgnizationnumber;
	@FindBy(xpath ="//td[text()='Created Time']/following-sibling::td")
	private WebElement createddate;
	@FindBy(id ="mouseArea_Phone")
	private WebElement phonenumber;
	@FindBy(id ="dtlview_Industry")
	private WebElement industrydropdown;
	@FindBy(id ="dtlview_Type")
	private WebElement typedropdown;
	

	
	public Org_information_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getPhonenumber() {
		return phonenumber;
	}


	public WebElement getHeadermassage() {
		return headermassage;
	}


	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}


	public WebElement getTypedropdown() {
		return typedropdown;
	}


	public WebElement orgnizationnumber() {
		return orgnizationnumber;
	}


	public WebElement getCreateddate() {
		return createddate;
	}
	
	
}
