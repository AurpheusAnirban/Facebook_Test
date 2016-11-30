package com.automation.fb_test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;



public class Util {

	
protected static void getScreenshot() throws IOException{
		
		File src = ((TakesScreenshot)WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("ScreenShot(Date_Time) (" + dateAndTime() + ").jpg"));
	}
	
	
	private static String dateAndTime() {
		
		String dateFormat = new SimpleDateFormat("MM_dd_yyyy_HHmmss").format(Calendar.getInstance().getTime());
		return dateFormat;
	}	
	public static void hoverOver(By locater){
		Actions action = new Actions(WebDriverFactory.getDriver());
		action.moveToElement(WebDriverFactory.webDriverFluentWait(locater)).build().perform();
	}	
	public static void waitOn(){
		
		WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
     public static void scrollDown() throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
		js.executeScript("window.scrollBy(0,9000)");
		Thread.sleep(10000);
	}
}



