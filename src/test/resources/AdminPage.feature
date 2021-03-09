#For the following Admin Page, An Admin should be able to Enter the information of an associate to give them login access
Feature: Testing admin associate integration

Background: 
	Given the Admin is Logged in
	
Scenario: Admin enters associate into App systems
	Given the Admin is on the Admin Page
	When the Admin clicks on the First Name Input
	And the Admin enters the first name of the associate
	And the Admin clicks on the Last Name Input
	And the Admin enters the last name of the associate
	And the Admin clicks on the email Input
	And the Admin enter the associates email
	And the Admin clicks on the Register Employee button
	Then the Associate is Registered
	