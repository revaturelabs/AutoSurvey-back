#we can click on the survey... or we can login
Feature: Login to QC Survey App

Scenario: Navigate to landing page
	Given The browser is closed
	When The user types in the url
	Then The user is on the landing page

Scenario: Verify login functionality
	Given The user is on the landing page
	When The user clicks on the email input
	And types in their email
	And clicks on the password input
	And types in their password
	And clicks the login button
	Then The user is logged in