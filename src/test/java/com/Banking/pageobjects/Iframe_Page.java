package com.Banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Iframe_Page {
	
	WebDriver adriver;
	public Iframe_Page(WebDriver bdriver){
		adriver = bdriver;
		PageFactory.initElements(bdriver, this);
	}

	
	@FindBy(xpath =("//input[@id='name']"))
	static WebElement entertextbox;
	@FindBy(xpath=("//select[@id='course']"))
	static WebElement courselist;
	@FindBy(xpath=("//iframe[@id='frm1']"))
	static WebElement frame1;
	@FindBy(xpath=("//iframe[@id='frm3']"))
	static WebElement frame3;
	
	public boolean entertext(String typetext) throws InterruptedException {
		entertextbox.sendKeys(typetext);
		Reporter.log("entered text mainframe");
		adriver.switchTo().frame(frame3);
		Reporter.log("switched into frame3");
		entertextbox.sendKeys(typetext);
		Reporter.log("entered text inside frame3");
		Thread.sleep(3000);
		adriver.switchTo().frame(frame1);
		Select coursedd = new Select(courselist);
		coursedd.selectByVisibleText("Java");
		Reporter.log("selected desired course");
		adriver.switchTo().parentFrame();
		Reporter.log("switched back to frame3");
		adriver.switchTo().defaultContent();
		Thread.sleep(3000);
		if(adriver.getTitle().contains("")) {
			Reporter.log("succesfully completed");
			return true;
			
		}
		else {
			Reporter.log("failed");
		return false;
		
	}

	
	}	
	
	
}

