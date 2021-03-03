package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalysisPage {
	public WebDriver driver;
	
	@FindBy(id = "nav-batch-tab")
	public WebElement batchTab;
	
	@FindBy(xpath = "//*[@id=\"datepicker\"]/div/table/tbody/tr[2]/td[6]/a")
	public WebElement date;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div/button")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"nav-batch\"]/select[1]")
	public WebElement location;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/select[2]")
	public WebElement batch;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/select[3]")
	public WebElement week;

	
	
	
	
	public AnalysisPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
