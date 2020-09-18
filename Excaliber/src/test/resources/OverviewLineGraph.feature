Feature: Default overview for line graphs

Background: 
	Given That I uploaded a JSON

Scenario: Overview of Assessment Categories
	Given That I access the Assessment page
	When I load the default view for the Assessment line graph
	Then I should have an overview of all categories
	When I double click the Assessment line graph
	Then I should have multiple tables beneath the Assessment line graph
	
	
	
Scenario: Overview of QC Categories
	Given that I access the QC page
	When I load the default view for the QC line graph
	Then I should have an overview of all categories
	When I double click the QC line graph
	Then I should have multiple tables beneath the QC line graph
	