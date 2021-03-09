package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalysisPage {
	public WebDriver driver;
	
	@FindBy(id = "nav-batch-tab")
	public WebElement batchTab;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/div/div[1]/div[1]/div/table/tbody/tr[1]/td[1]/a")
	public WebElement date;
	
	@FindBy(xpath = "//*[@id=\"nav-date\"]/div[2]/button")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"nav-batch\"]/select[1]")
	public WebElement location;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/select[2]")
	public WebElement batch;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/select[3]")
	public WebElement week;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;

	
	
	
	
	public AnalysisPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
