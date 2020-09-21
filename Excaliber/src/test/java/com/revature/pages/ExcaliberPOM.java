package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExcaliberPOM {
	
	@FindBy(xpath= "/html/body/app-root/div[2]/app-home/div/div[2]/app-upload/form/input[1]")
	public WebElement jsonInput;
	
	@FindBy(xpath="/html/body/app-root/div[2]/app-home/div/div[2]/app-upload/form/input[2]")
	public WebElement uploadBtn;
	
	@FindBy(xpath="/html/body/app-root/app-main-nav-bar/div[1]/nav/div[3]/div[3]/a")
	public WebElement navLink;
	
	@FindBy(xpath= "//*[@id=\"trainer-selector\"]")
	public WebElement select;
	
	@FindBy(xpath="//*[@id=\"full-calendar\"]/full-calendar/div[1]/div[3]/div/button[1]")
	public WebElement leftButton;
	
	@FindBy(xpath="//*[@id=\"full-calendar\"]/full-calendar/div[1]/div[3]/div/button[2]")
	public WebElement rightButton;
	
	@FindBy (xpath= "//*[@id=\"full-calendar\"]/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[1]/td[1]/div/div[2]/div/a/div/div/div/div")
	public WebElement event;
	
	public ExcaliberPOM(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
