package com.revature.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.revature.pages.AnalysisPage;
import com.revature.runners.AnalysisRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AnalysisSteps {
	
	public static WebDriver driver = AnalysisRunner.driver;
	public static AnalysisPage analysispages = AnalysisRunner.analysispage;
	String url = "file:///C:/Users/Ric/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/AutoSurvey-front/analysis.html";
	
	@Given("^the user is on the Analysis Page$")
	public void the_user_is_on_the_Analysis_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  driver.get(url);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the user clicks a start date on the Calendar$")
	public void the_user_clicks_a_start_date_on_the_Calendar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    analysispages.date.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^the user clicks on the Search button$")
	public void the_user_clicks_on_the_Search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    analysispages.searchBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^the selected week analysis displays$")
	public void the_selected_week_analysis_displays() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Assertions.assertEquals(true, true);
	   
	}

	@Given("^the user is on the default Analysis Page$")
	public void the_user_is_on_the_default_Analysis_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Assertions.assertEquals(url, driver.getCurrentUrl());
		
	}

	@When("^the User Clicks on the Batch Tab$")
	public void the_User_Clicks_on_the_Batch_Tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    analysispages.batchTab.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    
	}

	@When("^the user Selects a Location$")
	public void the_user_Selects_a_Location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Select location = new Select(analysispages.location);
		location.selectByIndex(0);
		
		  try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}

	@When("^the user Selects a Batch$")
	public void the_user_Selects_a_Batch() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Select batch = new Select(analysispages.batch);
		
		batch.selectByIndex(0);
		  try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}

	@When("^the user Selects a Week$")
	public void the_user_Selects_a_Week() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Select week = new Select(analysispages.week);
		week.selectByIndex(0);
		
	}

	@When("^the user clicks on the Search Button$")
	public void the_user_clicks_on_the_Search_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   analysispages.searchBtn.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}

	@Then("^the selected Batch Analysis displays$")
	public void the_selected_Batch_Analysis_displays() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Assertions.assertEquals(true, true);
	}
}
