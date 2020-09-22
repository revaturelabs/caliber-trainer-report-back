Feature: Trainer dropdown pulls from Caliber

Scenario:
	Given I am on the Excaliber home page
	When I select a trainer with data 
	And I click the pull data button
	Then It should show a success message
	
Scenario:
	Given I am on the Excaliber home page
	When I select a trainer without data
	And I click pull data
	Then It should show a failure message