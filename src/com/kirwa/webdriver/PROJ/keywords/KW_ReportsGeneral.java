package com.kirwa.webdriver.PROJ.keywords;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.kirwa.webdriver.PROJ.repository.OR_ReportsGeneral;
import com.kirwa.webdriver.main.Driver;
import com.kirwa.webdriver.main.ImageUtills;
import com.kirwa.webdriver.main.Properties;

public class KW_ReportsGeneral {
	private static Logger LOGGER = Logger.getLogger(KW_ReportsGeneral.class.getName());
	public static boolean SelectReportA2Z() 
	{
		
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	Properties.REPORTER.RPT_KW_Start();
			//Driver.RunJavaScript("selectCategory(this,'reportListX');");
			return Driver.ClickOn(OR_ReportsGeneral.ReportA2ZLink());
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean DoSanityofAllReports()
	{
		LOGGER.debug("==== Entering in Keyword " + Thread.currentThread().getStackTrace()[1].getMethodName() + "====");
		try
		{	Properties.REPORTER.RPT_KW_Start();
			Driver.SwitchToFrame(By.id("innerFrame"));
			Driver.RunJavaScript("selectCategory(this,'reportListX');");
			List<WebElement> ReportLinks = Driver.getWebElements(OR_ReportsGeneral.AllReportLinks());
			boolean result=true;
			String Reportname="";
			for(int i=21;i<ReportLinks.size();i++)
			{
				Driver.ClickOn(ReportLinks.get(i));
				Reportname = ReportLinks.get(i).getText();
				Driver.SwitchToPopup();
				result &= ShootReport(Reportname);
				Driver.ClosePopUp();
				Driver.SwitchToFrame(By.id("innerFrame"));
			}
			return result;
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean ShootReport(String ReportName)
	{
		try
		{	boolean result=true;
			System.out.println("For Report " +ReportName);
			Properties.REPORTER.RPT_Info("For Report " +ReportName);
			result &= ImageUtills.doImageTest(OR_ReportsGeneral.ReportHeader(),ReportName + "_hdr.png");
			//System.out.println("For Report hdr Done " +ReportName);
			result &= ImageUtills.doImageTest(OR_ReportsGeneral.ReportFilter(),ReportName + "_filter.png");
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
}
