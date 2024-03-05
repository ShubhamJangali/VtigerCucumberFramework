package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.CommonActions.CommonActions;

public class HomePage extends CommonActions {

	
	public HomePage(WebDriver driver,ExtentTest Logger) {
		super(driver,Logger);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()=\"Logout\"]")
	WebElement lnk_Logout;
	
	@FindBy(xpath="//a[text()=\"New Contact\"]")
	WebElement lnk_NewContact;
	
	@FindBy(xpath="//a[text()=\"New Lead\"]")
	WebElement lnk_NewLead;
	
	@FindBy(linkText = "My Account")
	WebElement lnk_My_Account;
	
	@FindBy(name = "Customise")
	WebElement inp_customize;
	
	@FindBy(xpath = "//td[@id=\"cl1\"]")
	WebElement tab_Home;
	
	@FindBy(xpath = "//td[@id=\"cl6\"]")
	WebElement tab_Contacts;
	
	@FindBy(partialLinkText = "New Product")
	WebElement lnk_New_Product;
	
	@FindBy(name = "imagename")
	WebElement inp_file;
	
	public boolean verifyLogout() {
		return lnk_Logout.isDisplayed();
	}
	
	public void clickLogout() {
		lnk_Logout.click();
	}
	
	public void clickOnCreateNewContact() {
		lnk_NewContact.click();
	}
	
	public void clickonNewLead() {
		lnk_NewLead.click();
	}
	
	public void clickonMyAccount() {
		ClickElement(lnk_My_Account, "Clicked on My Account");
	}
	
	public void clickonCustomize() {
		ClickElement(inp_customize, "Clicked on Customize");
	}
	
	public void DragDrop() {
		DragandDrop(tab_Home, tab_Contacts, "Drag and Drop is performed");
	}
	
	public void clickonNewProduct() {
		ClickElement(lnk_New_Product, "Clicked on New Product");
	}
	
	public void uploadfile(String path) {
		uploadfile_sendkeys(inp_file,path, "File uploaded");
	}
	
	public void uploadfile_robot(String path) {
		uploadfile_Robot_Class(inp_file, path,"File uploaded using robot class");
	}
	
	public void scroll() {
		PageScroll();
	}
}
