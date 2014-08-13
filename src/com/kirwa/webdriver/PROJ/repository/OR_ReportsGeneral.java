package com.kirwa.webdriver.PROJ.repository;

import org.openqa.selenium.By;

public class OR_ReportsGeneral {
	public static By ReportA2ZLink()
	{
		return By.xpath("//*[@id='reportCatX']");
		
	}
	public static By AllReportLinks()
	{
		return By.xpath("//div[@id='reportListX']//li[@name='reportListItems']/a");
	}
	public static By ReportHeader()
	{
		return By.className("reportHead");
	}
	public static By ReportFilter()
	{
		return By.className("reportCriteria");
	}
	public static By ReportNavigations()
	{
		return By.className("datenav");
	}
}
