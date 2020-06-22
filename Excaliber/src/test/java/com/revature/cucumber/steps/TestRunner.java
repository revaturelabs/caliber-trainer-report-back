package com.revature.cucumber.steps;

import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(features="src/test/resources/Excaliber.feature", glue="")
public class TestRunner {

}
