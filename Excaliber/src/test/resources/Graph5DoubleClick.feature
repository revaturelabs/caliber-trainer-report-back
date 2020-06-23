Feature: Double click a graph to toggle large graph

	# TEST 27 in Test cases documentation
	# Graph 5 is 'Assessment Scores According to Category'
	@selenium
  Scenario: Double click graph 5 header to toggle large graph
    Given I am on the Assessment Reports page with graph 5
    When I double click the header for graph 5
    Then Graph 5 table exists
    And Graph 4 table does not exist with 5
    And Graph 6 table does not exist with 5
