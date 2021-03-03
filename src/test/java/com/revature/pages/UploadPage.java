package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {
	public WebDriver driver;
	
	@FindBy(id = "uploadedCSV")
	public WebElement filepath;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/button")
	public WebElement uploadButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/p")
	public WebElement uploadModal;
	
	public UploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean modal() {
		if (uploadModal == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
