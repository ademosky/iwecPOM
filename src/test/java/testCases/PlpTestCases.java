package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.ProductDetailPageObjects;
import pageObjects.ProductListPageObjects;
import testData.TestData;

public class PlpTestCases extends Base {
	HomePageObjects hp;
	ProductListPageObjects plp;
	TestData td;
	ProductDetailPageObjects pdp;
	CommonPageObjects comm;
	
	@BeforeMethod
	public void start() {
		openApplication();
		hp = new HomePageObjects();
		plp = new ProductListPageObjects();
		td = new TestData();
		pdp = new ProductDetailPageObjects();
		comm = new CommonPageObjects();
		
	}
	@AfterMethod
	public void end() {
		//comm.closeBrowser();
	}
	@Test
	public void TC_PRODUCT_009_verifyCompareTwoProducts() throws InterruptedException  {
		hp.navigateToElectronicsCategory();
		plp.cellPhonesSubCategory.click();
		plp.addCompareNokiaLumia.click();
		comm.waitVisibilityOfElement(plp.addCompareHtcOneMiniBlue);
		plp.addCompareHtcOneMiniBlue.click();
		comm.waitElement(plp.productComparisonBtn);
		plp.productComparisonBtn.click();
		comm.waitElement(plp.comapreHtcOneMiniBlue);
		plp.verifyComparisonFunctionality(plp.compareNokiaLumia);
		plp.verifyComparisonFunctionality(plp.comapreHtcOneMiniBlue);
			
	}
	@Test
	public void TC_PRODUCT_011_verifyClearListFunctionaliy()  {
		hp.navigateToElectronicsCategory();
		plp.cellPhonesSubCategory.click();
		plp.addCompareHtcOneMiniBlue.click();
		plp.addCompareNokiaLumia.click();
		plp.productComparisonBtn.click();
		plp.verifyComparisonFunctionality(plp.compareNokiaLumia);
		plp.verifyComparisonFunctionality(plp.comapreHtcOneMiniBlue);
		plp.clearCompareListBtn.click();
		plp.verifyClearListBtnFunctionality(plp.noProductsToCompare.getText(), td.noCompareProductMsg);
		
	}

	

}
