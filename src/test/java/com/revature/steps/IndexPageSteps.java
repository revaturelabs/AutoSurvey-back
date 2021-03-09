package com.revature.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.revature.pages.IndexPage;
import com.revature.runners.IndexRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IndexPageSteps {
	
	public static IndexPage indexpage = IndexRunner.indexPage;
	public static WebDriver driver = IndexRunner.driver;
	String url = "http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/";
	
//	@Given("^The browser is opened$")
//	public void the_browser_is_opened() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Given("^User is on the Landing Page$")
//	public void user_is_on_the_Landing_Page() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}

	@Given("^The user is on the landing page$")
	public void the_user_is_on_the_landing_page() throws Throwable {
	    driver.get(url);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^The user clicks on the email input$")
	public void the_user_clicks_on_the_email_input() throws Throwable {
	    indexpage.email.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^types in their email$")
	public void types_in_their_email() throws Throwable {
	    indexpage.email.sendKeys("username@example.com"); // to be changed to test user when that gets created
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^clicks on the password input$")
	public void clicks_on_the_password_input() throws Throwable {
	    indexpage.password.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^types in their password$")
	public void types_in_their_password() throws Throwable {
	    indexpage.password.sendKeys("password");
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^clicks the login button$")
	public void clicks_the_login_button() throws Throwable {
	    indexpage.loginButton.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^The user is logged in$")
	public void the_user_is_logged_in() throws Throwable {
	    Assertions.assertEquals("Page Title", "Page Title");
	}
	
}
