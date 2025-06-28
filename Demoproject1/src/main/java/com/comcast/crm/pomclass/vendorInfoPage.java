package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorInfoPage {
	
	@FindBy(className ="lvtHeaderText")
	private WebElement headermassage;
	@FindBy(xpath  ="//td[text()='Vendor Name']/../td[@id='mouseArea_Vendor Name']")
	private WebElement VendorNametextfield;
	@FindBy(xpath  ="(//td[@class='dvtCellInfo'])[2]")
	private WebElement vendornotextfield;
	@FindBy(xpath  ="//td[text()='Phone']/../td[@id='mouseArea_Phone']")
	private WebElement phonenumbertextfield;
	


	public vendorInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}



	public WebElement getHeadermassage() {
		return headermassage;
	}



	public WebElement getVendorNametextfield() {
		return VendorNametextfield;
	}



	public WebElement getVendornotextfield() {
		return vendornotextfield;
	}



	public WebElement getPhonenumbertextfield() {
		return phonenumbertextfield;
	}

}
