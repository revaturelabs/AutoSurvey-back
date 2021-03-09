package com.revature.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	public WebDriver driver;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "test")
	public WebElement loginButton;
	
	public IndexPage(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
}
