package com.automation.fb_test;


import java.io.IOException;
import org.testng.annotations.Test;


public class Scenerio_02 extends WebDriverFactory {

	@Test
	public void findNearbyCity() throws IOException, InterruptedException{
	
	HomePage homePage = new HomePage();
	Places placepage = new Places();
	
	//homePage.clickPlaceField();
	placepage.enterCityKeyword("New");
	Thread.sleep(1000);
	//placepage.collectCityList();
	placepage.clickOnCityName("New York");
	Util.scrollDown();
	placepage.clickOnNearbyCity();
	Thread.sleep(2000);
	placepage.ExpectedPageHeadline("Manhattan, New York - Manhattan, New York - Places | Facebook");
	
	
//	
}
}
