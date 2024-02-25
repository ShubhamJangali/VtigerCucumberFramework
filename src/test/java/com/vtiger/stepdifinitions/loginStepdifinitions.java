package com.vtiger.stepdifinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.Pages.HomePage;
import com.vtiger.Pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepdifinitions extends BaseDefinitions {

	LoginPage lp;
	HomePage hp;

	@Before
	public void getScenarioName(Scenario scenario) {
		initiation();
		launchApp();
		TC_Name = scenario.getName();
		Logger = extent.createTest(TC_Name);
	}
	
	@After
	public void TearDown() {
		extent.flush();
		driver.quit();
	}
	
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		
		lp = new LoginPage(driver,Logger);
		hp = new HomePage(driver,Logger);
		lp.verifyLoginButton();
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {

		lp.Setusername(dt.get(TC_Name).get("Userid"));
		lp.Setuserpassword(dt.get(TC_Name).get("Password"));
	}

	@When("click on login button")
	public void click_on_login_button() {
		lp.ClickLogin();
	}

	@Then("user should be on home page")
	public void user_should_be_on_home_page() {
		hp.verifyLogout();
	}

	@Then("user can see logout option")
	public void user_can_see_logout_option() {
		hp.verifyLogout();
	}

	@Then("click on logout Button")
	public void click_on_logout_button() {
		hp.clickLogout();
	}

	@When("user enters valid credentials userid as {string} and password as {string}")
	public void user_enters_valid_credentials_userid_as_and_password_as(String name, String password) {
		lp.Setusername(name);
		lp.Setuserpassword(password);
	}

	@When("user enters valid credentials userid {string} and password {string}")
	public void user_enters_valid_credentials_userid_and_password(String string, String string2,
			io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String, String>> mp = dataTable.asMaps();
		for (Map<String, String> m : mp) {
			driver.findElement(By.name("user_name")).sendKeys(m.get("user_id"));
			driver.findElement(By.name("user_password")).sendKeys(m.get("password"));

			lp.Setusername(m.get("user_id"));
			lp.Setuserpassword(m.get("password"));
		}
	}
	
	@When("user enters valid credentials and theme")
	public void user_enters_valid_credentials_and_theme() {
		lp.Setusername(dt.get(TC_Name).get("Userid"));
		lp.Setuserpassword(dt.get(TC_Name).get("Password"));
		lp.Settheme(dt.get(TC_Name).get("theme"));
	}

}
