package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
	
	public WebDriver selectbrowser(String browser) {
		WebDriver driver=null;
		if(browser.contains("chrome"))
		{
			return driver=new ChromeDriver();
		}	
		else if(browser.contains("firefox")) {
			return driver=new FirefoxDriver();
		}else
		{
			return driver=new ChromeDriver();
		}
		
	}
	
	public Timeouts getimplicitwait(WebDriver driver) {
		
		Timeouts wait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return wait;
	}
	
	public void getexpilicitywaitfordd(WebDriver driver, WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public  void switchwindow(WebDriver driver,String partiletitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			String id = it.next();
			driver.switchTo().window(id);
			
			@Nullable
			String acturl = driver.getTitle();
			if(acturl.contains(partiletitle)) {
				break;
			}
		}
		 
	}
	
	public void switchtoframe(WebDriver driver,int index) {
		 driver.switchTo().frame(index);
	}
    
	public void switchtoframe(WebDriver driver,String name) {
		 driver.switchTo().frame(name);
	}
	
	public void switchtoframe(WebDriver driver,WebElement element) {
		 driver.switchTo().frame(element);
	}
	
	public void switchtoframe(WebDriver driver) {
		 driver.switchTo().parentFrame();
	}
	
	public void selectdropdown(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void selectdropdownindex(WebElement element,int i) {
		Select s=new Select(element);
		s.selectByIndex(i);
		
	}
	
	public void switchalerttoaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchalerttodissmiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
}
