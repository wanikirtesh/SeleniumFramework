package com.kirwa.webdriver.test;

import static org.testng.Assert.assertTrue;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.kirwa.webdriver.PROJ.keywords.KW_General;
import com.kirwa.webdriver.main.BrowserLanguage;
import com.kirwa.webdriver.main.Driver;
import com.kirwa.webdriver.main.DriverTypes;
import com.kirwa.webdriver.main.Properties;

public class TST_Comman {
	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("calling before suite");
		//Properties.REPORTER = new Reporter("AtGlance");
		//Driver.SetDriver(DriverTypes.FIREFOX,BrowserLanguage.GERMAN);
		Driver.SetDriver(DriverTypes.GHOST,BrowserLanguage.ENGLISH);
	}
	@BeforeClass
	public void beforetest()
	{
		Properties.ModuleName="Comman";
	}
	@AfterSuite
	public void afterSuite() {
		//Properties.REPORTER.TSEnd();
		Driver.Quit();
	}
	@BeforeMethod
	public void StartTestCase() throws Exception
	{
		
		//Properties.REPORTER.RPT_TC_Start();
	}
	
	@AfterMethod
	public void EndTestCase() throws Exception
	{
		//System.out.println("calling after Method in 1");
	}
	@Test(groups="init")
	public void login() throws Exception
	{
		Properties.TestCaseTitle=Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(KW_General.LaunchApplication("http://172.26.120.188:30004/eden1763-03/"));
		assertTrue(KW_General.Login("ideas_rnd", "year-632"));
	}

}
