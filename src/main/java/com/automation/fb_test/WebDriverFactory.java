package com.automation.fb_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

public class WebDriverFactory {

	private static WebDriver driver = null;
	private static final String  URL = "https://facebook.com/";
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		WebDriverFactory.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void intializeWebDriver() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\aurph\\Desktop\\Workspace\\selenium-java-3.0.0-beta4\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
	public static void WaitImplicit(int milliseconds){
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}
	
	public static void WaitUntilVisible(By locater){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(locater));
	}
	
	public static WebElement webDriverFluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");
				
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

}
