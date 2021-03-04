package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveyPage {
	public WebDriver driver;
	
	@FindBy(id = "name")
	public WebElement nameField;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "location")
	public WebElement locationDropdown;
	
	@FindBy(id = "batch")
	public WebElement batchDropdown;
	
	@FindBy(id = "week")
	public WebElement weekDropdown;
	
	@FindBy(id = "sat1")
	public WebElement satisfactionNotSat;
	
	@FindBy(id = "sat2")
	public WebElement satisfactionNotReallySat;
	
	@FindBy(id = "sat3")
	public WebElement satisfactionMidSat;
	
	@FindBy(id = "sat4")
	public WebElement satisfactionSat;
	
	@FindBy(id = "sat5")
	public WebElement satisfactionVerySat;
	
	@FindBy(id = "one-on-one-yes")
	public WebElement oneOnOneYes;
	
	@FindBy(id = "one-on-one-no")
	public WebElement oneOnOneNo;
	
	@FindBy(id = "understanding1")
	public WebElement understandingPoor;
	
	@FindBy(id = "understanding2")
	public WebElement understandingKindaPoor;
	
	@FindBy(id = "understanding3")
	public WebElement understandingMid;
	
	@FindBy(id = "understanding4")
	public WebElement understandingKindaGreat;
	
	@FindBy(id = "understanding5")
	public WebElement understandingGreat;
	
	@FindBy(id = "paceTooSlow")
	public WebElement paceTooSlow;
	
	@FindBy(id = "paceGood")
	public WebElement paceGood;
	
	@FindBy(id = "paceTooFast")
	public WebElement paceTooFast;
	
	@FindBy(id = "helpfulMaterials1")
	public WebElement helpfulMaterialsStrAgree;
	
	@FindBy(id = "helpfulMaterials2")
	public WebElement helpfulMaterialsAgree;
	
	@FindBy(id = "helpfulMaterials3")
	public WebElement helpfulMaterialsDisagree;
	
	@FindBy(id = "helpfulMaterials4")
	public WebElement helpfulMaterialsStrDisagree;
	
	@FindBy(id = "helpfulMaterials5")
	public WebElement helpfulMaterialsNA;
	
	@FindBy(id = "wellOrganized1")
	public WebElement wellOrganizedStrAgree;
	
	@FindBy(id = "wellOrganized2")
	public WebElement wellOrganizedAgree;
	
	@FindBy(id = "wellOrganized3")
	public WebElement wellOrganizedDisagree;
	
	@FindBy(id = "wellOrganized4")
	public WebElement wellOrganizedStrDisagree;
	
	@FindBy(id = "wellOrganized5")
	public WebElement wellOrganizedNA;
	
	@FindBy(id = "questionsEncouraged1")
	public WebElement questionsEncouragedStrAgree;
	
	@FindBy(id = "questionsEncouraged2")
	public WebElement questionsEncouragedAgree;
	
	@FindBy(id = "questionsEncouraged3")
	public WebElement questionsEncouragedDisagree;
	
	@FindBy(id = "questionsEncouraged4")
	public WebElement questionsEncouragedStrDisagree;
	
	@FindBy(id = "questionsEncouraged5")
	public WebElement questionsEncouragedNA;
	
	@FindBy(id = "metExpectations1")
	public WebElement metExpectationsStrAgree;
	
	@FindBy(id = "metExpectations2")
	public WebElement metExpectationsAgree;
	
	@FindBy(id = "metExpectations3")
	public WebElement metExpectationsDisagree;
	
	@FindBy(id = "metExpectations4")
	public WebElement metExpectationsStrDisagree;
	
	@FindBy(id = "metExpectations5")
	public WebElement metExpectationsNA;
	
	@FindBy(id = "issues")
	public WebElement trainingIssues;
	
	@FindBy(id = "feedback")
	public WebElement trainingFeedback;

	@FindBy(id = "submitSurvey")
	public WebElement submit;
	
	public SurveyPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}


//*[@id="name"]
//*[@id="name"]
