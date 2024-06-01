package com.vtiger.Pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class PageObjectManager {
	
	WebDriver driver;
	ExtentTest logger;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage homepage;
	public LoginPage loginpage;
	public NewContactPage newcontactpage;
	public NewLeadPage newleadpage;
	public ReportsPage reportspage;
	
	public HomePage gethomepage() {
		return(homepage==null)? homepage = new HomePage(driver) : homepage;
	}
	
	public LoginPage getloginpage() {
		return(loginpage==null)? loginpage = new LoginPage(driver) : loginpage;
	}
	
	public NewContactPage getnewcontactpage() {
		return(newcontactpage==null)? newcontactpage = new NewContactPage(driver) : newcontactpage;
	}
	
	public NewLeadPage getnewleadpage() {
		return(newleadpage==null)? newleadpage = new NewLeadPage(driver) : newleadpage;
	}
	
	public ReportsPage getreportspage() {
		return(reportspage==null)? reportspage = new ReportsPage(driver) : reportspage;
	}
}
