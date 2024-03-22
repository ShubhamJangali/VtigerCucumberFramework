package com.vtiger.stepdifinitions;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.ReportsPage;

import io.cucumber.java.en.Then;

public class ReportsStepDifinitions extends BaseDefinitions{
	
	HomePage hp;
	ReportsPage RP;
	
	@Then("click on Reports")
	public void click_on_reports() {
		hp = new HomePage(driver, Logger);
	    hp.clickonReports();
	}
	@Then("click on img")
	public void click_on_img() {
	    RP = new ReportsPage(driver, Logger);
	    RP.clickonimg();
	}

	
}
