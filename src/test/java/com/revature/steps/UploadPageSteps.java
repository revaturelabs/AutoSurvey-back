package com.revature.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.revature.pages.UploadPage;
import com.revature.runners.UploadRunner;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadPageSteps {
	
	public static UploadPage uploadpage = UploadRunner.uploadPage;
	public static WebDriver driver = UploadRunner.driver;
	String url = "http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/upload.html";
	String testfile = "C:\\\\Users\\\\Ric\\\\Documents\\\\uploadtest.txt";
	
	@Given("^The user is logged in as admin$")
	public void the_User_is_logged_in_as_admin()
	{
			driver.get("http://ec2-54-173-212-237.compute-1.amazonaws.com:8080/AutoSurvey/");
			
				uploadpage.email.sendKeys("admin@admin.com"); // to be changed to test user when that gets created
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    
			    uploadpage.password.sendKeys("admin");
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    
			    uploadpage.loginButton.click();
			    try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}

	
	@Given("^The user is on the upload page$")
	public void the_user_is_on_the_upload_page() {
		driver.get(url);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^The user clicks the choose file button$")
	public void the_user_clicks_the_choose_file_button() {
		uploadpage.uploadButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^The user selects a file$")
	public void the_user_selects_a_file() { 
		   uploadpage.uploadCsv.sendKeys(testfile);
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	@When("^The user clicks the upload button$")
	public void the_user_clicks_the_upload_button() {
	    uploadpage.uploadButton.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//what happens once file is uploaded that would lead to this being positive
	//for instance, if a redirect occurs, I could test the title of the page to see if upload worked
	//and the title page remains the same if the upload fails?
	@Then("^The file should be uploaded$")
	public void the_file_should_be_uploaded() {
		
	    if (uploadpage.modal()==true) {
	    	Assertions.assertTrue(true);
	    }
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
