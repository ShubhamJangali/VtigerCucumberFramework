package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.CommonActions.CommonActions;

public class NewLeadPage extends CommonActions{

	public NewLeadPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	WebElement txt_lastname;
	
	@FindBy(name="company")
	WebElement txt_company;
	
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	WebElement btn_Save;
	
	public void Setlastname(String lastname) {
		InputText(txt_lastname,lastname , lastname+" Entered Successfully ");
	}
	
	public void SetCompany(String company) {
		InputText(txt_company,company , company+" Entered Successfully ");
	}
	
	public void clickonsave() {
		ClickElement(btn_Save, " Save Button Clicked");
	}
	
	public void AcceptAlert() {
		AlertAccept(" Alert Accepted");
	}
}
