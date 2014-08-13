package com.kirwa.webdriver.test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kirwa.webdriver.main.Driver;
public class TST_temp {
	
	@BeforeClass
	public static void Before()
	{
		Driver driver = new Driver();
		//driver.ClickOn(by)
		
		System.out.println("in Before Class");
	}

	@Before
	public final void Beforee()
	{
		System.out.println("in Before");
	}
	
	@After
	public final void Afterr()
	{
		System.out.println("in After");
	}
	
	@Test
	public final void test1()
	{
		System.out.println("in test 1");
	}
	
	@Test
	public final void test2()
	{
		System.out.println("in test 2");
	}

	@AfterClass
	public static void After()
	{
		System.out.println("in After Class");
	}
}
