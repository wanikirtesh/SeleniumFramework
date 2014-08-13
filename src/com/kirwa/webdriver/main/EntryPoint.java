package com.kirwa.webdriver.main;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class EntryPoint {
	public static Logger LOGGER = Logger.getLogger(EntryPoint.class);
	public static void main(String[] args) throws Exception
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		System.out.println("Hello");
	
		System.out.println("i am after sleep");
		
		
	}
}

