package com.comcast.crm.orgtest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class create_org_with_phonenumber extends baseclass {

	//@Test(groups = "smokeTest")
	public  void orgWithPhonenumber() throws IOException, InterruptedException {

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
		createorg.createorg(data, num);

		Thread.sleep(2000);
		//get the title and id from org page 
		Org_information_page infopage=new Org_information_page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		//Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		
		//verify the title and phone number
		//assertTrue(actualresult.contains(expectedresult));
		//SoftAssert sassert=new SoftAssert();
		//sassert.assertTrue(phone.contains(num));
		//sassert.assertAll();

		//write back to excel sheet
		int row = excel.getlastrow("create_ORG_with_phonenumber")+1;
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 0, expectedresult);
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 1, orgno);
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 2, cdate);
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 3, phone);


	}
}

