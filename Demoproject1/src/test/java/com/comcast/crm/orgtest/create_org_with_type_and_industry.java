package com.comcast.crm.orgtest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.baseclass;
import com.comcast.crm.generic.fileutiity.execelsheetutility;
import com.comcast.crm.generic.fileutiity.propertyfileutility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.pomclass.Org_information_page;
import com.comcast.crm.pomclass.create_org_page;
import com.comcast.crm.pomclass.homepage;
import com.comcast.crm.pomclass.loginpage;
import com.comcast.crm.pomclass.org_page;

public class create_org_with_type_and_industry extends baseclass {
	
	@Test(groups = "RegressionTest")
	public  void orgWithTypeAndIndustry() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		//navigate to new organization page
		homepage home=new homepage(driver);
		home.getOrganizationslink().click();
		org_page org=new org_page(driver);
		org.getCreateneworg().click();
		
		//get data from the excel sheet and enter into org name text field
		create_org_page createorg=new create_org_page(driver);
		int rn = java.createrandomnumber();
		String data = excel.getdatafromexcelsheet("ORG", 1, 2)+rn;
		
		//generate phone number and enter into phone text field
		long phonenum = java.createrandomphonenumber();
	    String num = String.valueOf(phonenum);
	    
		int indusrtyran = java.createrandomnumberforindustry();
		int typeran = java.createrandomnumberfortype();
		createorg.createorg(data, num, indusrtyran, typeran);
		
		Thread.sleep(2000);
		//get the title and id from org page 
		Org_information_page infopage=new Org_information_page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		Reporter.log(actualresult,true);
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();
		
		//verify the title and phone number
		assertTrue(actualresult.contains(expectedresult));
		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(phone.contains(num));
		sassert.assertAll();

		
		//write back to excel sheet
		int row = excel.getlastrow("create_ORG_with_typenadindustry")+1;
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 0, expectedresult);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 1, orgno);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 2, cdate);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 3, phone);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 4, industry);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 5, type);

		
		

	}

	}


