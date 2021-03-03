#We can login for the first time on our first time login page

Feature: Login to the QC Survey App as a new user


#	Background:
#		Given the User Has Link
#		And the User follows the link
		

	Scenario: Verify First Time Login functionality
		Given the User is on the First Login Page
		When the User clicks on password input
		And enters their password
		And clicks on the second password field
		And confirms their password
		Then the User is logged in