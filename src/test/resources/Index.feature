#we can click on the survey... or we can login
Feature: Login to QC Survey App

#Navigate to landing page
#	Background: 
#		Given The browser is opened
#		And User is on the Landing Page
		

	Scenario: Verify login functionality
		Given The user is on the landing page
		When The user clicks on the email input
		And types in their email
		And clicks on the password input
		And types in their password
		And clicks the login button
		Then The user is logged in