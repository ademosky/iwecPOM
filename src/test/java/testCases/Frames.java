package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CommonPageObjects;

public class Frames extends Base{
	CommonPageObjects comm;
	
	@BeforeMethod
	public void startUp() {
		openApplicationWithUrl("https://testpages.herokuapp.com/styled/frames/frames-test.html");
		comm = new CommonPageObjects();
		
	}	
		@Test
		public void frames_test01() {
		driver.switchTo().frame("left");
		WebElement leftFrame = driver.findElement(By.id("left10"));
		String leftFrameText = leftFrame.getText();
		String expectedLeftText = "Left List Item 10";
		comm.assertActualWithExpectedText(leftFrameText, expectedLeftText);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("middle");
		WebElement middleFrame = driver.findElement(By.id("middle2"));
		String middleFrameText = middleFrame.getText();
		String expectedMiddleText = "Middle List Item 2";
		comm.assertActualWithExpectedText(middleFrameText, expectedMiddleText);
	}

}
