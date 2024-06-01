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
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepdifinitions extends BaseDefinitions {

	@Before
	public void getScenarioName(Scenario scenario) {
		initiation();
		launchApp();
		TC_Name = scenario.getName();
		Logger = extent.createTest(TC_Name);
	}
	
	@After
	public void TearDown() throws InterruptedException {
		extent.flush();
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		pageobjectmanager.getloginpage().verifyLoginButton();
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		pageobjectmanager.getloginpage().Setusername(dt.get(TC_Name).get("Userid"));
		pageobjectmanager.getloginpage().Setuserpassword(dt.get(TC_Name).get("Password"));
	}

	@When("click on login button")
	public void click_on_login_button() {
		pageobjectmanager.getloginpage().ClickLogin();
	}

	@Then("user should be on home page")
	public void user_should_be_on_home_page() {
		pageobjectmanager.gethomepage().verifyLogout();
	}

	@Then("user can see logout option")
	public void user_can_see_logout_option() {
		pageobjectmanager.gethomepage().verifyLogout();
	}

	@Then("click on logout Button")
	public void click_on_logout_button() {
		pageobjectmanager.gethomepage().clickLogout();
	}

	@When("user enters valid credentials userid as {string} and password as {string}")
	public void user_enters_valid_credentials_userid_as_and_password_as(String name, String password) {
		pageobjectmanager.getloginpage().Setusername(name);
		pageobjectmanager.getloginpage().Setuserpassword(password);
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

			pageobjectmanager.getloginpage().Setusername(m.get("user_id"));
			pageobjectmanager.getloginpage().Setuserpassword(m.get("password"));
		}
	}
	
	@When("user enters valid credentials and theme")
	public void user_enters_valid_credentials_and_theme() {
		pageobjectmanager.getloginpage().Setusername(dt.get(TC_Name).get("Userid"));
		pageobjectmanager.getloginpage().Setuserpassword(dt.get(TC_Name).get("Password"));
		pageobjectmanager.getloginpage().Settheme(dt.get(TC_Name).get("theme"));
	}
	
	@Then("move mouse to showmenu")
	public void move_mouse_to_showmenu() {
		pageobjectmanager.getloginpage().ClickShowMenu();
	}
	@Then("click on New Vendor")
	public void click_on_new_vendor() {
		pageobjectmanager.getloginpage().ClickNewVendor();
	}
	
}
