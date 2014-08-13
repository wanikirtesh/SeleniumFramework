package com.kirwa.webdriver.main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Driver {
	
	private static Logger LOGGER = Logger.getLogger(Driver.class.getName());
	private static long timeout=10;
	private static WebDriver myDriver;
	public static DriverTypes defaultDriver = DriverTypes.FIREFOX;
	private static String winHandleBefore;
	private static FirefoxProfile profile = new FirefoxProfile();
	private static ChromeOptions options = new ChromeOptions();
	public static BrowserLanguage CurrentLanguage = BrowserLanguage.ENGLISH;
	public static void SetDriver(DriverTypes d)
	{
		SetDriver(d, BrowserLanguage.ENGLISH);
	}
	
	public static void SetDriver(DriverTypes d,BrowserLanguage l,Long Timeout)
	{
		SetDriver(d, l);
		LOGGER.debug("Setting Driver Timeout to " + Timeout + " Seconds");
		myDriver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
		timeout=Timeout;
	}
	public static void SetDriver(DriverTypes d,BrowserLanguage l)
	{
		if(myDriver==null)
			{
			switch(d)
			{
				case INTERNETEXPLORER:
					System.setProperty("webdriver.ie.driver", "C:\\Users\\idnkiw\\bin\\IEDriverServer_64.exe");
					myDriver = new InternetExplorerDriver();
					break;
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\idnkiw\\bin\\chromedriver.exe");
					myDriver = new ChromeDriver(options);
					break;
				case FIREFOX:
					myDriver = new FirefoxDriver(profile);
					break;
				case GHOST:
					Capabilities caps = new DesiredCapabilities();
			        ((DesiredCapabilities) caps).setJavascriptEnabled(true);                //< not really needed: JS enabled by default
			        ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);    //< yeah, GhostDriver haz screenshotz!
			        ((DesiredCapabilities) caps).setCapability(
			            PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			            "C:\\DEV\\ghostDriver\\phantomjs-1.9.7-windows\\phantomjs.exe"
			        );
			        myDriver = new PhantomJSDriver(caps);
					break;
			}
			defaultDriver = d;
			LOGGER.debug("Setting Browser to " + d);
			myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			LOGGER.debug("Setting Driver Time Out to 20 Seconds");
			myDriver.manage().window().maximize();
			LOGGER.debug("Maximising Browser Window");
		}
		timeout=10;
		SetBrowserLanguage(l);
	}
	private static void SetBrowserLanguage(BrowserLanguage l){
		// TODO Auto-generated method stub
		try{
		switch(l)
		{
		case CHINESE:
			profile.setPreference("intl.accept_languages", "zh-cn,en-us,en" );
			if(defaultDriver == DriverTypes.INTERNETEXPLORER)
			WinRegistry.writeStringValue(0x80000001, "Software\\Microsoft\\Internet Explorer\\International", "AcceptLanguage", "zh-CN,en-US;q=0.8");
			options.addArguments("--lang=zh");
			break;
		case ENGLISH:
			profile.setPreference("intl.accept_languages", "en-us,en" );
			if(defaultDriver == DriverTypes.INTERNETEXPLORER)
			WinRegistry.writeStringValue(0x80000001, "Software\\Microsoft\\Internet Explorer\\International", "AcceptLanguage", "en-US;q=0.8");
			options.addArguments("--lang=en");
			break;
		case GERMAN:
			profile.setPreference("intl.accept_languages", "de,en-us,en" );
			if(defaultDriver == DriverTypes.INTERNETEXPLORER)
			WinRegistry.writeStringValue(0x80000001, "Software\\Microsoft\\Internet Explorer\\International", "AcceptLanguage", "de-DE,en-US;q=0.5");
			options.addArguments("--lang=de");
			break;
		case SPANISH:
			profile.setPreference("intl.accept_languages", "es,en-us,en" );
			if(defaultDriver == DriverTypes.INTERNETEXPLORER)
			WinRegistry.writeStringValue(0x80000001, "Software\\Microsoft\\Internet Explorer\\International", "AcceptLanguage", "es-ES,en-US;q=0.5");
			options.addArguments("--lang=es");
			break;
		}
		CurrentLanguage = l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error(e);
		}
		
		
	}

	public static void SetDriver(DriverTypes d,long Timeout)
	{
		SetDriver(d);
		LOGGER.debug("Setting Driver Timeout to " + Timeout + " Seconds");
		myDriver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
		timeout=Timeout;
	}
	
	public static void NavigateTo(String strUrl)
	{
		if(myDriver==null)
			SetDriver(defaultDriver);
		LOGGER.debug("Navigating to URL: " + strUrl);
		myDriver.get(strUrl);
		winHandleBefore = myDriver.getWindowHandle();
	}
	
	public static boolean ClickOn(By by)
	{
		if(myDriver==null)
			SetDriver(defaultDriver);
		try
		{
			MakeVisible(by);
			myDriver.findElement(by).click();
			LOGGER.debug("Clicking to URL: " + by);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ClickOn(WebElement webelement)
	{
		if(myDriver==null)
			SetDriver(defaultDriver);
		try
		{
			MakeVisible(webelement);
			webelement.click();
			LOGGER.debug("Clicking on: " + webelement);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public static boolean TypeOn(By by,String Text) {
		if(myDriver==null)
			SetDriver(defaultDriver);
		try
		{
			myDriver.findElement(by).clear();
			myDriver.findElement(by).sendKeys(Text);
			LOGGER.debug("Typing \""+Text+"\" to Element: " + by );
			return true;
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			return false;
		}
	}
	public static WebElement getWebElement(By by)
	{
		LOGGER.debug("Finding Web Element by: " + by);
		return myDriver.findElement(by);
	}
	
	public static List<WebElement> getWebElements(By by)
	{
		LOGGER.debug("Finding Web Element by: " + by);
		return myDriver.findElements(by);
	}
	
	public static long getWebElementsCount(By by)
	{
		LOGGER.debug("Finding Web Element by: " + by);
		return myDriver.findElements(by).size();
	}
	
	public static File shoot(WebElement element) throws IOException
    {
		 try
	        {
			LOGGER.debug("Shooting Web Element by: " + element);
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			File screen = ((TakesScreenshot) myDriver) .getScreenshotAs(OutputType.FILE);
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
	            LOGGER.error(ignored);
	        	ignored.printStackTrace();
	            return null;
	        }
		
    }
	public static File shoot(By by) throws Exception
	{
		try{
			WebElement element = myDriver.findElement(by);
			LOGGER.debug("Shooting Web Element by: " + by);
			return shoot(element);
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			throw e;
		}
	}
	public static WebDriver getDriver()
	{
		return myDriver;
	}
	public static boolean SwitchToFrame(By by)
	{
		try{
			LOGGER.debug("Switching to Frame : " + by);
			myDriver.switchTo().frame(myDriver.findElement(by));
			return true;
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean SwitchDefault()
	{
		try{
			myDriver.switchTo().defaultContent();
			return true;
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean Exist(By by)
	{
		LOGGER.info("Checking Existance of" + by);
		try {
			List<WebElement> x =myDriver.findElements(by);
			if(x.isEmpty())
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) 
		{
			return false;
		}
	}
	public static boolean Exist(By by,long seconds)
	{
		LOGGER.info("Checking Existance of" + by);
		Boolean result=false;
		myDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		result=Exist(by);
		myDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		return result;
	}
	public static void Quit() {
		// TODO Auto-generated method stub
		LOGGER.debug("....... Quitting WebDriver .......");
		myDriver.quit();
	}
	
	public static void ActionClick(By by)
	{
		Actions builder = new Actions(myDriver);
		Action clickelement = builder.click(Driver.getWebElement(by)).build();
		clickelement.perform();
	}
	
	public static void RunJavaScript(String Javascript)
	{
		JavascriptExecutor js;
		js = (JavascriptExecutor)myDriver;
		js.executeScript(Javascript);
	}
	public static void SwitchToPopup()
	{
		try{
			for(String winHandle : myDriver.getWindowHandles()){
				if(!winHandle.equals(winHandleBefore))
					myDriver.switchTo().window(winHandle);
					MaximizeWindow();
			}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
		}
	}
	public static void ClosePopUp()
	{
		try{
		
			for(String winHandle : myDriver.getWindowHandles()){
				if(!winHandle.equals(winHandleBefore))
					{
					myDriver.switchTo().window(winHandle);
					myDriver.close();
					}
				myDriver.switchTo().window(winHandleBefore);
		
		}
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			e.printStackTrace();
		}
	}
	public static void MaximizeWindow()
	{
		myDriver.manage().window().maximize();
	}
	public static void ClickJavaScript(By by)
	{
		JavascriptExecutor executor = (JavascriptExecutor)myDriver;
		executor.executeScript("arguments[0].click();",  myDriver.findElement(by)); 
	}
	public static void MakeVisible(By by)
	{
		MakeVisible(myDriver.findElement(by)); 
	}
	
	/// Make the Element visible on View port by scrolling the page
	public static void MakeVisible(WebElement webelement)
	{
		try{
		Coordinates coordinate = ((Locatable)webelement).getCoordinates(); 
		coordinate.inViewPort();
		//coordinate.onScreen();
		}
		catch(Exception e)
		{
			if(defaultDriver == DriverTypes.CHROME){
				Actions actions = new Actions(myDriver);
				actions.sendKeys(Keys.DOWN);
				actions.build().perform();}
		}
	}
}


