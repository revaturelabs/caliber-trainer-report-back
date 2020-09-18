package com.revature.cucumber.steps;

import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(features = {
		"src/test/resources/GraphDoubleClick.feature", "src/test/resources/OverviewLineGraph.feature"
		}, glue="com.revature.cucumber.steps")
public class TestRunner {
	
	@After
	static void tearDown() {
		OverviewStepImpl.browser.quit();
	}
}
