package com.kirwa.webdriver.PROJ.repository;

import org.openqa.selenium.By;

public class OR_General {
	public static By UsernameField()
	{
		return By.name("userName");
	}
	public static By PasswordFied()
	{
		return By.name("password");
	}
	public static By LoginButton()
	{
		return By.xpath("//div[@class='btnData']//a");
	}
	public static By LogoutLink()
	{
		return By.xpath("//a[@href='Logout.do']");
	}
	public static By AtGlanceSelectedLink()
	{
		return By.xpath("//a[contains(@class,'selectedAnchor')]/span[text()='"+Utillor.getKV("@ A Glance") +"']");
	}
	public static By BusineessForecastSelectedLink()
	{
		return By.xpath("//a[contains(@class,'selectedAnchor')]/span[text()='"+Utillor.getKV("Business Forecast") +"']");
	}
	
	public static By BusinessAnalysisLink()
	{
		return By.xpath("//a[contains(@href,'BusinessAnalysisMS.do')]");
	}
	public static By MonitorPerformanceLink()
	{
		return By.xpath("//a[contains(@class,'selectedAnchor')]/span[text()='"+Utillor.getKV("Monitor Performance")+"']");
	}
	public static By ReportsLink()
	{
		return By.xpath("//a[contains(@href,'Reports.do')]");
	}
	public static By BARLink()
	{
		return By.xpath(".//a[@id='levelOne3href']");
	}
	
}
