package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewPurchaseOrderpage {
	@FindBy(name = "subject")
	private WebElement subjecttextfield;
	@FindBy(name = "postatus")
	private WebElement postatusdropdown;
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorname;
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img")
	private WebElement contact;
	@FindBy(name = "bill_street")
	private WebElement billingaddresstextfield;
	@FindBy(name = "ship_street")
	private WebElement shippingaddresstextfield;
	@FindBy(xpath = "//input[@name='productName1']/following-sibling::img")
	private WebElement product;
	@FindBy(name = "button")
	private WebElement savebutton;
	
	
	public createNewPurchaseOrderpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
