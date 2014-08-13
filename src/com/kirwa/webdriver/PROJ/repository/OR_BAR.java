package com.kirwa.webdriver.PROJ.repository;

import org.openqa.selenium.By;

public class OR_BAR {
	public static By inpStartDate()
	{
		return By.xpath(".//input[@id='1']");
	}
	
	public static By inpEndDate()
	{
		return By.xpath(".//input[@id='2']");
	}
	
	public static By btnRetrive()
	{
		return By.xpath(".//*[@id='filter_barDecisionFilter_focusButton2']");
		
	}

}
