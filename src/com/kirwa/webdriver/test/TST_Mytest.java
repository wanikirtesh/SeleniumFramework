package com.kirwa.webdriver.test;

import org.testng.annotations.*;

public class TST_Mytest {
	
	
	@BeforeMethod
	public final void before()
	{
		System.out.println("In Before");
	}
	@BeforeClass
	public static final void before2()
	{
		System.out.println("In Before Class");
	}
	
	@AfterClass
	public static final void After2()
	{
		System.out.println("In After Class");
	}
	
	@AfterMethod
	public final void after()
	{
		System.out.println("In After");
	}
	@Test
	public void doTest1()
	{
		System.out.println("I am in Test 1");
	}
	
	@Test
	public void doTest2()
	{
		System.out.println("I am in Test 2");
	}
	
	@Test
	public void doTest4()
	{
		System.out.println("I am in Test 4");
	}
	
	@Test
	public void doTest3()
	{
		System.out.println("I am in Test 3");
	}

}
