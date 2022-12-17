package testCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CheckOutPageObjects;
import pageObjects.CommonPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ProductDetailPageObjects;
import pageObjects.ProductListPageObjects;
import pageObjects.ShoppingCartPageObjects;
import testData.TestData;

public class CheckOutTestCases extends Base{

	HomePageObjects hp;
	LoginPageObjects lp;
	ProductListPageObjects plp;
	TestData td;
	ProductDetailPageObjects pdp;
	CommonPageObjects comm;
	CheckOutPageObjects cop;
	ShoppingCartPageObjects shop;
	
	@BeforeMethod
	public void start() {
		openApplication();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		plp = new ProductListPageObjects();
		td = new TestData();
		pdp = new ProductDetailPageObjects();
		comm = new CommonPageObjects();
		cop = new CheckOutPageObjects();
		shop = new ShoppingCartPageObjects();
	}
	
	@AfterMethod
	public void end() {
		comm.closeBrowser();
	}
	@Test
	public void TC_CHECKOUT_011()  {
		hp.navigateToSubcategory(hp.computersCategory, hp.softwareSubcategory);
		plp.addToCartWindows8.click();
		comm.waitUntilElementIsClickable(pdp.shopingCartPopUpBtn);
		pdp.shopingCartPopUpBtn.click();
		shop.termsOfService.click();
		shop.checkOutBtnShoppingCart.click();
		lp.logInUser(td.validEmail, td.validPassword);
		shop.termsOfService.click();
		shop.checkOutBtnShoppingCart.click();
		cop.shipToSameAddressBillingAddress.click();
		cop.ifBillingAddressBookIsPopulatedOrNot();
		comm.selectFromDropMenu(cop.selectShippingAddress, td.newAddress);
		cop.validMandatoryValuesShippingAddressPage(td.countryValue, td.cityCop, td.addressCop, td.zipCop, td.phoneCop);
		cop.continueBtnShippingMethod.click();
		cop.creditCardMethodBtn.click();
		cop.continueBtnPaymentMethod.click();
		cop.populateValidCreditCard(td.creditCardType, td.creditCardholderName, td.creditCardExpireMonth, td.creditCardNumber, td.creditCardExpireYear, td.creditCardCode);
		cop.confirmBtnCheckOut.click();
		cop.continueBtnCompletedOrder.click();
		comm.assertCurrentWithExpectedUrl(td.homePageUrl);	
	}
	@Test
	public void TC_CHECKOUT_010() {
		hp.navigateToSubcategory(hp.computersCategory, hp.softwareSubcategory);
		plp.addToCartWindows8.click();
		comm.waitUntilElementIsClickable(pdp.shopingCartPopUpBtn);
		pdp.shopingCartPopUpBtn.click();
		shop.termsOfService.click();
		shop.checkOutBtnShoppingCart.click();
		cop.checkOutAsGuestBtn.click();
		cop.populateFirstLastEmailBillingAddressPage(td.validFirstName, td.validLastName, td.validEmail);
		cop.validMandatoryValuesBillingAddressPage(td.countryValue, td.cityCop, td.addressCop, td.zipCop, td.phoneCop);
		cop.continueBtnShippingMethod.click();
		cop.continueBtnPaymentMethod.click();
		cop.continueBtnPaymentInfoMethod.click();
		cop.confirmBtnCheckOut.click();
		cop.continueBtnCompletedOrder.click();
		comm.assertCurrentWithExpectedUrl(td.homePageUrl);	



	}
	
	
	
}
