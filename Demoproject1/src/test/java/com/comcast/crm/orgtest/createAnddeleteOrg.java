package com.comcast.crm.orgtest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

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

public class createAnddeleteOrg extends baseclass{

	@Test(groups = "RegressionTest")
	public  void deletorg() throws IOException, InterruptedException {

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
		assertTrue(actualresult.contains(expectedresult));

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
