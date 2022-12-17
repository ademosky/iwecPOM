package testCases;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;

public class ExplicitWaitsTest extends Base{
	
	
	@AfterMethod
	public void end() {
		driver.quit();
	}
	@Test
	public void explicitWaitsTest_01() {
		openApplication1();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.findElement(By.xpath("//button")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id=\"finish\"]/child::h4")));
		String actual_text = driver.findElement(By.xpath("//div[@id=\"finish\"]/child::h4")).getText();
		String expected_text = "Hello World!";
		Assert.assertEquals(actual_text, expected_text);
		System.out.println(actual_text);
	}
	@Test
	public void explicitWaitsTest_02() {
		
		openApplication2();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id=\"landscape\"]")));
		String actual_text = driver.findElement(By.xpath("//p[@id=\"text\"]")).getText();
		String expected_text = "Done!";
		Assert.assertEquals(actual_text, expected_text);
		System.out.println(actual_text);
		
	}
	@Test
	public void explicitWaitsTest_03_DynamicButtons() {
		openApplication3();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button00"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button01"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("buttonmessage"), "All Buttons Clicked"));
		String actual_text = driver.findElement(By.id("buttonmessage")).getText();
		String expected_text = "All Buttons Clicked";
		Assert.assertEquals(actual_text, expected_text);
		System.out.println(actual_text);
		
	}
	@Test
	public void explicitWaitsTest_04_AjaxData() {
		openApplication4();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.id("ajaxButton")).click();
		String txt_msg = "Data loaded with AJAX get request.";
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@class=\"bg-success\"]"), txt_msg));
		String actual_text = driver.findElement(By.xpath("//p[@class=\"bg-success\"]")).getText();
		Assert.assertEquals(actual_text, txt_msg);
		System.out.println(actual_text);
	}
	public void chromeTestClass() {
		
	}
}
