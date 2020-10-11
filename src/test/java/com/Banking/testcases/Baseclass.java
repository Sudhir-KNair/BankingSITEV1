package com.Banking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.utlities.Readconfig;


public class Baseclass {
	
	static Readconfig readconfig = new Readconfig();
	
	public static WebDriver driver;
	public static String iframeurl = Readconfig.Applicationurl();
	public static String opencrmurl = Readconfig.OPencrmsurl();
	public static String windowhandlelink = Readconfig.windowhandlelink();
	public static String textinput = Readconfig.apptextbox();
	public String username = Readconfig.Appusername();
	public String password = Readconfig.Apppassword();
	static Logger logger;
	
	@Parameters("browsername")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("Baseclass");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver",Readconfig.getchrome());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if
			(br.equalsIgnoreCase("msedge")){
			System.setProperty("webdriver.edge.driver",readconfig.getedge());
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
		
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
