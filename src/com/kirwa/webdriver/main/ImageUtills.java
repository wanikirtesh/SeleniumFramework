package com.kirwa.webdriver.main;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

	import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebElement;


public class ImageUtills {
	
	private static Logger LOGGER = Logger.getLogger(ImageUtills.class.getName());
	    public static File shoot(RemoteWebElement element) throws IOException
	    {
	        try
	        {
	        File screen = ((TakesScreenshot) element.getWrappedDriver()) .getScreenshotAs(OutputType.FILE);
	        Point p = element.getLocation();
	        int width = element.getSize().getWidth();
	        int height = element.getSize().getHeight();
	        Rectangle rect = new Rectangle(width, height);
	        BufferedImage img = null;
	        img = ImageIO.read(screen);
	        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
	        ImageIO.write(dest, "png", screen);
	        return screen;
	        }
	        catch (Exception ignored)
	        {
	            ignored.printStackTrace();
	           LOGGER.error(ignored);
	            return null;
	        }
	    
	    }
	    
	    public static boolean doImageTest(By by, int Section) throws Exception
	    {
	    	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    	String ImageName =  stackTraceElements[2].getMethodName() + "." + stackTraceElements[2].getClassName() + Section + ".png";
	    	return doImageTest(by,ImageName);
	    }
	    public static boolean doImageTest(By by)
	    {
	    	
	    	StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    	String ImageName =  stackTraceElements[2].getMethodName() + "." + stackTraceElements[2].getClassName() + ".png";
	    	return doImageTest(by,ImageName);
	    	
	    }
	    public static boolean doImageTest(By by,String ImageName) {

			try{
			if(Driver.Exist(by,1))
				if(Properties.CraeteBaseLine)
		    	{
		    		FileUtils.copyFile(Driver.shoot(by),new File(Properties.getProperty("ImageBaselineFolder") + Driver.defaultDriver + "/" + ImageName));
		    		return true;
		    	}
		    	else
		    	{
		    		System.out.println("Executing : c:/img/ConsoleImageComparison.exe \""+ Properties.getProperty("ImageBaselineFolder") + Driver.defaultDriver + "/" + ImageName +"\" \"" + Properties.getProperty("ImageCurrentFolder")+ Driver.defaultDriver + "/" + ImageName + "\" \"" + Properties.getProperty("ImageResultFolder")+ Driver.defaultDriver + "/" + ImageName + "\"");
		    		FileUtils.copyFile(Driver.shoot(by),new File(Properties.getProperty("ImageCurrentFolder") + Driver.defaultDriver + "/" + ImageName));
		    		Process diff = Runtime.getRuntime().exec("c:/img/ConsoleImageComparison.exe \""+ Properties.getProperty("ImageBaselineFolder") + Driver.defaultDriver + "/" + ImageName +"\" \"" + Properties.getProperty("ImageCurrentFolder")+ Driver.defaultDriver + "/" + ImageName + "\" \"" + Properties.getProperty("ImageResultFolder")+ Driver.defaultDriver + "/" + ImageName + "\"");
		    		int diifrence = diff.waitFor();
		    		//Properties.REPORTER.RPT_Image((Properties.getProperty("ImageResultFolder") + Driver.defaultDriver + "/" + ImageName +"_diff.png"));
		    		System.out.println("Image Differance is: " + diifrence + "%");
		    		if(diifrence>0)
		    		{	
		    			//Properties.REPORTER.RPT_Error("Image Difference is: " + diifrence + "%");
		    			return false;
		    		
		    		}
		    		else
		    		{
		    			//Properties.REPORTER.RPT_Info("Image Difference is: " + diifrence + "%");
		    			return true;
		    		}
		    		
		    	}
	    	else
				return false;}
	    	catch(Exception e)
	    	{
	    		LOGGER.error(e);
	    		e.printStackTrace();
	    		return false;
	    	}
		
		}

}
