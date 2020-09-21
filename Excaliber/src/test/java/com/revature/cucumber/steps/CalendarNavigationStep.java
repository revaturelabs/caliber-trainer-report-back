package com.revature.cucumber.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.ExcaliberPOM;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalendarNavigationStep {
	
	static {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	}

	static WebDriver driver = new ChromeDriver();
	static ExcaliberPOM excaliber = new ExcaliberPOM(driver);

	
		@Given("I am on the home page")
		public void i_am_on_the_home_page() {
			String url = "http://localhost:4200";
			driver.get(url);
			driver.manage().window().setSize(new Dimension(1200, 990));
		}
	
			@When("I click the View Batch Calendar NavLink")
			public void i_click_the_View_Batch_Calendar_NavLink() {
				excaliber.navLink.click();
			}
		
			@Then("the url should be calendarview")
			public void the_url_should_be_calendarview() {
		
				Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/calendarview");
			}
	
		@Given("I am on the calendarview page")
		public void i_am_on_the_calendarview_page() {
			String url = "http://localhost:4200/calendarview";
			driver.get(url);
			
		}
	
			@When("I select a trainer from the drop down")
			public void i_select_a_trainer_from_the_drop_down() {
				excaliber.select.click();
				Select sel = new Select(excaliber.select);
				sel.selectByIndex(0);
			}
			@Then("The select value should be 1")
			public void the_select_value_should_be_1() {				
				Assert.assertEquals(excaliber.select.getAttribute("value"), "1");

			}
			
		@Given("I have selected a trainer")
		public void i_have_selected_a_trainer() {
			Select sel = new Select(excaliber.select);
			sel.selectByIndex(0);
		}
				@When("I click {string} to get to next batch")
				public void click_to_get_to_next_batch(String string) {
					int c= Integer.parseInt(string);
					int i;
					for(i=0;i<c;i++) {
					excaliber.leftButton.click();
					}
				}
			
				@Then("the event should be {string}")
				public void the_event_should_be(String string) {
					
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					Assert.assertEquals(excaliber.event.getText(), string);
				}
}
