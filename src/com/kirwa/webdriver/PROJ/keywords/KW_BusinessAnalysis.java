package com.kirwa.webdriver.PROJ.keywords;

import org.apache.log4j.Logger;

import com.kirwa.webdriver.PROJ.repository.OR_BusinessAnalysis;
import com.kirwa.webdriver.main.Driver;
import com.kirwa.webdriver.main.ImageUtills;
import com.kirwa.webdriver.main.Properties;

public class KW_BusinessAnalysis {
	private static Logger LOGGER = Logger.getLogger(KW_BusinessAnalysis.class.getName());
	public static boolean ShootClanders()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	
			Properties.REPORTER.RPT_KW_Start();
			return ImageUtills.doImageTest(OR_BusinessAnalysis.ThreeMonthCalanderBox());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean ShootFilter()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	
			Properties.REPORTER.RPT_KW_Start();
			return ImageUtills.doImageTest(OR_BusinessAnalysis.FilterArea());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean ShootBusinessData()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	
			Boolean results=true;
			Properties.REPORTER.RPT_KW_Start();
			results &= Driver.ClickOn(OR_BusinessAnalysis.AnaLysisDataTab());
			return results && ImageUtills.doImageTest(OR_BusinessAnalysis.AnaLysisDataTable());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean ShootRoomsByBusinessGraph()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	
			Boolean results=true;
			Properties.REPORTER.RPT_KW_Start();
			results &= Driver.ClickOn(OR_BusinessAnalysis.RoomsByBusinessTab());
			return results && ImageUtills.doImageTest(OR_BusinessAnalysis.RoomsByBusinessGraph());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean ShootADRbyBusinessGraph()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	
			Boolean results=true;
			Properties.REPORTER.RPT_KW_Start();
			results &= Driver.ClickOn(OR_BusinessAnalysis.ADRbyBusinessTab());
			return results && ImageUtills.doImageTest(OR_BusinessAnalysis.ADRbyBusinessGraph());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
		
	}

}
