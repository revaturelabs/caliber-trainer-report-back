package com.revature.cucumber.steps;

import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.jupiter.*;


@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(features = {
		"src/test/resources/GraphDoubleClick.feature",
		"src/test/resources/UploadJson.feature",
		"src/test/resources/Calendar.feature"
		}, glue="com.revature.cucumber.steps" , monochrome=true)
public class TestRunner {
	
	@AfterClass
	public static void tearDown() {
			UploadJsonStep.driver.quit();
			CalendarNavigationStep.driver.quit();
	}
	
}
