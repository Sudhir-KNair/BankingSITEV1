package com.Banking.testcases;

import org.testng.annotations.Test;

import com.Banking.pageobjects.Windowhandler_page;

public class TC_Windowhandler extends Baseclass {
	
	@Test
	public static void multiplewindows() throws InterruptedException {
		driver.get(windowhandlelink);
		Thread.sleep(2000);
		logger.info("Opened website");
		Windowhandler_page.windowhandles();
	}

}
