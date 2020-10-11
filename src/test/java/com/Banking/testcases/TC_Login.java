package com.Banking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Banking.pageobjects.Pageobjects_Loginpage;



public class TC_Login extends Baseclass{
	
	
	@Test
	public  void applogin() throws IOException {
		
		driver.get(opencrmurl);
		logger.info("Website launched");
		Pageobjects_Loginpage loginpage = new Pageobjects_Loginpage(driver);
		loginpage.loginusername(username);
		logger.info("provided username");
		loginpage.loginpswrd(password);
		logger.info("provided password");
		loginpage.submitlogin();
		
		if(driver.getTitle().equals("Dashboard &lsaquo; opensourcecms &#8212; WordPress"))
		{
			Assert.assertTrue(false);
			Reporter.log("succesfully loggedin");
		}
			else 
			{
				captureScreen(driver,"applogin");
				Assert.assertTrue(true);
				Reporter.log("failed loggedin");
			}
		}
	//@Test
	/*public void jsapplogin() {
		driver.get(opencrmurl);
		JSexecutors_Login jsexecutorslogin = new JSexecutors_Login(driver);
		jsexecutorslogin.JS_login(username, password);
		//logger.info("login completed");
	}*/
}
