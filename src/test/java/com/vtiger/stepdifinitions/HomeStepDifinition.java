package com.vtiger.stepdifinitions;

import com.vtiger.Pages.HomePage;

import io.cucumber.java.en.Then;

public class HomeStepDifinition extends BaseDefinitions {

	HomePage hp = new HomePage(driver, Logger);

	@Then("click on My Account")
	public void click_on_my_account() {
		hp.clickonMyAccount();
	}

	@Then("click on Customize Tab")
	public void click_on_customize_tab() {
		hp.clickonCustomize();
	}

	@Then("Drag and drop the Home to Contact")
	public void drag_and_drop_the_home_to_contact() {
		hp.DragDrop();
	}

	@Then("Click on New Product")
	public void click_on_new_product() {
		hp.clickonNewProduct();
	}

	@Then("upload file using sendkeys")
	public void upload_file_using_sendkeys() {
		hp.uploadfile(dt.get(TC_Name).get("FilePath"));
	}

	@Then("upload file using Robot Class")
	public void upload_file_using_robot_class() {
		hp.uploadfile_robot(dt.get(TC_Name).get("FilePath"));
	}
	
	@Then("scroll the page")
	public void scroll_the_page() {
	    hp.scroll();
	}
}
