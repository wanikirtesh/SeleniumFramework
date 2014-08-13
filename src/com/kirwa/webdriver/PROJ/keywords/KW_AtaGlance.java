package com.kirwa.webdriver.PROJ.keywords;

import org.apache.log4j.Logger;

import com.kirwa.webdriver.PROJ.repository.OR_AtaGlance;
import com.kirwa.webdriver.main.Driver;
import com.kirwa.webdriver.main.ImageUtills;
import com.kirwa.webdriver.main.Properties;

public class KW_AtaGlance {
	private static Logger LOGGER = Logger.getLogger(KW_AtaGlance.class.getName());

	public static boolean ShootHeader() throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			return ImageUtills.doImageTest(OR_AtaGlance.HeaderArea());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean ShootFooter() throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			return ImageUtills.doImageTest(OR_AtaGlance.FooterArea());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootPropertyPan() throws Exception
	{
		Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		return true;
	}
	public static boolean ShootBusinessDetail() throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
		Driver.ClickOn(OR_AtaGlance.AccordionHeaderLink(1));
		Thread.sleep(2000);
		return ImageUtills.doImageTest(OR_AtaGlance.BusinessDetails());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootCalendar() throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			return ImageUtills.doImageTest(OR_AtaGlance.CalendarArea());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootCalendarPopup() throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			Driver.ClickOn(OR_AtaGlance.CalendarLink());
			Thread.sleep(2000);
			return ImageUtills.doImageTest(OR_AtaGlance.CalnderPopup());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootAlerts() throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
		Driver.ClickOn(OR_AtaGlance.AccordionHeaderLink(2));
		Thread.sleep(2000);
		return ImageUtills.doImageTest(OR_AtaGlance.AccordionDeatils(2));
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootReports()throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
			Driver.ClickOn(OR_AtaGlance.AccordionHeaderLink(3));
			Thread.sleep(2000);
			return ImageUtills.doImageTest(OR_AtaGlance.AccordionDeatils(3));
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootSpecialEvents()throws Exception
	{
		//Properties.REPORTER.RPT_KW_Start();
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{
		Driver.ClickOn(OR_AtaGlance.AccordionHeaderLink(4));
		Thread.sleep(2000);
		return ImageUtills.doImageTest(OR_AtaGlance.AccordionDeatils(4));
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ShootFlip1()
	{
		return true;
	}
	public static boolean ShootFlip2()
	{
		return true;
	}
	public static boolean ShootFlip3()
	{
		return true;
	}
	
}
