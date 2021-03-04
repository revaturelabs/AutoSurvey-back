Feature: Test survey inputs, completion, and submissions

#Testing text input field		
Scenario: User types in a name
			Given The User is on the survey page
			When The User views the Name Field
			And The User clicks the Name field
			And The User types a name into the Name field
			Then The User's name is displayed in the Name field
			
#Testing dropdown input field
Scenario: User selects a batch
			Given The User is on the survey page again
			When The User views the Batch dropdown
			And The User selects an item in the Batch dropdown
			Then The User's Batch is displayed in the Batch dropdown
			
#Testing radio button input field
Scenario: User rates their training satisfaction
			Given The User is on the survey page again again
			When The User views the Training Satisfaction radio button spread
			And The User clicks a button in the radio button spread
			Then The User's rating is displayed in the rating button spread
			
#Testing form completion
Scenario: User fills out entire form and submits it
			Given The User is on the survey page again again again
			When The User views the Name field again
			And The User clicks the Name field again
			And The User types another name into the Name field
			And The User views the Email field
			And The User clicks the Email field
			And The User types an email into the Email field
			And The User views the Training Location dropdown
			And The User selects a training location from the Training Location dropdown
			And The User views the Batch dropdown again
			And The User selects another batch from the Batch dropdown
			And The User views the Week dropdown
			And The User selects a week from the Week dropdown
			And The User views the Training Satisfaction radio button field
			And The User clicks a value in the Training Satisfaction radio button field
			And The User views the One-on-One and Assessment radio button field
			And The User clicks a value in the One-on-One and Assessment radio button field
			And The User views the Understanding of Topics radio button field
			And The User clicks a value in the Understanding of Topics radio button field
			And The User views the Pace of Training radio button field
			And The User clicks a value in the Pace of Training radio button field
			And The User views the Materials and Contents radio button field
			And The User clicks a value in the Materials and Content radio button field
			And The User views the Training Activities radio button field
			And The User clicks a value in the Training Activities radio button field
			And The User views the Questions radio button field
			And The User clicks a value in the Questions radio button field
			And The User views the Training and Projects radio button field
			And The User clicks a value in the Training and Projects radio button field
			And The User views the Training Issues field
			And The User clicks the Training Issues field
			And The User types into the Training Issues field
			And The User views the Overall Feedback field
			And The User clicks the Overall Feedback field
			And The User types into the Overall Feedback field
			And The User clicks the Submit button
			Then The User's form is submitted
			
