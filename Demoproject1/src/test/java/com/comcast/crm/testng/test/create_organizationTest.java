package com.comcast.crm.testng.test;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class create_organizationTest extends baseclass {

	@Test (groups = {"smokeTest","RegressionTest"})
	public void creatorg() throws IOException, InterruptedException {

		homepage home=new homepage(driver);
		home.getOrganizationslink().click();
		org_page org=new org_page(driver);
		org.getCreateneworg().click();

		//get data from the excel sheet and enter into org name text field
		create_org_page createorg=new create_org_page(driver);
		int rn = java.createrandomnumber();
		String data = excel.getdatafromexcelsheet("ORG", 1, 2)+rn;
		createorg.createorg(data);

		Thread.sleep(2000);
		Org_information_page infopage=new Org_information_page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		Reporter.log(actualresult,true);
		SoftAssert sassert=new SoftAssert();
		boolean result = actualresult.contains(expectedresult);
		sassert.assertTrue(result);
		sassert.assertAll();

		//write back to excel sheet
		int row = excel.getlastrow("createORG")+1;
		excel.setdataintoexcelsheet("createORG", row, 0, expectedresult);
		excel.setdataintoexcelsheet("createORG", row, 1, orgno);
		excel.setdataintoexcelsheet("createORG", row, 2, cdate);
	}


	@Test(dependsOnMethods = "creatorg")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException, InterruptedException {
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
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();

		//verify the title and phone number
		boolean result = actualresult.contains(expectedresult);
		assertTrue(result);

		SoftAssert sassert=new SoftAssert();
		boolean res = num.contains(phone);
		sassert.assertTrue(res);
		sassert.assertAll();

		//write back to excel sheet
		int row = excel.getlastrow("create_ORG_with_phonenumber")+1;
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 0, expectedresult);
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 1, orgno);
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 2, cdate);
		excel.setdataintoexcelsheet("create_ORG_with_phonenumber", row, 3, phone);

	}

	@Test(groups = "RegressionTest")
	public void createOrganizationWithIndustyryAndType() throws EncryptedDocumentException, IOException, InterruptedException {

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
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();
		
		//verify the title and phone number
		boolean result = actualresult.contains(expectedresult);
		assertTrue(result);
		SoftAssert sassert=new SoftAssert();
		boolean res = num.contains(phone);
		sassert.assertTrue(res);
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

	@Test(groups = "RegressionTest")
	public void createOrganizationAndDelete() throws InterruptedException, EncryptedDocumentException, IOException {

		homepage home=new homepage(driver);
		home.getOrganizationslink().click();
		org_page org=new org_page(driver);
		org.getCreateneworg().click();


		//get data from the excel sheet and enter into org name text field
		create_org_page createorg=new create_org_page(driver);
		int rn = java.createrandomnumber();
		String data = excel.getdatafromexcelsheet("ORG", 1, 2)+rn;
		createorg.createorg(data);

		Thread.sleep(2000);
		//get the title and id from org page 
		Org_information_page infopage=new Org_information_page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		Reporter.log(actualresult,true);
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();


		//verify the org name is same 
		boolean result = actualresult.contains(expectedresult);
		assertTrue(result);

		//write back to excel sheet
		int row = excel.getlastrow("createORG")+1;
		excel.setdataintoexcelsheet("createORG", row, 0, expectedresult);
		excel.setdataintoexcelsheet("createORG", row, 1, orgno);
		excel.setdataintoexcelsheet("createORG", row, 2, cdate);

		home.getOrganizationslink().click();
		org.getSearchtextfield().sendKeys(data);
		wd.selectdropdown(org.getSearchdropdown(), "Organization Name");
		org.getSearchbutton().click();

		Thread.sleep(2000);
		//delete the org
		driver.findElement(By.xpath("//a[text()='"+data+"']/../../td[8]/a[text()='del']")).click();

		wd.switchalerttoaccept(driver);
      
	}

}
