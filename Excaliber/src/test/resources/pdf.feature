Feature: Able to print and view PDF successfully

Background: 
	Given that I uploaded a JSON
	
Scenario: Printing a PDF of Assessment graphs
	Given That I access the Assessment Page
	When I click the download PDF button
	Then I should have a pdf in my downloads
	And I should be able to view it
	
Scenario: Printing a PDF of QC Graphs
	Given that I access the QC page
	When I click the download PDF button
	Then I should have a pdf in my downloads
	And I should be able to view it
