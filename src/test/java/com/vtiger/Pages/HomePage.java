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
	
}
