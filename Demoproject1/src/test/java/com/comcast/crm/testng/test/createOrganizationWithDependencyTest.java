package com.comcast.crm.testng.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.fileutiity.execelsheetutility;
import com.comcast.crm.generic.fileutiity.propertyfileutility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.pomclass.Org_information_page;
import com.comcast.crm.pomclass.create_org_page;
import com.comcast.crm.pomclass.homepage;
import com.comcast.crm.pomclass.loginpage;
import com.comcast.crm.pomclass.org_page;

public class createOrganizationWithDependencyTest {
	WebDriver driver;
	propertyfileutility pf=new propertyfileutility();
	webdriverutility wd=new webdriverutility();
	loginpage loginpage1=new loginpage(driver);
	execelsheetutility excel=new execelsheetutility();
	javautility java=new javautility();
	homepage home=new homepage(driver);
	org_page org=new org_page(driver);
	create_org_page createorg=new create_org_page(driver);
	String data=null;
	String num = null;

	@Test
	public void login() throws IOException {
		//getting data from property file
		propertyfileutility pf=new propertyfileutility();
		String browser = pf.getdatafromthepropertyfile("browser");
		String url = pf.getdatafromthepropertyfile("url");
		String username1 = pf.getdatafromthepropertyfile("username");
		String password1 = pf.getdatafromthepropertyfile("password");

		//browser launching and login 
		driver = wd.selectbrowser(browser);
		driver.get(url);
		loginpage loginpage1=new loginpage(driver);
		loginpage1.login(username1,password1);


	}

	@Test(dependsOnMethods = "login")
	public void createOrg() throws EncryptedDocumentException, IOException {
		homepage home=new homepage(driver);
		home.getOrganizationslink().click();

		org_page org=new org_page(driver);
		org.getCreateneworg().click();

		javautility java=new javautility();
		int rn = java.createrandomnumber();

		execelsheetutility excel=new execelsheetutility();
		data = excel.getdatafromexcelsheet("ORG", 1, 2)+rn;

		create_org_page createorg=new create_org_page(driver);
		createorg.getOgrnametextfield().sendKeys(data);


	}
	@Test(dependsOnMethods = "createOrg")
	public void createphonenumber() {
		javautility java=new javautility();
		long phonenum = java.createrandomphonenumber();
		num = String.valueOf(phonenum);

		create_org_page createorg=new create_org_page(driver);
		createorg.getPhonenumbertextfield().sendKeys(num);


	}
	@Test(dependsOnMethods = "createphonenumber")
	public void createTypeIndustry() throws EncryptedDocumentException, IOException {

		javautility java=new javautility();
		int indusrtyran = java.createrandomnumberforindustry();
		int typeran = java.createrandomnumberfortype();

		create_org_page createorg=new create_org_page(driver);
		webdriverutility wb=new webdriverutility();
		wb.selectdropdownindex(createorg.getIndustrydropdown(), indusrtyran);
		wb.selectdropdownindex(createorg.getTypedropdown(), typeran);

		createorg.getSavebutton().click();

	}


	@Test(dependsOnMethods = "createTypeIndustry")
	public void verification() throws IOException, InterruptedException {
		//get the title and id from org page 
		Thread.sleep(2000);
		Org_information_page infopage=new Org_information_page(driver);
		String actualresult = infopage.getHeadermassage().getText();
		String expectedresult=data;
		String orgno = infopage.orgnizationnumber().getText();
		String cdate = infopage.getCreateddate().getText();
		String phone = infopage.getPhonenumber().getText();
		String industry = infopage.getIndustrydropdown().getText();
		String type = infopage.getTypedropdown().getText();

		//verify the title and phone number
		assertTrue(actualresult.contains(expectedresult));

		SoftAssert sassert=new SoftAssert();
		sassert.assertTrue(num.contains(phone));
		sassert.assertAll();

		execelsheetutility excel=new execelsheetutility();
		int row = excel.getlastrow("create_ORG_with_typenadindustry")+1;
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 0, expectedresult);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 1, orgno);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 2, cdate);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 3, phone);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 4, industry);
		excel.setdataintoexcelsheet("create_ORG_with_typenadindustry", row, 5, type);
	}


}
