package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.UploadPage;
import com.revature.runners.UploadRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadPageSteps {
	
	public static UploadPage uploadpage = UploadRunner.uploadPage;
	public static WebDriver driver = UploadRunner.driver;
	
	@Given("^The user has the Upload Page link$")
	public void the_user_has_the_Upload_Page_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The user follows the Upload Page link$")
	public void the_user_follows_the_Upload_Page_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The user clicks the choose file button$")
	public void the_user_clicks_the_choose_file_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user selects a file$")
	public void the_user_selects_a_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The file name should appear$")
	public void the_file_name_should_appear() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^The file name is not empty$")
	public void the_file_name_is_not_empty() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user clicks the upload button$")
	public void the_user_clicks_the_upload_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The file should be uploaded$")
	public void the_file_should_be_uploaded() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
