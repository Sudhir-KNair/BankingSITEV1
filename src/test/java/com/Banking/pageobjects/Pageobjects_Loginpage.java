package com.Banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageobjects_Loginpage {
	
	WebDriver ldriver;
	public Pageobjects_Loginpage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath=("//input [@id='user_login']"))
	static WebElement usid;
    @FindBy(xpath=("//input [@id='user_pass']"))
    static WebElement pwd;
    @FindBy(xpath=("//p/input [@type='submit']"))
    static WebElement submit;
    
    public void loginusername(String userid) {
   	 usid.sendKeys(userid);
   	 
    }
    public void loginpswrd(String Passwrd) {
	 pwd.sendKeys(Passwrd);

    }
    public void submitlogin() {
   	 submit.click(); 
    }
}
