package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstLoginPage {
	
	public WebDriver driver;
	
	@FindBy(id = "newPasswordInput")
	public WebElement firstPasswordBar;
	
	@FindBy(id = "checkPasswordInput")
	public WebElement secondPasswordBar;
	
	@FindBy(id = "setPasswordButton")
	public WebElement submitPassword;
	
	public FirstLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
