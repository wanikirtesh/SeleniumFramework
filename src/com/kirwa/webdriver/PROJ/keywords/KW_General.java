package com.kirwa.webdriver.PROJ.keywords;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.kirwa.webdriver.PROJ.repository.*;
import com.kirwa.webdriver.main.Driver;


public class KW_General {
	private static Logger LOGGER = Logger.getLogger(KW_General.class.getName());
	public static boolean LaunchApplication(String appUrl) throws Exception
	{
	//	Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		Driver.NavigateTo(appUrl);
		if(Driver.Exist(By.id("headerImage")))
		//File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot, new File("c://ghostscreen.png"));
		
		return true;
		else
		return false;
	}
	public static boolean Login(String UserName, String Password) throws Exception
	{
	//	Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			Driver.TypeOn(OR_General.UsernameField(), UserName);
			Driver.TypeOn(OR_General.PasswordFied(), Password);
			Driver.ClickOn(OR_General.LoginButton());
			Driver.SwitchToFrame(By.id("innerFrame"));
			Driver.ClickOn(By.xpath("//a[@role='button']/span[text()='close']"));
			Driver.SwitchDefault();
			return Driver.Exist(OR_General.LogoutLink());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ClickElement(By by) throws Exception
	{
	//	Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			return Driver.ClickOn(by);
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean EnterText(By by,String text)
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			return Driver.TypeOn(by, text);
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
}
