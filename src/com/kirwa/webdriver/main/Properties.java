package com.kirwa.webdriver.main;

import java.util.ResourceBundle;


public class Properties {
	public static boolean printReport = true;
	public static boolean CraeteBaseLine = false;
	public static Reporter REPORTER;
	//static ClassLoader cl = ClassLoader.getSystemClassLoader();
	public static String TestCaseTitle="";
	public static String ModuleName="";
	public static int TCCNTR=0;
	public static int KWCNTR=0;
	public static String DTSTAMP = DateUtills.DateTimeStamp();
	private static ResourceBundle PropertyDetails = ResourceBundle.getBundle("com.ideas.webdriver.main.MyTest");
	public static String getProperty(String PropertyName)
	{
		return PropertyDetails.getString(PropertyName);
	}
}

