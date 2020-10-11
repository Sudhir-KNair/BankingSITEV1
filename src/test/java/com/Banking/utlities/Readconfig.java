package com.Banking.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	static Properties propertys;
	
	public Readconfig() 
	{  //location of config file
	   File src = new File ("./Configuration/config.properties");		
	
	try {
		//  when we want to read the file we need to use fileinput stream
		FileInputStream fis = new FileInputStream(src);
		//initiatin the propertys object
		propertys = new Properties();
		//loading the file
		propertys.load(fis);
	}
	//if the file is unable to load or the file is missing, to catch the error we are using try catch method.
	catch (Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
		
	}
	// now we need to create method for every variabe mentioned in Config file
	public static String Applicationurl() {
		String url = propertys.getProperty("Iframeurl");//variable name from configfile
		return url;
	}
	public static String Appusername() {
		String usern = propertys.getProperty("username");//variable name from configfile
		return usern;	
	}	
	public static String Apppassword() {
		String pwd = propertys.getProperty("password");//variable name from configfile
		return pwd;	
	}

	public static String getchrome() {
		String chromepath = propertys.getProperty("chromep");//variable name from configfile
		return chromepath;	
	}
	public String getedge() {
		String Edgepath = propertys.getProperty("msedgep");//variable name from configfile
		return Edgepath;	
	}
	public static String apptextbox() {
		String textbox = propertys.getProperty("providetext");//variable name from configfile
		return textbox;
	}
	
	public static String OPencrmsurl() {
		String url = propertys.getProperty("baseurl");//variable name from configfile
		return url;
	}
	
	public static String windowhandlelink() {
		String url = propertys.getProperty("windowhandleslink");//variable name from configfile
		return url;
	}
}
