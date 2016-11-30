package com.automation.fb_test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Scenerio_03 extends WebDriverFactory {
	
	@Test
	public void selectingSoccerstarsGames() throws IOException, InterruptedException{

		
		HomePage homePage = new HomePage();
		Games gamepage = new Games();
		
		getDriver().findElement(By.xpath("//a[@title='Check out Facebook games.']")).click();
		Util.hoverOver(By.xpath("//div[@class='_1_x_'][text()='Battle']"));
		gamepage.clickOnSportsField();
		Util.hoverOver(By.xpath("//a[contains(@href,'soccerstars')]"));
}
}
