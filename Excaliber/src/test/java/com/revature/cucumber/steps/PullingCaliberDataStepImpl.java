package com.revature.cucumber.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.revature.pages.ExcaliberPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PullingCaliberDataStepImpl {

	static {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getPath());
	}
	
	static WebDriver driver = new ChromeDriver();
	static ExcaliberPOM page = new ExcaliberPOM(driver);
	
	@Given("I am on the Excaliber home page")
	public void i_am_on_the_Excaliber_home_page() {
		driver.get("http:localhost:4200");
	}

	@When("I select a trainer with data")
	public void i_select_a_trainer_with_data() {
		Select trainerSelector = new Select(driver.findElement(By.id("trainer-select")));
		try {
			Thread.sleep(7000);
		} catch(Exception e) {
			
		}
		trainerSelector.selectByIndex(5);
	}

	@When("I click the pull data button")
	public void i_click_the_pull_data_button() {
		page.pullButton.click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("It should show a success message")
	public void it_should_show_a_success_message() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement message = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div[3]/app-api-all-trainers/div/div"));
		Assertions.assertEquals(message.getAttribute("class"), "alert alert-success");
	}

	@When("I select a trainer without data")
	public void i_select_a_trainer_without_data() {
		Select trainerSelector = new Select(driver.findElement(By.id("trainer-select")));
		try {
			Thread.sleep(7000);
		} catch(Exception e) {
			
		}
		trainerSelector.selectByIndex(4);
	}

	@When("I click pull data")
	public void i_click_pull_data() {
		page.pullButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("It should show a failure message")
	public void it_should_show_a_failure_message() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement message = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div[3]/app-api-all-trainers/div/div"));
		Assertions.assertEquals("alert alert-danger", message.getAttribute("class"));
	}

}
