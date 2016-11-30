package com.automation.fb_test;

import java.io.IOException;
import org.testng.annotations.Test;


public class Scenerio_01 extends WebDriverFactory {

	@Test
	public void verifyErrorMessage() throws IOException{
	
		HomePage homePage = new HomePage();
		
		homePage.enterPhoneNo("9292787238");
//		homePage.reEnterPhoneNo("123456789");
//		homePage.clickPhoneNoField();
//		homePage.clickPhoneNoField();
//		homePage.enterExpectedErrorMessage("Manhattan, New York - Manhattan, New York - Places | Facebook");
		
	}
	
}
