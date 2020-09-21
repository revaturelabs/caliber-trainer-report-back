package com.revature.cucumber.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ch.qos.logback.core.joran.action.Action;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OverviewStepImpl {
	
	static {
		File file = new File("src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	static WebDriver browser = new ChromeDriver();
	static Actions action = new Actions(browser);
	static String url = "http://localhost:4200/";
	
	static File mock = new File("src/main/resources/data.json");
	
	// Background
	@Given("That I uploaded a JSON")
	public void that_I_uploaded_a_JSON() {
		browser.manage().window().setSize(new Dimension(700, 700));
		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		browser.get(url);
		
		WebElement uploadInput = browser.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div[2]/app-upload/form/input[1]"));
		uploadInput.sendKeys(mock.getAbsolutePath());
		WebElement uploadBtn = browser.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div[2]/app-upload/form/input[2]"));
		uploadBtn.click();
		
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.switchTo().alert().dismiss();
		
	}


	// Scenario Assessment
	@Given("That I access the Assessment page")
	public void that_I_access_the_Assessment_page() {
		WebElement hamMenu = browser.findElement(By.cssSelector("fa-icon[class='ng-fa-icon hambIcon']"));
		hamMenu.click();
		WebElement assessmentBtn = browser.findElement(By.id("demo3"));
		assessmentBtn.click();
		
	}
	@When("I load the default view for the Assessment line graph")
	public void i_load_the_default_view_for_the_Assessment_line_graph() {
		WebElement g6header = browser.findElement(By.xpath("//*[@id=\"graph6Header\"]/div[1]/span"));
		Assertions.assertEquals("Assessment Scores For Category", g6header.getText());
	}
	@Then("I should have an overview of all categories in Assessment")
	public void i_should_have_an_overview_of_all_categories_in_Assessment() {
		WebElement selector = browser.findElement(By.xpath("//*[@id=\"assessment-graph6-selector\"]"));
		Select dropdown = new Select(selector);
		String actual = dropdown.getFirstSelectedOption().getText();
		Assertions.assertEquals("Overview", actual);
	}
	@When("I double click the Assessment line graph")
	public void i_double_click_the_Assessment_line_graph() {
		WebElement header = browser.findElement(By.xpath("//*[@id=\"graph6Header\"]/div[1]/span"));
		action.doubleClick(header).perform();	
	}
	@Then("I should have multiple tables beneath the Assessment line graph")
	public void i_should_have_multiple_tables_beneath_the_Assessment_line_graph() {
		WebElement lastTableRow = browser.findElement(By.xpath("/html/body/app-root/div[2]/app-assessment/div/div[2]/app-assessment-batches-trend-category-technical-status/div/div[2]/div[2]/table/tr[14]"));
		Assertions.assertTrue(lastTableRow.isDisplayed());
	}
	
	// Scenario Assessment
	@Given("That I access the QC page")
	public void that_I_access_the_QC_page() {
		WebElement hamMenu = browser.findElement(By.cssSelector("fa-icon[class='ng-fa-icon hambIcon']"));
		hamMenu.click();
		WebElement qcBtn = browser.findElement(By.id("demo2"));
		qcBtn.click();
			
	}
		
	@When("I load the default view for the QC line graph")
	public void i_load_the_default_view_for_the_QC_line_graph() {
		WebElement g2header = browser.findElement(By.xpath("//*[@id=\"graph2Header\"]/span"));
		Assertions.assertEquals("QC Technical Scores By Category Across Batches", g2header.getText());
	}
	
	@Then("I should have an overview of all categories in QC")
	public void i_should_have_an_overview_of_all_categories_in_QC() {
		WebElement selector = browser.findElement(By.xpath("//*[@id=\"qc-graph2-selector\"]"));
		Select dropdown = new Select(selector);
		String actual = dropdown.getFirstSelectedOption().getText();
		Assertions.assertEquals("Overview", actual);
	}
		
	@When("I double click the QC line graph")
	public void i_double_click_the_QC_line_graph() {
		WebElement header = browser.findElement(By.xpath("//*[@id=\"graph2Header\"]/span"));
		action.doubleClick(header).perform();	
	}
	
	@Then("I should have multiple tables beneath the QC line graph")
	public void i_should_have_multiple_tables_beneath_the_QC_line_graph() {
		WebElement lastTableRow = browser.findElement(By.xpath("/html/body/app-root/div[2]/app-qc/div/div[2]/app-qcbatches-indiv-category-technical-status/div/div[2]/div[2]/div/div[14]/h1"));
		Assertions.assertTrue(lastTableRow.isDisplayed());
	}

}
