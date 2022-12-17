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

public class PdpTestCases extends Base {
	
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
		//driver.quit();
	}
	
	@Test
	public void testCaseFromClass() {
		hp.navigateToSubcategory(hp.apparelCategory, hp.clothingSubCategory);
		//hp.navigateToClothingSubCategory();
		plp.nikeTailwindLoose.click();
		pdp.selectProductSize(pdp.productSize, td.nikeSizeValue);
		pdp.typeProductQuantity(td.quantityValueNumNike);
		pdp.addToCartPDP.click();
		comm.waitUntilElementIsClickable(pdp.shoppingCart);
		pdp.shoppingCart.click();
		pdp.verifySkuNumber(pdp.nikeSkuNumber.getText(), td.nikeSkuValue);
		
		
	}
	public void TC_DETAILS_013_downloadFromPdp() {
		hp.navigateToDigitalCategory();
		plp.nightVisionsProduct.click();
		pdp.downloadNightVisionProduct.click();
		
		
	}
	
}
