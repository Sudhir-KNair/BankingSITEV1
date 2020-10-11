package com.Banking.pageobjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Windowhandler_page {
	
	static WebDriver driver;
	public Windowhandler_page(WebDriver bdriver){
		driver = bdriver;
		PageFactory.initElements(bdriver, this);
	}
	
	@FindBy (xpath = ("//div[@class='w3-hide-small w3-light-grey w3-card-2']//a[@class='w3-button w3-theme w3-hover-green w3-hover-shadow'][contains(text(),'Try it Yourself »')]"))
	static WebElement tryitbutton; 
	
	@FindBy(xpath=("//button[@class='w3-button w3-bar-item w3-green w3-hover-white w3-hover-text-green']"))
	static WebElement runbutton; 
	
	public static void windowhandles() throws InterruptedException {
		String parent = driver.getWindowHandle();
		Reporter.log("Parent window id: "+parent);
		tryitbutton.click(); 
		Reporter.log("Clicked Try it button");
		Set<String> allwindows = driver.getWindowHandles();
		int count = allwindows.size();
		Reporter.log("Windows opened are: "+count);
		
		for(String child:allwindows) {
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			Reporter.log("Switched window to :"+driver.getTitle());
			runbutton.click();
			Reporter.log("Clicked on Runbutton");
			driver.close();
			}
		}
		driver.switchTo().window(parent); 
		Reporter.log("Back to Parent window: "+driver.getTitle());
	}

}
