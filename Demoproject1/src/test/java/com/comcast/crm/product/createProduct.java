package com.comcast.crm.product;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.generic.fileutiity.execelsheetutility;
import com.comcast.crm.generic.fileutiity.propertyfileutility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.pomclass.cerateNewProductPage;
import com.comcast.crm.pomclass.homepage;
import com.comcast.crm.pomclass.loginpage;
import com.comcast.crm.pomclass.productInfoPage;
import com.comcast.crm.pomclass.productPage;
import com.comcast.crm.pomclass.vendorlookupPage;

public class createProduct extends baseclass {
   @Test
	public  void createproduct() throws IOException
	{
	
		//navigate to new contact page
		homepage home=new homepage(driver);
		home.getProductslink().click();
		
		productPage productpg=new productPage(driver);
		productpg.getnewproduct().click();
		
		cerateNewProductPage createproduct=new cerateNewProductPage(driver);
		String productname = excel.getdatafromexcelsheet("product", 1, 0)+java.createrandomnumber();
		createproduct.getProductnametextfield().sendKeys(productname);
		createproduct.getproductcategorydropdown();
		createproduct.getSalesstartdatetextfield();
		createproduct.getSalesenddatetextfield();
		createproduct.getVendorlookup().click();
		
		String partialtext = "Vendors&action";
		wd.switchwindow(driver, partialtext);
		vendorlookupPage vendorlookup=new vendorlookupPage(driver);
		int row = excel.getlastrow("vendorinfo");
		String vendorname = excel.getdatafromexcelsheet("vendorinfo", row, 0);
		vendorlookup.getVendorNametextfield().sendKeys(vendorname);
		vendorlookup.getButton().click();
		boolean name = driver.findElement(By.xpath("//a[text()='"+vendorname+"']")).isDisplayed();
		System.out.println(name);
		assertTrue(name);
		driver.quit();
		
		productInfoPage product=new productInfoPage(driver);
		String headermassage = product.getHeadermassage().getText();
		String productname1 = product.getProductnametextfield().getText();
		String sdate = product.getStartdatetextfield().getText();
		String edate = product.getEnddatetextfield().getText();
		String productcategory = product.getProductCategorydropdown().getText();
		String productno = product.getProductnotextfield().getText();
		
		int row1=excel.getlastrow("productinfo")+1;
		excel.setdataintoexcelsheet("productinfo", row1, 0, productname1);
		excel.setdataintoexcelsheet("productinfo", row1, 1, productno);
		excel.setdataintoexcelsheet("productinfo", row1, 2, productcategory);
		excel.setdataintoexcelsheet("productinfo", row1, 3, sdate);
		excel.setdataintoexcelsheet("productinfo", row1, 4, edate);
		
		
		
	}

}
