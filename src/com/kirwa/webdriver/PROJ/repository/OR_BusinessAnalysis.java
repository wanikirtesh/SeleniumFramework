package com.kirwa.webdriver.PROJ.repository;

import org.openqa.selenium.By;

public class OR_BusinessAnalysis {
	public static By ThreeMonthCalanderBox()
	{
		return By.xpath("//div[@id='threeMonthCalendarBox']");
	}
	
	public static By FilterArea()
	{
		return By.xpath("//div[@name='BAfilter']");
	}
	public static By AnaLysisDataTab()
	{
		return By.xpath("//div[@id='4tab1']//a");
	}
	public static By RoomsByBusinessTab()
	{
		return By.xpath("//div[@id='4tab2']//a");
	}
	public static By ADRbyBusinessTab()
	{
		return By.xpath("//div[@id='4tab3']//a");
	}
	public static By AnaLysisDataTable()
	{
		return By.xpath("//table[@id='table_BusinessAnalysis']");
	}
	public static By RoomsByBusinessGraph()
	{
		return By.xpath("//div[@id='4tabPage2']//img");
	}
	public static By ADRbyBusinessGraph()
	{
		return By.xpath("//div[@id='4tabPage3']//img");
	}
}
