package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	public WebDriver driver;
	
	@FindBy(id = "firstName")
	public WebElement first;
	
	@FindBy(id = "lastName")
	public WebElement last;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "register")
	public WebElement registerBtn; 
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
