Feature: Tests if the user can upload a file

Background: User is on the Upload Page
	Given The user has the Upload Page link
	And The user follows the Upload Page link
	
#testing the choose file button
Scenario: User clicks choose file button
	Given The user clicks the choose file button
	When The user selects a file
	Then The file name should appear

#testing the upload button
Scenario: User clicks upload button
	Given The file name is not empty
	When The user clicks the upload button
	Then The file should be uploaded
	
