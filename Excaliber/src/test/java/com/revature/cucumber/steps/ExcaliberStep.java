package com.revature.cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExcaliberStep {
	@Given("^given placeholder$")
	public void given_placeholder() throws Exception{};
	
	@When("^when placeholder$")
	public void when_placeholder() throws Exception{};
	
	@When("^and placeholder$")
	public void and_placeholder() throws Exception{};
	
	@Then("^then placeholder$")
	public void then_placeholder() throws Exception{
		assertTrue(true);
	};
}
