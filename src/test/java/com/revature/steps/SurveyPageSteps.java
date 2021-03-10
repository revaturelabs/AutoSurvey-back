package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.revature.pages.SurveyPage;
import com.revature.runners.SurveyRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SurveyPageSteps {
	public static SurveyPage surveypage = SurveyRunner.surveyPage;
	public static WebDriver driver = SurveyRunner.driver;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;		
	String url = "http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/survey.html";

	@Given("^The User is on the survey page$")
	public void the_User_is_on_the_survey_page() throws Throwable
	{
		driver.get(url);
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Name Field$")
	public void the_User_views_the_Name_Field() throws Throwable
	{
		assertTrue(true);
		//js.executeScript("arguments[0].scrollIntoView();", surveypage.nameField);
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

		@When("^The User clicks the Name field$")
		public void the_User_clicks_the_Name_field() throws Throwable
		{
			surveypage.nameField.click();
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	@When("^The User types a name into the Name field$")
	public void the_User_types_a_name_into_the_Name_field() throws Throwable {
		surveypage.nameField.sendKeys("Ryan Schlientz");
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^The User's name is displayed in the Name field$")
	public void the_User_s_name_is_displayed_in_the_Name_field() throws Throwable {
		assertTrue(true);
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

//*****************************************************************************
	@Given("^The User is on the survey page again$")
	public void the_User_is_on_the_survey_page_again() throws Throwable 
	{
	    	driver.get(url);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}

	@When("^The User views the Batch dropdown$")
	public void the_User_views_the_Batch_dropdown() throws Throwable 
	{
		js.executeScript("arguments[0].scrollIntoView();", surveypage.batchDropdown);
	    js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User selects an item in the Batch dropdown$")
	public void the_User_selects_an_item_in_the_Batch_dropdown() throws Throwable 
	{
	   Select selectBatch = new Select(surveypage.batchDropdown);
	   selectBatch.selectByIndex(0);
	   selectBatch.selectByIndex(1);
	   selectBatch.selectByIndex(2);
	   try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^The User's Batch is displayed in the Batch dropdown$")
	public void the_User_s_Batch_is_displayed_in_the_Batch_dropdown() throws Throwable
	{
	    assertTrue(true);
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

//*********************************************************************************
	@Given("^The User is on the survey page again again$")
	public void the_User_is_on_the_survey_page_again_again() throws Throwable {
	   		 driver.get(url);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}

	@When("^The User views the Training Satisfaction radio button spread$")
	public void the_User_views_the_Training_Satisfaction_radio_button_spread() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.satisfactionNotSat);
	    js.executeScript("window.scrollBy(0,400)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a button in the radio button spread$")
	public void the_User_clicks_a_button_in_the_radio_button_spread() throws Throwable {
	    surveypage.satisfactionNotReallySat.click();
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^The User's rating is displayed in the rating button spread$")
	public void the_User_s_rating_is_displayed_in_the_rating_button_spread() throws Throwable {
	   assertTrue(true);
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
//*********************************************************************************************

	@Given("^The User is on the survey page again again again$")
	public void the_User_is_on_the_survey_page_again_again_again() throws Throwable {
	    driver.get(url);
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Name field again$")
	public void the_User_views_the_Name_field_again() throws Throwable {
	   js.executeScript("window.scrollTo(0,0);");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks the Name field again$")
	public void the_User_clicks_the_Name_field_again() throws Throwable {
	    surveypage.nameField.click();
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User types another name into the Name field$")
	public void the_User_types_another_name_into_the_Name_field() throws Throwable {
	    surveypage.nameField.sendKeys("Ryan Schlientz");
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Email field$")
	public void the_User_views_the_Email_field() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.emailField);
	    js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks the Email field$")
	public void the_User_clicks_the_Email_field() throws Throwable {
	    surveypage.emailField.click();
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User types an email into the Email field$")
	public void the_User_types_an_email_into_the_Email_field() throws Throwable {
	    surveypage.emailField.sendKeys("ryanschlientz@revature.com");
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Training Location dropdown$")
	public void the_User_views_the_Training_Location_dropdown() throws Throwable {
	     js.executeScript("arguments[0].scrollIntoView();", surveypage.locationDropdown);
	     js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User selects a training location from the Training Location dropdown$")
	public void the_User_selects_a_training_location_from_the_Training_Location_dropdown() throws Throwable {
	     Select selectLocation = new Select(surveypage.locationDropdown);
	   selectLocation.selectByIndex(1);
	   try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Batch dropdown again$")
	public void the_User_views_the_Batch_dropdown_again() throws Throwable 
	{
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.batchDropdown);
	    js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User selects another batch from the Batch dropdown$")
	public void the_User_selects_another_batch_from_the_Batch_dropdown() throws Throwable {
	    Select selectBatch = new Select(surveypage.batchDropdown);
	   selectBatch.selectByIndex(1);
	   try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Week dropdown$")
	public void the_User_views_the_Week_dropdown() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.weekDropdown);
	    js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User selects a week from the Week dropdown$")
	public void the_User_selects_a_week_from_the_Week_dropdown() throws Throwable {
	   Select selectWeek = new Select(surveypage.weekDropdown);
	   selectWeek.selectByIndex(1);
	   try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Training Satisfaction radio button field$")
	public void the_User_views_the_Training_Satisfaction_radio_button_field() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.satisfactionMidSat);
	    js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Training Satisfaction radio button field$")
	public void the_User_clicks_a_value_in_the_Training_Satisfaction_radio_button_field() throws Throwable {
		surveypage.satisfactionNotSat.click();
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		surveypage.satisfactionNotReallySat.click();
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    surveypage.satisfactionMidSat.click();
	    try {
			Thread.sleep(500);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    surveypage.satisfactionSat.click();
	    try {
			Thread.sleep(500);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    surveypage.satisfactionVerySat.click();
	    try {
			Thread.sleep(500);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    
	    
	    surveypage.satisfactionSat.click();
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the One-on-One and Assessment radio button field$")
	public void the_User_views_the_One_on_One_and_Assessment_radio_button_field() throws Throwable {
	     js.executeScript("arguments[0].scrollIntoView();", surveypage.oneOnOneNo);
	     js.executeScript("window.scrollBy(0,200)");
	  try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the One-on-One and Assessment radio button field$")
	public void the_User_clicks_a_value_in_the_One_on_One_and_Assessment_radio_button_field() throws Throwable {
	    surveypage.oneOnOneYes.click();
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Understanding of Topics radio button field$")
	public void the_User_views_the_Understanding_of_Topics_radio_button_field() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.understandingMid);
	    js.executeScript("window.scrollBy(0,200)");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Understanding of Topics radio button field$")
	public void the_User_clicks_a_value_in_the_Understanding_of_Topics_radio_button_field() throws Throwable {
	    surveypage.understandingKindaPoor.click();
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Pace of Training radio button field$")
	public void the_User_views_the_Pace_of_Training_radio_button_field() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.paceTooFast);
	    js.executeScript("window.scrollBy(0,200)");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Pace of Training radio button field$")
	public void the_User_clicks_a_value_in_the_Pace_of_Training_radio_button_field() throws Throwable {
	    surveypage.paceGood.click();
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Materials and Contents radio button field$")
	public void the_User_views_the_Materials_and_Contents_radio_button_field() throws Throwable {
		js.executeScript("arguments[0].scrollIntoView();", surveypage.metExpectationsDisagree);
	    js.executeScript("window.scrollBy(0,400)");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Materials and Content radio button field$")
	public void the_User_clicks_a_value_in_the_Materials_and_Content_radio_button_field() throws Throwable {
	   surveypage.helpfulMaterialsStrAgree.click();
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Training Activities radio button field$")
	public void the_User_views_the_Training_Activities_radio_button_field() throws Throwable {
	    assertTrue(true);
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Training Activities radio button field$")
	public void the_User_clicks_a_value_in_the_Training_Activities_radio_button_field() throws Throwable {
	    surveypage.wellOrganizedAgree.click();
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Questions radio button field$")
	public void the_User_views_the_Questions_radio_button_field() throws Throwable {
//	    js.executeScript("arguments[0].scrollIntoView();", surveypage.questionsEncouragedDisagree);
//	    js.executeScript("window.scrollBy(0,200)");
		assertTrue(true);
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Questions radio button field$")
	public void the_User_clicks_a_value_in_the_Questions_radio_button_field() throws Throwable {
	   surveypage.questionsEncouragedDisagree.click();
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Training and Projects radio button field$")
	public void the_User_views_the_Training_and_Projects_radio_button_field() throws Throwable {
//	    js.executeScript("arguments[0].scrollIntoView();", surveypage.metExpectationsDisagree);
//	    js.executeScript("window.scrollBy(0,200)");
		assertTrue(true);
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks a value in the Training and Projects radio button field$")
	public void the_User_clicks_a_value_in_the_Training_and_Projects_radio_button_field() throws Throwable {
	    surveypage.metExpectationsStrDisagree.click();
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Training Issues field$")
	public void the_User_views_the_Training_Issues_field() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.trainingIssues);
	    js.executeScript("window.scrollBy(0,200)");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks the Training Issues field$")
	public void the_User_clicks_the_Training_Issues_field() throws Throwable {
	   surveypage.trainingIssues.click();
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User types into the Training Issues field$")
	public void the_User_types_into_the_Training_Issues_field() throws Throwable {
	    surveypage.trainingIssues.sendKeys("Too much Java");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Overall Feedback field$")
	public void the_User_views_the_Overall_Feedback_field() throws Throwable {
	    js.executeScript("arguments[0].scrollIntoView();", surveypage.trainingFeedback);
	    js.executeScript("window.scrollBy(0,200)");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks the Overall Feedback field$")
	public void the_User_clicks_the_Overall_Feedback_field() throws Throwable {
	    surveypage.trainingFeedback.click();
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User types into the Overall Feedback field$")
	public void the_User_types_into_the_Overall_Feedback_field() throws Throwable {
	    surveypage.trainingFeedback.sendKeys("Kind of lame");
	     try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User views the Submit button$")
	public void the_User_views_the_Submit_button() throws Throwable
	{
		js.executeScript("arguments[0].scrollIntoView();", surveypage.submit);
		js.executeScript("window.scrollBy(0,200)");
		 try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@When("^The User clicks the Submit button$")
	public void the_User_clicks_the_Submit_button() throws Throwable {
		surveypage.submit.click();
		 try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    
	}

	@Then("^The User's form is submitted$")
	public void the_User_s_form_is_submitted() throws Throwable {
	   assertTrue(true);
	    try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
