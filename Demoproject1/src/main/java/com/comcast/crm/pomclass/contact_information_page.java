package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contact_information_page {
	 @FindBy(className = "dvHeaderText")
	  private WebElement headermassage;
	 @FindBy(xpath = "//td[text()='Contact Id']/following-sibling::td")
	  private WebElement contactid;
	 @FindBy(xpath = "//td[text()='Support Start Date']/following-sibling::td")
	  private WebElement startdate;
	 @FindBy(xpath = "//td[text()='Support End Date']/following-sibling::td")
	  private WebElement enddate;
	
	 public contact_information_page(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	 
	 
	 public WebElement getHeadermassage() {
		return headermassage;
	}


	public WebElement getContactid() {
		return contactid;
	}


	public WebElement getStartdate() {
		return startdate;
	}


	public WebElement getEnddate() {
		return enddate;
	}


	
	 
	
}
