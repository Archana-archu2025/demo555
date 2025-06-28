package com.comcast.crm.pomclass;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class cerateNewProductPage {
	@FindBy(name = "productname")
	private WebElement productnametextfield;
	@FindBy(name = "productcategory")
	private WebElement productcategorydropdown;
	@FindBy(name = "sales_start_date")
	private WebElement salesstartdatetextfield;
	@FindBy(name = "sales_end_date")
	private WebElement salesenddatetextfield;
	@FindBy(name = "button")
	private WebElement savebuttion;
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorlookup;
	
	 public javautility java=new javautility();
	
	public cerateNewProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getProductnametextfield() {
		return productnametextfield;
	}


	public void getproductcategorydropdown() {
		webdriverutility wd=new webdriverutility();
		int category = java.createrandomnumberforcategory();
		wd.selectdropdownindex(productcategorydropdown, category);
	}


	public void getSalesstartdatetextfield() {
		salesstartdatetextfield.sendKeys(java.getdatepuledays().toString());
	}


	public void getSalesenddatetextfield() {
		salesenddatetextfield.sendKeys(java.getdate().toString());
		
	}


	public WebElement getVendorlookup() {
		return vendorlookup;
	}


	public WebElement getSavebuttion() {
		return savebuttion;
	}



	
}
