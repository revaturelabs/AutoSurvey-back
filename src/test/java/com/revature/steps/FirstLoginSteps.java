package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.FirstLoginPage;
import com.revature.runners.FirstLoginRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstLoginSteps {
	public static FirstLoginPage firstpage = FirstLoginRunner.firstPage;
	public static WebDriver driver = FirstLoginRunner.driver;
	
	@Given("^the User Has Link$")
	public void the_User_Has_Link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the User follows the link$")
	public void the_User_follows_the_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the User is on the First Login Page$")
	public void the_User_is_on_the_First_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the User clicks on password input$")
	public void the_User_clicks_on_password_input() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^enters their password$")
	public void enters_their_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^clicks on the second password field$")
	public void clicks_on_the_second_password_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^confirms their password$")
	public void confirms_their_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the User is logged in$")
	public void the_User_is_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
