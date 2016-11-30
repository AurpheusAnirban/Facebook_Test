package com.automation.fb_test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class Games extends Base {
	By battleField = By.xpath("//div[@class='_1_x_'][text()='Battle']");
	By sportsField = By.xpath("//span[@class='_5pj-'][text()='Sports']");
	By soccerStars = By.xpath("//a[contains(@href,'soccerstars')]");
	
public void clickOnSportsField() throws IOException{
    	
    	clickOn(sportsField);
 }

}
