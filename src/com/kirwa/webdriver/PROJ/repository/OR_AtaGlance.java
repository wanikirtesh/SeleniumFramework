package com.kirwa.webdriver.PROJ.repository;

import org.openqa.selenium.By;

public class OR_AtaGlance {
	public static By HeaderArea()
	{
		return By.id("envNavigationNew");
	}
	
	public static By CalendarArea()
	{
		return By.className("rmsCalendarContainerPane");
	}
	public static By CalendarLink()
	{
		return By.xpath("//th[@class='datepickerMonth']//a");
	}
	public static By CalnderPopup()
	{
		return By.xpath("//div[contains(@class,'datepickerContainer ')]");
	}
	public static By FooterArea()
	{
		return By.id("footerNew");
	}
	public static By AccordionHeaderLink(int index)
	{
		return By.xpath(".//div[contains(@class,'ui-accordion-header')][" + index + "]");
	}
	
	public static By AccordionDeatils(int index)
	{
		return By.xpath(".//div[@role='tabpanel'][" + index + "]");
	}
	
	public static By BusinessDetails()
	{
		return By.xpath(".//div[contains(@class,'divBusinessDetails')]");
	}
	
	public static By TodayCalanderCell()
	{
		return By.xpath(".//td[contains(@class,'orange-border')]");
	}
}
