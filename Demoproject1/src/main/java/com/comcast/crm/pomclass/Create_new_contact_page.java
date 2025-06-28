package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_new_contact_page {

	

	@FindBy(name = "lastname")
	private WebElement lastnametextfield;
	@FindBy(name = "support_start_date")
	private WebElement startdate;
	@FindBy(name = "support_end_date")
	private WebElement enddate;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgbutton;
	@FindBy(name = "button")
	private WebElement savebutton;
	
	
	public Create_new_contact_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createcontact(String lastname){
		lastnametextfield.sendKeys(lastname);
		savebutton.click();
	}
  
	public void createcontactwithdate(String lastname,String sdate,String edate) {
		lastnametextfield.sendKeys(lastname);
		startdate.clear();
		startdate.sendKeys(sdate);
		enddate.clear();
		enddate.sendKeys(edate);
	
	}
	public WebElement getOrgbutton() {
		return orgbutton;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	
}
