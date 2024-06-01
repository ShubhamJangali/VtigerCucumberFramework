package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.CommonActions.CommonActions;

public class LoginPage extends CommonActions {

	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	WebElement tb_name;

	@FindBy(name = "user_password")
	WebElement tb_pass;

	@FindBy(name = "Login")
	WebElement btn_login;

	@FindBy(name = "login_theme")
	WebElement dd_theme;

	@FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement txt_ErrMsg;

	@FindBy(xpath = "//img[@src=\"include/images/vtiger-crm.gif\"]")
	WebElement img_logo;
	
	@FindBy(xpath = "//a[@id=\"showSubMenu\"]")
	WebElement lnk_showmenu;
	
	@FindBy(xpath = "//a[text()=\"New Vendor\"]")
	WebElement lnk_New_vendor;

	public void login(String username, String password) {
		Setusername(username);
		Setuserpassword(password);
		ClickLogin();
	}

	public void login(String username, String password, String theme) {
		Setusername(username);
		Setuserpassword(password);
		Settheme(theme);
		ClickLogin();
	}

	public void Setusername(String username) {
//		tb_name.clear();
//		tb_name.sendKeys(username);
		
		InputText(tb_name,username,username+" has benn entered into username field");
	}

	public void Setuserpassword(String password) {
//		tb_pass.clear();
//		tb_pass.sendKeys(password);
		
		InputText(tb_pass,password,password+" has benn entered into password field");
	}

	public void ClickLogin() {
//		btn_login.click();
		
		ClickElement(btn_login," Login button Clicked");
	}

	public void Settheme(String theme) {
//		dd_theme.sendKeys(theme);
		
		SelectByValue(dd_theme,theme,theme+" has been selected from theme dropdown");
	}

	public void verifyError() {
//		 txt_ErrMsg.isDisplayed();
		 
		 ElementExist(txt_ErrMsg," Error massage exist on Login Page");
	}

	public void verifyLogo() {
//		img_logo.isDisplayed();
		
		ElementExist(img_logo," Logo has been displayed successfully on Login Page");
	}
	
	public void verifyLoginButton() {
		ElementExist(btn_login," Login Button is Dislpayed");
	}
	
	public void ClickShowMenu() {
		MoveToElement(lnk_showmenu," Mouse moved to showmenu");
	}
	
	public void ClickNewVendor() {
		ActionsClick(lnk_New_vendor," New Vendor Clicked");
	}

}

