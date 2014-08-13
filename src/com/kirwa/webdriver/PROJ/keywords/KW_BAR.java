package com.kirwa.webdriver.PROJ.keywords;

import org.openqa.selenium.By;

import com.kirwa.webdriver.PROJ.repository.OR_BAR;
import com.kirwa.webdriver.main.Driver;

public class KW_BAR {

	public static boolean ValidateBARData() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		
		return true;
	}
	
	public static boolean setFilter(String startdate,String endDate){
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Driver.SwitchToFrame(By.id("innerFrame"));
		Driver.TypeOn(OR_BAR.inpStartDate(), startdate);
		
		Driver.TypeOn(OR_BAR.inpEndDate(), endDate);
		Driver.ClickOn(OR_BAR.btnRetrive());
		return true;
		
	}

}
