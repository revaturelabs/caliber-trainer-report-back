Feature: Upload a JSON file

Scenario: User uploads a JSON
	Given I am on the excaliber home page
	When i upload a file
	Then alert is present