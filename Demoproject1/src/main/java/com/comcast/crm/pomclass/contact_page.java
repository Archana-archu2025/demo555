package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contact_page {
  @FindBy(css = "img[title='Create Contact...']")
  private WebElement createnewcontactbutton;
  
  
  public contact_page(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }


public WebElement getCreatenewcontactbutton() {
	return createnewcontactbutton;
}
  
}
