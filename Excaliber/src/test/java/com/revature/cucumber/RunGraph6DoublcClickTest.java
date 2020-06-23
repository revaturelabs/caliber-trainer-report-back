package com.revature.cucumber;

import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(features="src/test/resources/Graph6DoubleClick.feature", 
	glue="com.revature.cucumber.steps")
public class RunGraph6DoublcClickTest {}
