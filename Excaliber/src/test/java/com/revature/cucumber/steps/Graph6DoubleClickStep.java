package com.revature.cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Graph6DoubleClickStep {
	
	static WebDriver dr;
	
	boolean header6Found = false;
	boolean header4NotFound = false;
	boolean header5NotFound = false;
	
	@Given("I am on the Assessment Reports page with graph 6")
	public void i_am_on_the_Assessment_Reports_page_with_graph_6() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    dr = new ChromeDriver();
	    String url = "http://localhost:4200/assessment";
	    dr.get(url);
	}
	@When("I double click the header for graph 6")
	public void i_double_click_the_header_for_graph_6() {
		Actions action = new Actions(dr);
		WebElement graphHeader = dr.findElement(By.xpath("(//*[@id='graph6Header'])"));
		action.doubleClick(graphHeader).perform();
	}
	@Then("Graph 6 table exists")
	public void graph_6_table_exists() {
		header6Found = dr.findElements(By.xpath("//*[@id='graph6Header']")).size() > 0;
	}
	@Then("Graph 4 table does not exist with 6")
	public void graph_4_table_does_not_exist_with_6() {
		header4NotFound = dr.findElements(By.xpath("//*[@id='graph4Header']")).size() == 0;
	}
	@Then("Graph 5 table does not exist with 6")
	public void graph_5_table_does_not_exist_with_6() {
		header5NotFound = dr.findElements(By.xpath("//*[@id='graph5Header']")).size() == 0;
		
		assertTrue(header6Found && header4NotFound && header5NotFound);
	}
}
