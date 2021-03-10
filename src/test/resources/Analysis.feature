Feature: Testing both Date and Batch Search functions

Background:
	Given the user is logged in

Scenario: Testing the Date Search Function
	Given the user is on the Analysis Page
	When the user clicks a start date on the Calendar
	And the user clicks on the Search button
	Then the selected week analysis displays
	
#Scenario: Testing the Batch Search Function
#	Given the user is on the default Analysis Page
#	When the User Clicks on the Batch Tab
#	And the user Selects a Location
#	And the user Selects a Batch
#	And the user Selects a Week
#	And the user clicks on the Search Button
#	Then the selected Batch Analysis displays