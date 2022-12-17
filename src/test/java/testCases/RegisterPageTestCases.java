package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.RegisterPageObjects;
import testData.TestData;

public class RegisterPageTestCases extends Base {
	HomePageObjects hp;
	RegisterPageObjects rp;
	TestData td;
	CommonPageObjects comm;
	@BeforeMethod
	public void start() {
		openApplication();
		hp = new HomePageObjects();
		rp = new RegisterPageObjects();
		td = new TestData();	
		comm = new CommonPageObjects();
	}
	@AfterMethod
	public void end() {
		comm.closeBrowser();
	}
	@Test
	public void TC_REGISTER_002_registerWithValidCredentials() {
		hp.navigateToRegisterPage();
		rp.registerUser(td.validFirstName, td.validLastName, td.validEmail, td.validPassword, td.validConfirmPassword);
		comm.assertCurrentWithExpectedUrl(td.succsesfulRegisterUrl);
		
		}
	@Test
	public void TC_REGISTER_003_registerWithInvalidEmail() {
		hp.navigateToRegisterPage();
		rp.registerUser(td.validFirstName, td.validLastName, td.invalidEmail, td.validPassword, td.validConfirmPassword);
		comm.assertCurrentWithExpectedUrl(td.UnsuccsesfulRegisterURL);
		
	}
	@Test
	public void TC_REGISTER_005_registerWithDifferentPassAndConfirmPass() {
		hp.navigateToRegisterPage();
		rp.registerUser(td.validFirstName, td.validLastName, td.validEmail, td.validPassword, td.invalidConfirmPassword);
		comm.assertCurrentWithExpectedUrl(td.UnsuccsesfulRegisterURL);
	}
	@Test
	public void TC_REGISTER_007_registerWithEmptyPassword() {
		hp.navigateToRegisterPage();
		rp.registerUser(td.validFirstName, td.validLastName, td.validEmail, td.emptyPassword, td.validConfirmPassword);
		comm.assertCurrentWithExpectedUrl(td.UnsuccsesfulRegisterURL);
	}

}
