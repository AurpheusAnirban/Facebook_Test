package com.automation.fb_test;

import java.io.IOException;

import org.openqa.selenium.By;

public class HomePage extends Base {

	By phoneNoField = By.xpath("//input[@type='text' and @id='u_0_6']");
			//By.id("u_0_6");
			
	By reEnterPhoneNoField = By.id("u_0_9");
			//By.xpath("//input[@type='text' and @id='u_0_8']");
	By mismatchErrorMessage = By.xpath("//div[@class='_5633 _5634 _53ij'][contains(text(),'numbers do not match')]");
	By placeField = By.xpath("//a[contains(text(),'Places')][contains(@title,'Check out')]");
	By gamesField = By.xpath("//a[@title='Check out Facebook games.']");
			//"//a[contains(@href,'games')][text()='Games']");
		

public void enterPhoneNo(String input) throws IOException{
	sendKeys(phoneNoField, input);
}

public void reEnterPhoneNo(String input) throws IOException{
	sendKeys(reEnterPhoneNoField, input);
}
public void clickPhoneNoField() throws IOException{
	
	clickOn(phoneNoField);
}
public void clickRePhoneNoField() throws IOException{
	
	clickOn(reEnterPhoneNoField);
}

public void enterExpectedErrorMessage(String input){
	
	verifyErrorMessage(mismatchErrorMessage, input);
}
public void clickPlaceField() throws IOException{
	
	clickOn(placeField);
}
	
public void clickGamesField() throws IOException{
		
		clickOn(gamesField);
	}
}


