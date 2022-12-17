package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class LoginPageObjects extends Base {
	
	TestData td = new TestData();
	HomePageObjects hp = new HomePageObjects();
	
	@FindBy(xpath = "//input[@id=\"Email\"]")
		WebElement emailInputField;
	@FindBy(xpath = "//input[@id=\"Password\"] ")
		WebElement passwordInputField;
	@FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
		WebElement logInBtnLp;
	@FindBy(xpath = "//a[@class=\"ico-logout\"]")
		WebElement logOutBtn;

	
	
	//Almir
	
	
	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void logInUser(String username, String password) {
		hp.logInBtnHomePage.click();
		emailInputField.sendKeys(username);
		passwordInputField.sendKeys(password);
		logInBtnLp.click();
	}

	
}
