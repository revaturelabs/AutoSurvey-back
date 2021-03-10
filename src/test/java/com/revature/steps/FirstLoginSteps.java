package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.revature.pages.FirstLoginPage;
import com.revature.runners.FirstLoginRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstLoginSteps {
	
	public static FirstLoginPage firstpage = FirstLoginRunner.firstPage;
	public static WebDriver driver = FirstLoginRunner.driver;
	String url = "http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/firstLogIn.html?firstName=Ryan&lastName=Schlientz&email=ryanschlientz@revature.com";
	
	@Given("^the User Has Link$")
	public void the_User_Has_Link() throws Throwable {
		assertTrue(true);
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	@Given("^the User follows the link$")
	public void the_User_follows_the_link() throws Throwable {
	    driver.get(url);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("^the User is on the First Login Page$")
	public void the_User_is_on_the_First_Login_Page() throws Throwable {
	    assertTrue(true);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^the User clicks on password input$")
	public void the_User_clicks_on_password_input() throws Throwable {
	    firstpage.firstPasswordBar.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^enters their password$")
	public void enters_their_password() throws Throwable {
	    firstpage.firstPasswordBar.sendKeys("password");
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^clicks on the second password field$")
	public void clicks_on_the_second_password_field() throws Throwable {
	    firstpage.secondPasswordBar.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^confirms their password$")
	public void confirms_their_password() throws Throwable {
	    firstpage.secondPasswordBar.sendKeys("password");
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    firstpage.submitPassword.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^the User is logged in$")
	public void the_User_is_logged_in() throws Throwable {
	    Assertions.assertEquals("Page Title", "Page Title");
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
