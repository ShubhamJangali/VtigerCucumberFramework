package com.vtiger.stepdifinitions;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.LoginPage;
import com.vtiger.Pages.NewLeadPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewLeadDefinition extends BaseDefinitions{
	
	LoginPage lp;
	HomePage hp;
	NewLeadPage NLP;
	
	@Given("user should be on New Lead page")
	public void user_should_be_on_new_lead_page() {
		
		lp = new LoginPage(driver,Logger);
		hp = new HomePage(driver, Logger);
		lp.Setusername(dt.get(TC_Name).get("Userid"));
		lp.Setuserpassword(dt.get(TC_Name).get("Password"));
		lp.ClickLogin();
		hp.clickonNewLead();
	}
	@When("user enter last name")
	public void user_enter_last_name() {
	    NLP = new NewLeadPage(driver, Logger);
	    NLP.Setlastname(dt.get(TC_Name).get("lastname"));
	}
	@When("click on save button")
	public void click_on_save_button() {
	   NLP.clickonsave();
	}
	
	@Then("click ok in alert")
	public void click_ok_in_alert() {
	    NLP.AcceptAlert();
	}
	
	@Then("Click on NewLead")
	public void click_on_new_lead() {
		hp = new HomePage(driver, Logger);
	    hp.clickonNewLead();
	}


}
