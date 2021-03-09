Feature: Tests if the user can upload a file
	
Background:
	Given The user is logged in as admin

Scenario: User clicks the choose file button
	Given The user is on the upload page
	When The user selects a file
	And The user clicks the upload button
	Then The file should be uploaded