package com.revature.cucumber.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(features = {
		// "src/test/resources/Excaliber.feature", // currently a placeholder example feature
		"src/test/resources/GraphDoubleClick.feature"
		}, glue="com.revature.cucumber.steps")
public class TestRunner {
	@AfterAll
	public void tearDown() {
		// ExcaliberStep.driver.quit(); // currently a placeholder example step file
		Graph4DoubleClickStep.driver.quit();
		Graph5DoubleClickStep.driver.quit();
		Graph6DoubleClickStep.driver.quit();
	}
}
