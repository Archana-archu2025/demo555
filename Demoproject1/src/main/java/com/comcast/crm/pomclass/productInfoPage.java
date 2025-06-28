package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productInfoPage {

	@FindBy(className ="lvtHeaderText")
	private WebElement headermassage;
	@FindBy(xpath  ="//td[text()='Product Name']/..//span[@id='dtlview_Product Name']")
	private WebElement productnametextfield;
	@FindBy(xpath  ="//td[text()='Product No']/following-sibling::td")
	private WebElement productnotextfield;
	@FindBy(xpath  ="//td[text()='Product Category']/..//span[@id='dtlview_Product Category']")
	private WebElement ProductCategorydropdown;
	@FindBy(xpath  ="//td[text()='Sales Start Date']/../td[@id='mouseArea_Sales Start Date']")
	private WebElement startdatetextfield;
	@FindBy(xpath  ="//td[text()='Sales End Date']/../td[@id='mouseArea_Sales End Date']")
	private WebElement enddatetextfield;


	public productInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	public WebElement getHeadermassage() {
		return headermassage;
	}


	public WebElement getProductnametextfield() {
		return productnametextfield;
	}


	public WebElement getProductnotextfield() {
		return productnotextfield;
	}


	public WebElement getProductCategorydropdown() {
		return ProductCategorydropdown;
	}


	public WebElement getStartdatetextfield() {
		return startdatetextfield;
	}


	public WebElement getEnddatetextfield() {
		return enddatetextfield;
	}
	
	
	
}
