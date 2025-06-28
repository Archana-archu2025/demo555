package com.comcast.crm.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	@FindBy(name ="user_name")
	private WebElement usernametextfield;
	@FindBy(name ="user_password")
	private WebElement passwordtextfield;
	@FindBy(id ="submitButton")
	private WebElement loginbuttion;
	
	public loginpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
    
	public void login(String username, String password) {
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		loginbuttion.click();
	}
}
