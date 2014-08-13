package com.kirwa.webdriver.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtills {
	public static String DateTimeStamp()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("h-mm-ss-dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	public static String CurrentDateTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	public long getDiffrance(MyTimeUnits interval,Date date1,Date date2)
	{
		long diff = date2.getTime()-date1.getTime(); 
		switch (interval) {
		case MILLISECONDS:
			return diff;
		case SECONDS:
			return diff / 1000 % 60;
		case MINUTES:
			return diff / (60 * 1000) % 60;
		case HOURS:
			return diff / (60 * 60 * 1000) % 24;
		case DAYS:
			break;
		case MONTHS:
			break;
		case YEARS:
			return date2.getYear()-date1.getYear();
		default:
			break;
		}
		return 0;
	}
	
}
