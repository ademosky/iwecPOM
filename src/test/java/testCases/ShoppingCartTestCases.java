package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePageObjects;
import pageObjects.ProductDetailPageObjects;
import pageObjects.ProductListPageObjects;
import testData.TestData;

public class ShoppingCartTestCases extends Base {
	HomePageObjects hp;
	ProductListPageObjects plp;
	TestData td;
	ProductDetailPageObjects pdp;
	
	@BeforeMethod
	public void start() {
		openApplication();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		hp = new HomePageObjects();
		plp = new ProductListPageObjects();
		td = new TestData();
		pdp = new ProductDetailPageObjects();
		
		
	}
	@AfterMethod
	public void end() {
		driver.quit();
	}
	@Test
	public void TC_CART_022() {
	
		hp.navigateToClothingSubCategory();
		pdp.levis511AddToCartBtn.click();
		pdp.waitUntilElementIsClickable(pdp.shoppingCart);
		pdp.shoppingCart.click();
		pdp.waitUntilElementIsClickable(pdp.itemQuantityLevis511);
		pdp.assertPrices(pdp.priceField.getText(), td.priceItemValue_1);
		pdp.changeQuantity(td.levisItemValue_01);
		pdp.assertPrices(pdp.priceField.getText(), td.priceItemValue_01);
		pdp.changeQuantity(td.levisItemValue_02);
		pdp.assertPrices(pdp.priceField.getText(), td.priceItemValue_02);
		pdp.changeQuantity(td.levisItemValue_03);
		pdp.assertPrices(pdp.priceField.getText(), td.priceItemValue_03);
		
		
	}

}
