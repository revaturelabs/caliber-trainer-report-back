Feature: View all batches for a selected trainer on the calendar

Scenario: User navigates to the Calendar view
	Given I am on the home page
	When I click the View Batch Calendar NavLink
	Then the url should be calendarview
	
Scenario: User selects a trainer from the dropdown
	Given I am on the calendarview page
	When I select a trainer from the drop down
	Then The select value should be 1

Scenario Outline: User views each batch
	Given I have selected a trainer
	When I click "<clicks>" to get to next batch
	Then the event should be "<batchName>"
	
	Examples:
	|clicks|batchName|
	|9|1909 Sep30 Other OTHER|
	|7|1903 Mar04 Full Stack Java/JEE J2EE|
	|3|1901 Jan06 Other OTHER|
	|8|1804 Apr16 -2 JTA|
	
	 