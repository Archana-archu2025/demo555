package com.comcast.crm.pomclass;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class homepage {
    @FindBy(linkText = "Organizations")
    private WebElement organizationslink;
    @FindBy(linkText = "Contacts")
    private WebElement contactslink;
    @FindBy(linkText = "Opportunities")
    private WebElement opportunitieslink;
    @FindBy(linkText = "Products")
    private WebElement productslink;
    @FindBy(linkText = "Vendors")
    private WebElement Vendorslink;
    @FindBy(linkText = "More")
    private WebElement Morelink;
    @FindBy(linkText = "Leads")
    private WebElement leadslink;
    @FindBy(linkText = "Purchase Order")
    private WebElement PurchaseOrderlink;
    @FindBy(xpath="(//td[@valign='bottom'])[2]")
    private WebElement logoutbutton;
    @FindBy(linkText = "Sign Out")
    private WebElement singoutbutton;
    @FindBy(linkText = "Sales Order")
    private WebElement SalesOrderlink;
    @FindBy(linkText = "Quotes")
    private WebElement Quoteslink;
    @FindBy(linkText = "Invoice")
    private WebElement Invoicelink;
    
  
    public homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}

	 public WebElement getVendorslink() {
		return Vendorslink;
	}


	public void getMorelink(WebDriver driver) {
		Actions a=new Actions(driver);
		a.moveToElement(Morelink).perform();
		
	}


	public WebElement getPurchaseOrderlink() {
		return PurchaseOrderlink;
	}


	public WebElement getLogoutbutton() {
		return logoutbutton;
	}


	public WebElement getSingoutbutton() {
		return singoutbutton;
	}


	public WebElement getSalesOrderlink() {
		return SalesOrderlink;
	}


	public WebElement getQuoteslink() {
		return Quoteslink;
	}


	public WebElement getInvoicelink() {
		return Invoicelink;
	}


	public void getLogout(WebDriver driver) {
			Actions a=new Actions(driver);
			a.moveToElement(logoutbutton).perform();
			singoutbutton.click();
		}
    
    
}
