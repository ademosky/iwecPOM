package pageObjects;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Base;

public class CommonPageObjects extends Base {

	public CommonPageObjects() {
		PageFactory.initElements(driver, this);
		}
	
	
	
	
	
	public void waitUntilElementIsClickable(WebElement clickableElement) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		   WebDriverWait wait = new WebDriverWait(driver, 15);
		   wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}
	public void print(String action) {
		System.out.println(action);
	}
	public void selectFromDropMenu(WebElement dropMenuElement, String visibleText) {
		Select driver = new Select(dropMenuElement);
		driver.selectByVisibleText(visibleText);
	}
	public void selectFromDropMenuByValue(WebElement dropMenuElement, String value) {
		Select driver = new Select(dropMenuElement);
		driver.selectByValue(value);
	}
	public void waitElement(WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
	}
	public void waitVisibilityOfElement (WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void selectFromDropMenuByIndex(WebElement elementDropDown, int index ) {
		Select select = new Select(elementDropDown);
		select.selectByIndex(index);
	}
	public void assertCurrentWithExpectedUrl(String expectedUrl) {
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		System.out.println(driver.getCurrentUrl() +  "="  + expectedUrl);
			
	}
	public void assertCurrentWithExpectedTitle(String expected_title) {
		String actual_title =  driver.getTitle();
		Assert.assertEquals(actual_title, expected_title);
	}
	public void assertActualWithExpectedText(WebElement actual, String expected) {
		String actual_msg = actual.getText();
		Assert.assertEquals(actual_msg, expected);
		System.out.println(actual_msg + "=" + expected);
	}
	public void sendKeysToField(WebElement webelement, String typeTextString) {
		webelement.sendKeys(typeTextString);
	}
	public void closeBrowser() {
		driver.quit();
	}
	
}

