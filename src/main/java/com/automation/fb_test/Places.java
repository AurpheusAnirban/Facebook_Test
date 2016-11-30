package com.automation.fb_test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Places extends Base {
	By SearchCityField = By.xpath("//input[@name='city_name'][@placeholder='City name']");
	By autoCompleteListField = By.xpath("//li[@class=''][contains(@title,'New')]");
    By chooseCityField = By.xpath("//span[@class='text'][text()='New York']");
    By chooseNearbyCity = By.xpath("//a[@target='_blank'][contains(@href,'Manhattan-New-York')]");
    String expectedHeadLine = WebDriverFactory.getDriver().getTitle();
    
    
    
    public void enterCityKeyword(String input) throws IOException{
    	sendKeys(SearchCityField, input);
    }
    
    public void collectCityList(String input)throws IOException{
    	AutoComplete(autoCompleteListField, input);
    }
    public void clickOnCityName(String cityName){
    	
    	AutoComplete(SearchCityField, cityName);
    }
 public void clickOnNearbyCity() throws IOException{
    	
    	clickOn(chooseNearbyCity);
 }
 
 
 public void ExpectedPageHeadline(String expectedTitle){
		verifyTitleOfAPage(expectedTitle);

    }
}   
    