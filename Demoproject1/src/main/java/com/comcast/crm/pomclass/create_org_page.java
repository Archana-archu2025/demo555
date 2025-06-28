package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class create_org_page {

	@FindBy(name = "accountname")
	private WebElement ogrnametextfield;
	@FindBy(id ="phone")
	private WebElement phonenumbertextfield;
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	@FindBy(name = "accounttype")
	private WebElement typedropdown;
	@FindBy(name = "button")
	private WebElement savebutton;
	

	public create_org_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

	public void createorg(String orgname) {

		ogrnametextfield.sendKeys(orgname);
		savebutton.click();
	}
	
	public void createorg(String orgname,String phone) {

		ogrnametextfield.sendKeys(orgname);
		phonenumbertextfield.sendKeys(phone);
		savebutton.click();
	}

	public void createorg(String orgname,String phone,String industry, String type) {

		ogrnametextfield.sendKeys(orgname);
		phonenumbertextfield.sendKeys(phone);
		webdriverutility wb=new webdriverutility();
		wb.selectdropdown(industrydropdown, industry);
		wb.selectdropdown(typedropdown, type);
		savebutton.click();
	}

	public void createorg(String orgname,String phone,int industryindex, int typeindex) {

		ogrnametextfield.sendKeys(orgname);
		phonenumbertextfield.sendKeys(phone);
		webdriverutility wb=new webdriverutility();
		wb.selectdropdownindex(industrydropdown, industryindex);
		wb.selectdropdownindex(typedropdown, typeindex);
		savebutton.click();
	}




	public WebElement getOgrnametextfield() {
		return ogrnametextfield;
	}




	public WebElement getPhonenumbertextfield() {
		return phonenumbertextfield;
	}




	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}




	public WebElement getTypedropdown() {
		return typedropdown;
	}




	public WebElement getSavebutton() {
		return savebutton;
	}
	



}
