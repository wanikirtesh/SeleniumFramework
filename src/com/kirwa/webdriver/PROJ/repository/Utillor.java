package com.kirwa.webdriver.PROJ.repository;

import java.util.ResourceBundle;

import com.kirwa.webdriver.main.Driver;

public class Utillor {
	private static ResourceBundle ENGLISH = ResourceBundle.getBundle("com.ideas.webdriver.RMS.repository.ENGLISH");
	private static ResourceBundle GERMAN = ResourceBundle.getBundle("com.ideas.webdriver.RMS.repository.GERMAN");
	private static ResourceBundle SPANISH = ResourceBundle.getBundle("com.ideas.webdriver.RMS.repository.SPANISH");
	private static ResourceBundle CHINESE = ResourceBundle.getBundle("com.ideas.webdriver.RMS.repository.CHINESE");
	
	public static String getKV(String keValue)
	{
		switch(Driver.CurrentLanguage)
		{
		case CHINESE:
			return CHINESE.getString(keValue.replace(" ", ""));
		case ENGLISH:
			return ENGLISH.getString(keValue.replace(" ", ""));
		case GERMAN:
			return GERMAN.getString(keValue.replace(" ", ""));
		case SPANISH:
			return SPANISH.getString(keValue.replace(" ", ""));
		default:
			return null;
		}
	}
	
	

}
