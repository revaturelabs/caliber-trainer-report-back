package com.revature.cucumber.steps;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.ExcaliberPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadJsonStep {

	static {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	}

	static WebDriver driver = new ChromeDriver();
	static ExcaliberPOM excaliber = new ExcaliberPOM(driver);

	@Given("I am on the excaliber home page")
	public void i_am_on_the_excaliber_home_page() {
		String url = "http://localhost:4200";
		driver.get(url);
	}

	@When("i upload a file")
	public void i_upload_a_file() {
		File file = new File("src/test/resources/data/data.json");
		excaliber.jsonInput.sendKeys(file.getAbsolutePath());
		excaliber.uploadBtn.click();

	}

	@Then("alert is present")
	public void alert_is_present() {
		Boolean present = false;
		Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		if (a != null) {
			driver.switchTo().alert().accept();
			present = true;
		} else {
			present = false;
		}

	}

	
}
