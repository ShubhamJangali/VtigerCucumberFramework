package com.vtiger.stepdifinitions;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.ReportsPage;

import io.cucumber.java.en.Then;

public class ReportsStepDifinitions extends BaseDefinitions{

	@Then("click on Reports")
	public void click_on_reports() {
		
		pageobjectmanager.gethomepage().clickonReports();
	}
	@Then("click on img")
	public void click_on_img() {
	   
		pageobjectmanager.getreportspage().clickonimg();
	}

	
}
