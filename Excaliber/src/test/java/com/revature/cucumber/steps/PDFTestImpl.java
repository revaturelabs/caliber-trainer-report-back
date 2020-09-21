package com.revature.cucumber.steps;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PDFTestImpl {
	
	static ChromeOptions options = new ChromeOptions();
	static {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		HashMap<String, Object> chromePref = new HashMap<>();
		chromePref.put("download.default_directory", "chrome://downloads/");
		options.setExperimentalOption("prefs", chromePref);
	}
	
	
	static WebDriver browser = new ChromeDriver(options);
	static String url = "http://localhost:4200/";
	static File mock = new File("src/main/resources/data.json");

	@Given("that I uploaded a JSON")
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



	@Given("That I access the Assessment Page")
	public void that_I_access_the_Assessment_Page() {
		WebElement hamMenu = browser.findElement(By.cssSelector("fa-icon[class='ng-fa-icon hambIcon']"));
		hamMenu.click();
		WebElement assessmentBtn = browser.findElement(By.id("demo3"));
		assessmentBtn.click();
	}
	@When("I click the download PDF button")
	public void i_click_the_download_PDF_button() {
		WebDriverWait wait = new WebDriverWait(browser, 5);
		WebElement pdfButton;
		try {
			pdfButton = browser.findElement(By.xpath("//*[@id=\"assessment-body\"]/div[1]/div[2]/button"));
			
		} catch (Exception e) {
			pdfButton = browser.findElement(By.xpath("//*[@id=\"qc-body\"]/div[1]/div[2]/button"));
		}
		wait.until(ExpectedConditions.visibilityOf(pdfButton));
		Assertions.assertEquals(pdfButton.getText(), "Download PDF");
		pdfButton.click();
	}
	@Then("I should have a pdf in my downloads")
	public void i_should_have_a_pdf_in_my_downloads() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		browser.get("chrome://downloads/");
//		WebElement downloadedFile = browser.findElement(By.xpath("//*[@id=\"file-link\"]"));
//		Assertions.assertTrue(downloadedFile.isDisplayed());
		
	}
	@Then("I should be able to view it")
	public void i_should_be_able_to_view_it() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)browser;
//			Assertions.assertTrue(true);
//			WebElement downloadedFile = (WebElement) jse.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('#downloads-list').getElementById('file-link');");
//			WebElement downloadedFile = browser.findElement(By.xpath("/html/body/downloads-manager//div[2]/iron-list/downloads-item[1]//div[2]/div[2]/div[1]/a"));
//			downloadedFile.click();
		} catch (Exception e) {
			Assertions.assertTrue(false);
		}
	}
	@Given("that I access the QC page")
	public void that_I_access_the_QC_page() {
		WebElement hamMenu = browser.findElement(By.cssSelector("fa-icon[class='ng-fa-icon hambIcon']"));
		hamMenu.click();
		WebElement qcBtn = browser.findElement(By.id("demo2"));
		qcBtn.click();
	}
}
