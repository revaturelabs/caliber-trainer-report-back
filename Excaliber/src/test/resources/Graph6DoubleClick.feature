Feature: Double click a graph to toggle large graph

	# TEST 28 in Test cases documentation
	# Graph 6 is 'Assessment scores for category'
	@selenium
  Scenario: Double click graph 6 header to toggle large graph
    Given I am on the Assessment Reports page with graph 6
    When I double click the header for graph 6
    Then Graph 6 table exists
    And Graph 4 table does not exist with 6
    And Graph 5 table does not exist with 6
