package testCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testData.TestData;



public class LoginPageTestCases extends Base {
		
		HomePageObjects hp;
		LoginPageObjects lp;
		TestData td;
		CommonPageObjects comm;
		
		@BeforeMethod
		public void start() {
			openApplication();
			hp = new HomePageObjects();
			lp = new LoginPageObjects();
			td = new TestData();
			comm = new CommonPageObjects();
		}
		@AfterMethod
		public void end() {
			comm.closeBrowser();
		}
		
		
		
		@Test
		public void TC_LOGIN_002_logInWithValidCredentials() {
			lp.logInUser(td.validEmail, td.validPassword);
			comm.assertCurrentWithExpectedTitle(td.homePageTitle);	
		}
		@Test
		public void logInWithInvalidEmailField() {
			lp.logInUser(td.invalidEmail, td.validPassword);
			comm.assertCurrentWithExpectedTitle(td.logInPageTitle);
			}
		@Test
		public void TC_LOGIN_003_logInWithValidEmailInvalidPass() {
			lp.logInUser(td.validEmail, td.invalidPassword);
			comm.assertCurrentWithExpectedUrl(td.logInErrorUrl);
		}
		@Test
		public void TC_LOGIN_006_logInWithEmptyMailAndPass() {
			lp.logInUser(td.emptyEmail, td.emptyPassword);
			comm.assertCurrentWithExpectedTitle(td.logInPageTitle);
		
		}
		

}
