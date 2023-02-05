package testCases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ProductDetailPageObjects;
import pageObjects.ProductListPageObjects;
import testData.TestData;

public class PdpTestCases extends Base {
	
	HomePageObjects hp;
	ProductListPageObjects plp;
	TestData td;
	ProductDetailPageObjects pdp;
	CommonPageObjects comm;
	LoginPageObjects lp;
	
	@BeforeMethod
	public void start() {
		openApplication();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		plp = new ProductListPageObjects();
		td = new TestData();
		pdp = new ProductDetailPageObjects();
		comm = new CommonPageObjects();
		
	}
	@AfterMethod
	public void end() {
		driver.quit();
	}
	
	@Test
	public void testCaseFromClass() {
		hp.navigateToSubcategory(hp.apparelCategory, hp.clothingSubCategory);
		hp.navigateToClothingSubCategory();
		plp.nikeTailwindLoose.click();
		pdp.selectProductSize(pdp.productSize, td.nikeSizeValue);
		pdp.typeProductQuantity(td.quantityValueNumNike);
		pdp.addToCartPDP.click();
		comm.waitUntilElementIsClickable(pdp.shoppingCart);
		pdp.shoppingCart.click();
		pdp.assertSkuNumber(pdp.nikeSkuNumber, td.nikeSkuValue);
		
	}
	@Test
	public void TC_DETAILS_003() {
		lp.logInUser(td.validEmail, td.validPassword);
		hp.navigateToSubcategory(hp.electronicsCategory, hp.cameraAndPhotoDropDown);
		plp.leicaProduct.click();
		pdp.addReviewBtn.click();
		comm.sendKeysToField(pdp.addTitleReview, td.tittleReview);
		comm.sendKeysToField(pdp.addTextReview, td.textReview);
		pdp.submitReviewBtn.click();
		comm.assertActualWithExpectedText(pdp.succesfulReviewMessage, td.successfulReviewMessageExpected);
			
	}
	@Test
	public void TC_DETAILS_001() {
		hp.navigateToComputersCategory();
		hp.softwarePdp.click();
		plp.windows8Pro.click();
		comm.assertCurrentWithExpectedUrl(td.windows8Url);
	}
	@Test
	public void TC_DETAILS_002() {
		hp.navigateToElectronicsCategory();
		hp.cameraAndPhotoCategory.click();
		plp.leicaProduct.click();
		pdp.addReviewBtn.click();
		comm.assertActualWithExpectedText(pdp.reviewErrorMsg, td.reviewErrorMsgExpected);
	}
	@Test
	public void TC_DETAILS_013_downloadFromPdp() {
		hp.navigateToDigitalCategory();
		plp.nightVisionsProduct.click();
		pdp.downloadNightVisionProduct.click();
		driver.switchTo().alert().accept();
			
	}
	
}
