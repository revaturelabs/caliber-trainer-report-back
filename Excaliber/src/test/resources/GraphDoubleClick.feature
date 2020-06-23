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

	# TEST 27 in Test cases documentation
	# Graph 5 is 'Assessment Scores According to Category'
	@selenium
	Scenario: Double click graph 5 header to toggle large graph
	  Given I am on the Assessment Reports page with graph 5
	  When I double click the header for graph 5
	  Then Graph 5 table exists
	  And Graph 4 table does not exist with 5
	  And Graph 6 table does not exist with 5

	# TEST 28 in Test cases documentation
	# Graph 6 is 'Assessment scores for category'
	@selenium
  Scenario: Double click graph 6 header to toggle large graph
    Given I am on the Assessment Reports page with graph 6
    When I double click the header for graph 6
    Then Graph 6 table exists
    And Graph 4 table does not exist with 6
    And Graph 5 table does not exist with 6
