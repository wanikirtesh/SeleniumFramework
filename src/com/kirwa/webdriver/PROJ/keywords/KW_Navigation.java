package com.kirwa.webdriver.PROJ.keywords;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.kirwa.webdriver.PROJ.repository.OR_General;
import com.kirwa.webdriver.main.Driver;

public class KW_Navigation {
	private static Logger LOGGER = Logger.getLogger(KW_Navigation.class.getName());
	public static boolean NavigateToAtGlance()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try{
			//Properties.REPORTER.RPT_KW_Start();
			if(!Driver.Exist(OR_General.AtGlanceSelectedLink(),2))
			Driver.ClickOn(By.linkText("@ A Glance"));
			else
			LOGGER.info("Allready on At A Glance");
			//Thread.sleep(10000);
			return Driver.Exist(By.className("rmsCalendarContainerPane"));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error(e);
			return false;
		}
	}
	public static boolean NavigateToBusinessDetails()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try{
			//Properties.REPORTER.RPT_KW_Start();
			if(!Driver.Exist(OR_General.BusineessForecastSelectedLink(),1))
			{
				Driver.ClickOn(OR_General.BusinessAnalysisLink());
				return Driver.Exist(OR_General.BusineessForecastSelectedLink(),3);}
			else
			{
			LOGGER.info("Allready on Business Details");
			//Thread.sleep(10000);
			return Driver.Exist(OR_General.BusineessForecastSelectedLink(),1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error(e);
			return false;
		}
	}
	public static boolean NavigateToMonitorPerformance()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try{
			//Properties.REPORTER.RPT_KW_Start();
			if(!Driver.Exist(OR_General.MonitorPerformanceLink(),1))
			{
				Driver.ClickOn(OR_General.ReportsLink());
				return Driver.Exist(OR_General.MonitorPerformanceLink(),3);}
			else
			{
			LOGGER.info("Allready on Business Details");
			return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error(e);
			return false;
		}
	}
	public static boolean NavigateToBAR() {
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try{
			/*if(!Driver.Exist(OR_General.BARLink(),1))
			{*/
				Driver.ClickOn(OR_General.BARLink());
				return Driver.Exist(OR_General.BARLink(),3);
			/*}else
			{
			LOGGER.info("Allready on Business Details");
			return true;
			}*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error(e);
			return false;
		}
	}

}
