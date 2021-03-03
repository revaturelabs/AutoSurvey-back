package com.revature.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.AnalysisPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.revature.steps")
public class AnalysisRunner {
	public static WebDriver driver;
	public static AnalysisPage analysispage;
	
	@BeforeClass
	public static void setup()
	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		analysispage = new AnalysisPage(driver);

	}
	
	@AfterClass
	public static void teardown()
	{
		driver.quit();
	}
}
