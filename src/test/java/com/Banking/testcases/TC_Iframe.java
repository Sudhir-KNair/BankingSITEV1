package com.Banking.testcases;

import org.testng.annotations.Test;

import com.Banking.pageobjects.Iframe_Page;

public class TC_Iframe extends Baseclass{
	
	
	
	@Test
	public static void Entertexbox() throws InterruptedException {
		driver.get(iframeurl);
		Thread.sleep(3000);
		Iframe_Page iframepage = new Iframe_Page(driver);
		iframepage.entertext(textinput);
		
	}

}
