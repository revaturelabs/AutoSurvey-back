package com.revature.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.AdminPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/AdminPage.feature", glue = "com.revature.steps")
public class AdminRunner {
	
	public static WebDriver driver;
	public static AdminPage adminpage;
	
	@BeforeClass
	public static void setup() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		adminpage = new AdminPage(driver);
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
