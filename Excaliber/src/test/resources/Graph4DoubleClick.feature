Feature: Double click a graph to toggle large graph

	# TEST 26 in Test cases documentation
	# Graph 4 is 'Assessment scores according to batch'
	@selenium
  Scenario: Double click graph 4 header to toggle large graph
    Given I am on the Assessment Reports page with graph 4
    When I double click the header for graph 4
    Then Graph 4 table exists
    And Graph 5 table does not exist with 4
    And Graph 6 table does not exist with 4
