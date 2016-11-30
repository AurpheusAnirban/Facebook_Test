package com.automation.fb_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Base {

	protected void clickOn(By locater) {
		try {
			WebDriverFactory.webDriverFluentWait(locater).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	protected void sendKeys(By locater, String text){
		try {
			WebDriverFactory.webDriverFluentWait(locater).sendKeys(text);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	protected void scrollPageBy(String pixels){
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
		js.executeScript("window.scrollBy(0," + pixels + "9000");
		WebDriverFactory.WaitImplicit(2000);
	}
	
	protected void hoverOver(By locater){
		Actions action = new Actions(WebDriverFactory.getDriver());
		action.moveToElement(WebDriverFactory.webDriverFluentWait(locater)).build().perform();
	}
	
	protected void AutoComplete(By locater, String cityName){
		List <WebElement> list = WebDriverFactory.getDriver().findElements(locater);
		int indexChoice = SearchAutoCompleteAndGetIndex(list, cityName);
		list.get(indexChoice).click();
		}
	
	protected static void switchToWidnow(int index) {

		List<String> listOfWindows = new ArrayList<String>(WebDriverFactory.getDriver().getWindowHandles());
		WebDriverFactory.getDriver().switchTo().window(listOfWindows.get(index));
	}
protected void dropDownFindAndSelect(By locator,String input){
		
		Select dropDown = new Select(WebDriverFactory.getDriver().findElement(locator));
		List<WebElement> listOfAllOptions = dropDown.getOptions();
		for(WebElement element : listOfAllOptions){
	        if(element.getText().equals(input)) {
	        	element.click();
	            break;
	        }else {
	        	Assert.fail("Specefied element was not found in dropdwon");
	        }
		}
}
protected void radioButtonCheckAndSelect(By locator) throws InterruptedException, IOException{
	
	
	try {
	
		boolean isSelcted= WebDriverFactory.getDriver().findElement(locator).isSelected();
	
		if(isSelcted==false){
		
		WebDriverFactory.getDriver().findElement(locator).click();
		Thread.sleep(3000);
		
		}else{
		
		throw new NoSuchElementException("It can not be checked by default");
		}
	
	} catch (NoSuchElementException e) {
	
	e.printStackTrace();
}
} 

			
	protected void verifyErrorMessage(By locator , String expectedMessage ){
		
		String actualMessage = WebDriverFactory.getDriver().findElement(locator).getText();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
protected void verifyTitleOfAPage(String expectedTitle){
		
		String actualTitle = WebDriverFactory.getDriver().getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	private int SearchAutoCompleteAndGetIndex(List<WebElement> list, String cityName){
			for(WebElement option: list){
				if(option.getText().contains(cityName)){
					return list.indexOf(option);
				}
			}return 0;
		}
}
