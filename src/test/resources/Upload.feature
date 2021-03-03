Feature: Tests if the user can upload a file
	
Scenario: User clicks the choose file button
	Given The user is on the upload page
	When The user clicks the choose file button
	And The user selects a file
	Then The file name should appear
	
Scenario: User clicks the upload button
	Given The user is on the upload page
	When The user clicks the upload button
	Then The file should be uploaded
	
