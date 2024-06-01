package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.CommonActions.CommonActions;

public class NewContactPage extends CommonActions{

	public NewContactPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement txt_firstname;

	@FindBy(xpath = "//input[@name=\"lastname\"]")
	WebElement txt_lastname;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	WebElement btn_save;

	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement lnk_Logout;

	public void verifyLogout() {
		ElementExist(btn_save, "Save Button Verified");
	}

	public void ClickSave() {
		ClickElement(btn_save, "Clicked on Save Button");
	}

	public void Firstname(String firstname) {
		InputText(txt_firstname, firstname, "Firstname Entered");
	}

	public void Lastname(String lastname) {
		InputText(txt_lastname, lastname, "Lastname Entered");
	}

	public void CreateContact(String firstname,String lastname) {
		Firstname(firstname);
		Lastname(lastname);
		ClickSave();
	}

}
