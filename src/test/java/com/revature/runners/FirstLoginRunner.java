package com.revature.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.FirstLoginPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FirstLoginPage.feature", glue = "com.revature.steps")
public class FirstLoginRunner {
	
	public static WebDriver driver;
	public static FirstLoginPage firstPage;
	
	@BeforeClass
	public static void setup() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		firstPage = new FirstLoginPage(driver);
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}

}
