package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactPage {
	WebDriver driver;

	public NewContactPage(WebDriver driver) {
		this.driver = driver;
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

	public boolean verifyLogout() {
		return lnk_Logout.isDisplayed();
	}

	public void ClickSave() {
		btn_save.click();
	}

	public void Firstname(String firstname) {
		txt_firstname.sendKeys(firstname);
	}

	public void Lastname(String lastname) {
		txt_lastname.sendKeys(lastname);
	}

	public void CreateContact(String firstname,String lastname) {
		Firstname(firstname);
		Lastname(lastname);
		ClickSave();
	}

}
