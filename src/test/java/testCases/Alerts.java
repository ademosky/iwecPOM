package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class Alerts extends Base{
	
	@BeforeMethod
	public void testStart() {
		openApplicationWithUrl("https://the-internet.herokuapp.com/javascript_alerts");
	
	}
	@AfterMethod
	public void testEnd() {
		driver.quit();
	}
	
	
	@Test
	public void javaScript_Alert() {
		driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
		driver.switchTo().alert().accept();
		String actual_msg = driver.findElement(By.id("result")).getText();
		String expected_msg = "You successfully clicked an alert";
		Assert.assertEquals(actual_msg, expected_msg);
		
	}
	@Test
	public void javaScript_Confirm() {
		driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
		driver.switchTo().alert().accept();
		String actual_msg = driver.findElement(By.id("result")).getText();
		String expected_msg = "You clicked: Ok";
		Assert.assertEquals(actual_msg, expected_msg);		
	}
	@Test
	public void javaScript_Prompt() {
		driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
		driver.switchTo().alert().sendKeys("alert test");
		driver.switchTo().alert().accept();
		String actual_msg = driver.findElement(By.id("result")).getText();
		String expected_msg = "You entered: alert test";
		Assert.assertEquals(actual_msg, expected_msg);	
		
		
	}
}
