package testCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePageObjects;
import pageObjects.SearchPageObjects;
import testData.TestData;

public class SearchPageTestCases extends Base {
	HomePageObjects hp;
	SearchPageObjects sp;
	TestData td;
	
	@BeforeMethod
	public void start() {
		openApplication();
		hp = new HomePageObjects();
		sp = new SearchPageObjects();
		td = new TestData();	
	}
	@AfterMethod
	public void end() {
		//driver.quit();
	}
	@Test
	public void TC_SEARCH001_searchExcistingProduct() {
		sp.searchFunctionality(td.existingProduct);
		sp.verifySearchFunctionality(driver.getCurrentUrl(), td.searchWithExistingProductUrl);
		}
	@Test
	public void TC_SEARCH_009_advancedSearchFunctionality() {
		sp.searchFunctionality(td.advancedSearchPhrase);
		sp.advancedSearchRadioBtn.click();
		sp.Select(sp.categoryAdvancedSrc, td.computerValue);
		sp.advancedSearchBtn.click();
		sp.verifySearchFunctionality(sp.noResultMsg.getText(), td.noProductFoundMsg);
		sp.advancedSearchBtn.click();
	}

}
