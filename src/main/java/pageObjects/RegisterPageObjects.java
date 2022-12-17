package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import base.Base;
import testData.TestData;

public class RegisterPageObjects extends Base {
	
	TestData td = new TestData();
	
	@FindBy(xpath = "//input[@id=\"FirstName\"]")
		WebElement firstNameField;
	@FindBy(xpath = "//input[@id=\"LastName\"]")
		WebElement lastNameField;
	@FindBy(xpath = "//input[@id=\"Email\"]")
		WebElement emailFieldRegisterPage;
	@FindBy(xpath = "//input[@id=\"Password\"]")
		WebElement passwordFieldRp;
	@FindBy(xpath = "//input[@id=\"ConfirmPassword\"]")
		WebElement confirmPasswordFieldRp;
	@FindBy(xpath = "//button[@id=\"register-button\"]")
		WebElement registerBtnRp;
	
	
	public RegisterPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void registerUser(String firstname, String lastname, String email, String password, String confirmPassword) {
		firstNameField.sendKeys(firstname);
		lastNameField.sendKeys(lastname);
		emailFieldRegisterPage.sendKeys(email);
		passwordFieldRp.sendKeys(password);
		confirmPasswordFieldRp.sendKeys(confirmPassword);
		registerBtnRp.click();
	}
	public void verifySuccesfulRegistration() {
		Assert.assertEquals(driver.getCurrentUrl(), td.succsesfulRegisterUrl);
	}

	public void verifyUnsuccesfulRegistration() {
		Assert.assertEquals(driver.getCurrentUrl(), td.UnsuccsesfulRegisterURL);
	}
}

