package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.comcast.crm.generic.databaseutility.databaseutility;
import com.comcast.crm.generic.fileutiity.execelsheetutility;
import com.comcast.crm.generic.fileutiity.propertyfileutility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.pomclass.homepage;
import com.comcast.crm.pomclass.loginpage;

public class baseclass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
    public databaseutility db=new databaseutility();
    public propertyfileutility pf=new propertyfileutility();
    public webdriverutility wd=new webdriverutility();
    public execelsheetutility excel=new execelsheetutility();
    public javautility java=new javautility();
   
    
	//@BeforeSuite (groups = {"smokeTest","RegressionTest"})
	public void confiBS() throws SQLException {
		
		db.getconnection();
	}
	//@Parameters("browser")
	@BeforeClass (groups = {"smokeTest","RegressionTest"})
	public void configBC(String browser1) throws IOException {
		String browser = pf.getdatafromthepropertyfile("browser");

		if(browser.contains("chrome"))
		{
			driver=new ChromeDriver();
		}	
		else if(browser.contains("firefox")) {
			 driver=new FirefoxDriver();
		}else
		{
			 driver=new ChromeDriver();
		}
		sdriver=driver;
	}
	
	 
	@BeforeMethod //(groups = {"smokeTest","RegressionTest"})
	public void configBM() throws IOException {
		
		String url = pf.getdatafromthepropertyfile("url");
		String username1 = pf.getdatafromthepropertyfile("username");
		String password1 = pf.getdatafromthepropertyfile("password");
		driver.get(url);
		loginpage loginpage=new loginpage(driver);
		loginpage.login(username1,password1);
	}
	
	@AfterMethod //(groups = {"smokeTest","RegressionTest"})
	public void configAM() {
		 homepage home=new homepage(driver);
		 home.getLogout(driver);
		
	}
	
	@AfterClass //(groups = {"smokeTest","RegressionTest"})
	public void configAC() {
		driver.quit();
	}
	
	@AfterSuite (groups = {"smokeTest","RegressionTest"})
	public void configAS() {
		
	}
}
