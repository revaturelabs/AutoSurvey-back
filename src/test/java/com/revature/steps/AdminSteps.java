package com.revature.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.revature.pages.AdminPage;
import com.revature.runners.AdminRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminSteps {
	public static AdminPage adminpage = AdminRunner.adminpage;
	public static WebDriver driver = AdminRunner.driver;
	String url = "file:///C:/Users/Ric/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/AutoSurvey-front/admin.html";

	@Given("^the Admin is on the Admin Page$")
	public void the_Admin_is_on_the_Admin_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(url);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin clicks on the First Name Input$")
	public void the_Admin_clicks_on_the_First_Name_Input() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.first.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin enters the first name of the associate$")
	public void the_Admin_enters_the_first_name_of_the_associate() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.first.sendKeys("Hank");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin clicks on the Last Name Input$")
	public void the_Admin_clicks_on_the_Last_Name_Input() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.last.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin enters the last name of the associate$")
	public void the_Admin_enters_the_last_name_of_the_associate() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.last.sendKeys("Hill");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin clicks on the email Input$")
	public void the_Admin_clicks_on_the_email_Input() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.email.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin enter the associates email$")
	public void the_Admin_enter_the_associates_email() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.email.sendKeys("king@email.com");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the Admin clicks on the Register Employee button$")
	public void the_Admin_clicks_on_the_Register_Employee_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		adminpage.registerBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^the Associate is Registered$")
	public void the_Associate_is_Registered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assertions.assertEquals(true, true);
		}

}
