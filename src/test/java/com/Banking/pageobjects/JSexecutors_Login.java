package com.Banking.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSexecutors_Login {
	
	static WebDriver ldriver;
	public JSexecutors_Login(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
    
	@FindBy(xpath=("//input [@id='user_login']"))
	static WebElement usid;
    @FindBy(xpath=("//input [@id='user_pass']"))
    static WebElement pwd;
    @FindBy(xpath=("//p/input [@type='submit']"))
    static WebElement submit;
    
    public void JS_login(String userid, String Passwrd ) {
    	 usid.sendKeys(userid);
    	 pwd.sendKeys(Passwrd);
    	 submit.click();
    	//Creating the JavascriptExecutor interface object by Type casting		
    	    JavascriptExecutor js = (JavascriptExecutor)ldriver;
    	    //js.executeScript("arguments[0].click;",submit);
    	    //js.executeScript("alert('Welcome to opencrms');"); 
    	    String domainname = js.executeScript("return document.domain;").toString();
    	    System.out.println("domain name is "+ domainname);
    	    String URLnname = js.executeScript("return document.URL;").toString();
    	    System.out.println("URL name is "+ URLnname);
    	    String titlenname = js.executeScript("return document.title;").toString();
    	    System.out.println("title name is "+ titlenname);
    	    js.executeScript("window.location='https://s1.demo.opensourcecms.com/wordpress/wp-admin/upload.php'");
    }
    	

}
