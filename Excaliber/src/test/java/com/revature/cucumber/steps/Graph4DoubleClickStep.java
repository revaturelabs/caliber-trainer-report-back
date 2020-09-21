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

public class Graph4DoubleClickStep {
	
	static WebDriver driver;
	
	boolean header4Found = false;
	boolean header5NotFound = false;
	boolean header6NotFound = false;
	
	@Given("I am on the Assessment Reports page with graph 4")
	public void i_am_on_the_Assessment_Reports_page_with_graph_4() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    String url = "http://localhost:4200/assessment";
	    driver.get(url);
	}
	@When("I double click the header for graph 4")
	public void i_double_click_the_header_for_graph_4() {
		Actions action = new Actions(driver);
		WebElement graphHeader = driver.findElement(By.xpath("(//*[@id='graph4Header'])"));
		action.doubleClick(graphHeader).perform();
	}
	@Then("Graph 4 table exists")
	public void graph_4_table_exists() {
		header4Found = driver.findElements(By.xpath("//*[@id='graph4Header']")).size() > 0;
	}
	@Then("Graph 5 table does not exist with 4")
	public void graph_5_table_does_not_exist_with_4() {
		header5NotFound = driver.findElements(By.xpath("//*[@id='graph5Header']")).size() == 0;
	}
	@Then("Graph 6 table does not exist with 4")
	public void graph_6_table_does_not_exist_with_4() {
		header6NotFound = driver.findElements(By.xpath("//*[@id='graph6Header']")).size() == 0;
		driver.quit();
		assertTrue(header4Found && header5NotFound && header6NotFound);
	}
}
