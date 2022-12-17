package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class CheckOutPageObjects extends Base {
	
	 
	CommonPageObjects comm = new CommonPageObjects();
	TestData td = new TestData(); 
	@FindBy(id = "BillingNewAddress_FirstName") public WebElement firstNameBillingAddress;
	@FindBy(id = "BillingNewAddress_LastName")	public WebElement lastNameBillingAddress;
	@FindBy(id = "BillingNewAddress_Email")		public WebElement emailBillingAddress;
	//@FindBy(id = "BillingNewAddress_CountryId") public WebElement countryDropMenuBillingAddress;
	//@FindBy(id = "BillingNewAddress_City")		public WebElement cityBillingAddress;
	
	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']") 				public WebElement countryFieldMenuBillingAddress;
	@FindBy(id = "ShipToSameAddress")											public WebElement shipToSameAddressBillingAddress;
	@FindBy(id = "BillingNewAddress_City") 										public WebElement cityBillingAddress;
	@FindBy(id = "BillingNewAddress_Address1") 									public WebElement addressBillingAddress;
	@FindBy(id = "BillingNewAddress_ZipPostalCode") 							public WebElement zipCodeBillingAddress;
	@FindBy(id = "BillingNewAddress_PhoneNumber")								public WebElement phoneNumBillingAddress;
	@FindBy(xpath = "//button[@class='button-1 new-address-next-step-button']") public WebElement continueButtonBillingAddress;
	@FindBy(id = "billing-address-select") 								public WebElement selectBillingAddress;
	@FindBy(xpath = "//select[@id='shipping-address-select']") 			public WebElement selectShippingAddress;
	@FindBy(xpath = "(//select[@data-trigger='country-select'])[2]") 	public WebElement countryFieldMenuShippingAddress;
	@FindBy(xpath = "//input[@id='ShippingNewAddress_City']") 			public WebElement cityShippingAddress;
	@FindBy(xpath = "//input[@id='ShippingNewAddress_Address1']") 		public WebElement addressShippingAddress;
	@FindBy(xpath = "//input[@id='ShippingNewAddress_ZipPostalCode']")	public WebElement zipCodeShippingAddress;
	@FindBy(xpath = "//input[@id='ShippingNewAddress_PhoneNumber']")	public WebElement phoneShippingAddress;
	@FindBy(xpath = "(//button[@class='button-1 new-address-next-step-button'])[2]") public WebElement continueBtnShippingPage;
	@FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")  public WebElement continueBtnShippingMethod;
	@FindBy(id = "paymentmethod_1") 												 public WebElement creditCardMethodBtn;
	@FindBy(xpath = "//button[@class=\"button-1 payment-method-next-step-button\"]") public WebElement continueBtnPaymentMethod;
	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']") 	 public WebElement continueBtnPaymentInfoMethod;
	@FindBy(xpath = "//button[@class=\"button-1 confirm-order-next-step-button\"]")  public WebElement confirmBtnCheckOut;
	@FindBy(xpath = "//button[@class=\"button-1 order-completed-continue-button\"]") public WebElement continueBtnCompletedOrder;
	@FindBy(xpath = "//select[@id='CreditCardType']") 								 public WebElement creditCardDropMenu;
	@FindBy(id = "CardholderName") public WebElement cardHolderNameField;
	@FindBy(id = "CardNumber")	   public WebElement cardNumberField;
	@FindBy(id = "ExpireMonth")	   public WebElement expireMonthDropMenu;
	@FindBy(id = "ExpireYear")     public WebElement expireYearDropMenu;
	@FindBy(id = "CardCode")	   public WebElement cardCodeField;
	@FindBy(xpath = "//button[@class=\"button-1 checkout-as-guest-button\"]") public WebElement checkOutAsGuestBtn;
	
	
	public CheckOutPageObjects() {
		PageFactory.initElements(driver, this);
		}
	public void populateValidCreditCard(String cardType,String cardholder,String month, String cardNum,String year, String cardCode) {
		comm.selectFromDropMenuByValue(creditCardDropMenu, "MasterCard");
		cardHolderNameField.sendKeys(cardholder);
		cardNumberField.sendKeys(cardNum);
		comm.selectFromDropMenu(expireMonthDropMenu, month);
		comm.selectFromDropMenu(expireYearDropMenu, year);
		cardCodeField.sendKeys(cardCode);
		continueBtnPaymentInfoMethod.click();
	}
	
	public void validMandatoryValuesBillingAddressPage(String country, String city, String address, String zipCode, String phoneNum) {
		comm.selectFromDropMenuByValue(countryFieldMenuBillingAddress, country);
		cityBillingAddress.sendKeys(city);
		addressBillingAddress.sendKeys(address);
		zipCodeBillingAddress.sendKeys(zipCode);
		phoneNumBillingAddress.sendKeys(phoneNum);
		continueButtonBillingAddress.click();
	}
	public void validMandatoryValuesShippingAddressPage(String country, String city, String address, String zipCode, String phoneNum) {
		comm.selectFromDropMenuByValue(countryFieldMenuShippingAddress, country);
		cityShippingAddress.sendKeys(city);
		addressShippingAddress.sendKeys(address);
		zipCodeShippingAddress.sendKeys(zipCode);
		phoneShippingAddress.sendKeys(phoneNum);
		continueBtnShippingPage.click();
		
	}
	public void ifBillingAddressBookIsPopulatedOrNot() {
		int billingAddressBook = driver.findElements(By.xpath("//label[@for='billing-address-select']")).size();
		if (billingAddressBook == 0) {
			validMandatoryValuesBillingAddressPage(td.countryValue, td.cityCop, td.addressCop, td.zipCop, td.phoneCop);
			continueButtonBillingAddress.click();
		} else if (billingAddressBook > 0){
			//comm.waitElement(selectBillingAddress);
			//comm.selectFromDropMenu(selectBillingAddress, "New Address");
			continueButtonBillingAddress.click();
		}
		
		
	}
		
		
		public void populateFirstLastEmailBillingAddressPage(String firstName, String lastName, String email) {
			firstNameBillingAddress.sendKeys(firstName);
			lastNameBillingAddress.sendKeys(lastName);
			emailBillingAddress.sendKeys(email);
			
		}

	
	
}
