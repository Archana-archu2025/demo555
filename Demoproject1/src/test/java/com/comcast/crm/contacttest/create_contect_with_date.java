package com.comcast.crm.contacttest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

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
import com.comcast.crm.pomclass.Create_new_contact_page;
import com.comcast.crm.pomclass.contact_information_page;
import com.comcast.crm.pomclass.contact_page;
import com.comcast.crm.pomclass.homepage;
import com.comcast.crm.pomclass.loginpage;

public class create_contect_with_date extends baseclass {

	@Test (groups = "smokeTest")
	public  void createContact() throws IOException {

		//navigate to new contact page
		homepage home=new homepage(driver);
		home.getContactslink().click();
		contact_page contact=new contact_page(driver);
		contact.getCreatenewcontactbutton().click();

		//get data from the excel sheet and enter into last name text field
		int rn = java.createrandomnumber();
		String exceldata = excel.getdatafromexcelsheet("create_contect", 1, 0);
		String data = exceldata+rn;
		String startdate = java.getdate().toString();
		String enddate = java.getdate().plusDays(30).toString();
		Create_new_contact_page creatcontact=new Create_new_contact_page(driver);
		creatcontact.createcontactwithdate(data, startdate, enddate);

		contact_information_page contactinfo=new contact_information_page(driver);

		String actualheader = contactinfo.getHeadermassage().getText();
		String contactid = contactinfo.getContactid().getText();
		Reporter.log(actualheader,true);
       
		assertTrue(actualheader.contains(data));

		String actualstartdate = contactinfo.getStartdate().getText();

		//verification of start date
		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(actualstartdate.contains(startdate));

		String actualenddate = contactinfo.getEnddate().getText();
		sassert.assertTrue(actualenddate.contains(enddate));
		sassert.assertAll();

		int row = excel.getlastrow("create_contect_with_date")+1;
		excel.setdataintoexcelsheet("create_contect_with_date", row, 0, data);
		excel.setdataintoexcelsheet("create_contect_with_date", row, 1, contactid);
		excel.setdataintoexcelsheet("create_contect_with_date", row, 2, startdate);
		excel.setdataintoexcelsheet("create_contect_with_date", row, 3, enddate);

		
	}

}
