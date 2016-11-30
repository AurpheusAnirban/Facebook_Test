package com.automation.fb_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
//	public class FacebookDataProviderExample {

	    
	    private WebDriver driver = null;	    

	    @BeforeClass

	    public void beforeClass() {

	    	System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\aurph\\Desktop\\Workspace\\selenium-java-3.0.0-beta4\\geckodriver.exe");
			driver = new FirefoxDriver();
	        driver.get("http://facebook.com");

	    }

	    

	    @AfterClass

	    public void afterMethod() {

	        driver.quit();

	    }

	    

	    @Test(dataProvider="invalid-login-data")

	    public void sampleLoginTest(String username, String password) throws InterruptedException {

	        driver.findElement(By.id("email")).sendKeys(username);
	        Thread.sleep(3000);

	        driver.findElement(By.id("pass")).sendKeys(password);
	        Thread.sleep(3000);

	        driver.findElement(By.id("loginbutton")).click();
	        Thread.sleep(3000);
	        
	        Thread.sleep(3000);

	        // You will verify the error message here then go back Landing

	        driver.navigate().back();

	    }

	    

	    @DataProvider(name="invalid-login-data")

	    public Object[][] dpInavlidLogin() {

	        return new Object[][]{

	            {"test@test.com", "12345"},

	            {"test1@test.com", "23456"},

	            {"test3@test.com", "43212"}};

	        }    

	    }


