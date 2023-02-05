package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.ProductDetailPageObjects;
import pageObjects.ProductListPageObjects;
import pageObjects.ShoppingCartPageObjects;
import testData.TestData;

public class ShoppingCartTestCases extends Base {
	HomePageObjects hp;
	ProductListPageObjects plp;
	TestData td;
	ProductDetailPageObjects pdp;
	CommonPageObjects comm;
	ShoppingCartPageObjects shop;
	
	@BeforeMethod
	public void start() {
		openApplication();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		hp = new HomePageObjects();
		plp = new ProductListPageObjects();
		td = new TestData();
		pdp = new ProductDetailPageObjects();
		comm = new CommonPageObjects();
		shop = new ShoppingCartPageObjects();
		
		
	}
	@AfterMethod
	public void end() {
		comm.closeBrowser();
	}
	@Test
	public void TC_CART_001() {
		
		hp.navigateToClothingSubCategory();
		pdp.addToCartLevis511.click();
		pdp.shoppingCart.click();
		pdp.assertSkuNumber(pdp.levis511ActualSkuNmb, td.levis511Sku);
		
			
	}
	@Test
	public void TC_CART_002() {
		hp.navigateToBooksCategory();
		pdp.addToCartPridePredujice.click();
		pdp.shoppingCart.click();
		shop.removeBtnShoppingCart.click();
		comm.assertActualWithExpectedText(shop.textEmptyShoppingCart, td.emptyShoppingCart);
	}
	@Test
	public void TC_CART_018() {
		hp.navigateToBooksCategory();
		pdp.addToCartPridePredujice.click();
		pdp.shoppingCart.click();
		shop.checkOutBtnShoppingCart.click();
		comm.assertActualWithExpectedText(shop.termsOfServiceErrorMsg, td.termsOfServiceMsg_expected);
		
		
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
