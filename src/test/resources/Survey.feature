Feature: Test survey inputs, completion, and submissions

Background: User is on the Survey Page
			Given The User has the Survey Page link
			And The User follows the Survey Page link
		
#Testing text input field		
Scenario: User types in a name
			Given The User selects the Name field
			When  The User types a name, "Ryan Schlientz" into the Name field
			Then The User's name is displayed in the Name field
			
#Testing dropdown input field
Scenario: User selects a batch
			Given The User selects the Batch dropdown
			When The User clicks an item, "BATCH" in the Batch dropdown
			Then The User's Batch is displayed in the Batch dropdown
			
#Testing radio button input field
Scenario: User rates their training satisfaction
			Given The User selects the Training radio button spread
			When The User clicks a button, "4" in the radio button spread
			Then The User's rating is displayed in the rating button spread
			
#Testing form completion
Scenario: User fills out entire form
			Given The User selects the Name field
			When The User types a name, "Ryan Schlientz" into the Name field
			And The User types an email, "ryan.schlientz@revature.com" into the Email field
			And The User selects a training location, "USF" from the Training Location dropdown
			And The User selects a batch, "BATCH" from the Batch dropdown
			And The User selects a week, "Week 4" from the Week dropdown
			And The User selects a value, "4" in the Training Satisfaction radio button field
			And The User selects a value, "Yes" in the One-on-One and Assessment radio button field
			And The User selects a value, "4" in the Understanding of Topics radio button field
			And The User selects a value, "Good" in the Pace of Training radio button field
			And The User selects a value, "Strongly Agree" in the Materials and Content radio button field
			And The User selects a value, "Agree" in the Training Activities radio button field
			And The User selects a value, "Disagree" in the Questions radio button field
			And The User selects a value, "Strongly Disagree" in the Training and Projects button field
			And The User types "Too much Java" into the Training Issues field
			And The User types "Kind of lame" into the Overall Feedback field
			Then The User's form displays all of their input