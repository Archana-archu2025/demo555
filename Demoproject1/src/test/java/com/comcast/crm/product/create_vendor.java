package com.comcast.crm.product;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.generic.fileutiity.execelsheetutility;
import com.comcast.crm.generic.fileutiity.propertyfileutility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.pomclass.createNewVendorPage;
import com.comcast.crm.pomclass.homepage;
import com.comcast.crm.pomclass.loginpage;
import com.comcast.crm.pomclass.vendorInfoPage;
import com.comcast.crm.pomclass.vendorpage;

public class create_vendor  extends baseclass {
@Test
	public  void createvendor() throws IOException {
		
		
		//navigate to new contact page
		homepage home=new homepage(driver);
		home.getMorelink(driver);
		home.getVendorslink().click();
		
		vendorpage vendor=new vendorpage(driver);
		vendor.getnewvendor().click();
		
		createNewVendorPage newvendor=new createNewVendorPage(driver);
		String vendarname=excel.getdatafromexcelsheet("vendor", 1, 0)+java.createrandomnumber();
		long phone = java.createrandomphonenumber();
		String phonenum = String.valueOf(phone);
		newvendor.getVendornametextfield().sendKeys(vendarname);
		newvendor.getPhonetextfield().sendKeys(phonenum);
		newvendor.getSavebutton().click();
		
		vendorInfoPage vendorinfo=new vendorInfoPage(driver);
		String headermassage = vendorinfo.getHeadermassage().getText();
		WebElement name = vendorinfo.getVendorNametextfield();
		String phonenumber = vendorinfo.getPhonenumbertextfield().getText();
		String vederno = vendorinfo.getVendornotextfield().getText();
		
		assertTrue(headermassage.contains(vendarname));
		
		SoftAssert sassert=new SoftAssert();
		sassert.assertEquals(phonenum, phonenumber);
		
		int row = excel.getlastrow("vendorinfo")+1;
		excel.setdataintoexcelsheet("vendorinfo", row, 0, vendarname);
		excel.setdataintoexcelsheet("vendorinfo", row, 1, phonenumber);
		excel.setdataintoexcelsheet("vendorinfo", row, 2, vederno);
		

	}

}
