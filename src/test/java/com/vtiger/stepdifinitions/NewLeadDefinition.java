package com.vtiger.stepdifinitions;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.LoginPage;
import com.vtiger.Pages.NewLeadPage;
import com.vtiger.Pages.ReportsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewLeadDefinition extends BaseDefinitions{
	
	@Given("user should be on New Lead page")
	public void user_should_be_on_new_lead_page() {
		
	
		pageobjectmanager.getloginpage().Setusername(dt.get(TC_Name).get("Userid"));
		pageobjectmanager.getloginpage().Setuserpassword(dt.get(TC_Name).get("Password"));
		pageobjectmanager.getloginpage().ClickLogin();
		pageobjectmanager.gethomepage().clickonNewLead();
	}
	@When("user enter last name")
	public void user_enter_last_name() {
	   
		pageobjectmanager.getnewleadpage().Setlastname(dt.get(TC_Name).get("lastname"));
	}
	@When("click on save button")
	public void click_on_save_button() {
		pageobjectmanager.getnewleadpage().clickonsave();
	}
	
	@Then("click ok in alert")
	public void click_ok_in_alert() {
		pageobjectmanager.getnewleadpage().AcceptAlert();
	}
	
	@Then("Click on NewLead")
	public void click_on_new_lead() {
	
		pageobjectmanager.gethomepage().clickonNewLead();
	}
	
}
