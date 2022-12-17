package pageObjects;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Base;
import testData.TestData;

public class ProductDetailPageObjects extends Base {
	TestData td = new TestData();
	

	
	
	@FindBy(id = "product_attribute_11")
	public	WebElement productSize;
	@FindBy(id = "product_enteredQuantity_27")
	public WebElement productQuantity;
	@FindBy(id = "add-to-cart-button-27")
	public	WebElement addToCartPDP;
	@FindBy(xpath = "//span[@class=\"sku-number\"]")
	public	WebElement nikeSkuNumber;
	@FindBy(xpath = "//span[@class=\"cart-label\"]")
	public WebElement shoppingCart;
	@FindBy(xpath = "//h2[@class=\"product-title\"]/child::a[@href=\"/levis-511-jeans\"]")
	public WebElement levis511JeansProduct;
	@FindBy(xpath = "(//button[@class=\"button-2 product-box-add-to-cart-button\"])[2]")
	public WebElement levis511AddToCartBtn;
	@FindBy(xpath = "//input[@class=\"qty-input\"]")
	public WebElement itemQuantityLevis511;
	@FindBy(id = "updatecart")
	public	WebElement updateCartBtn;
	@FindBy(xpath = "//span[@class=\"product-unit-price\"]")
	public	WebElement priceField;
	@FindBy(xpath = "//a[@class=\"button-2 download-sample-button\"]")
	public WebElement downloadNightVisionProduct;
	@FindBy(id = "termsofservice")
	public WebElement termsOfServiceShCart;
	@FindBy(id = "checkout")
	public WebElement checkOutBtn;
	@FindBy(xpath = "//a[@href=\"/cart\"]")
	public WebElement shopingCartPopUpBtn;
	
	
	public ProductDetailPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectProductSize(WebElement sizeBtn, String sizeValue) {
		Select productSize = new Select(sizeBtn);
		productSize.selectByVisibleText(sizeValue);
	}
	public void typeProductQuantity(String quantityValueNum) {
		productQuantity.clear();
		productQuantity.sendKeys(quantityValueNum);
	}
	public void verifySkuNumber(String actual_skuNmb, String expected_skuNmb) {
		
		Assert.assertEquals(actual_skuNmb, expected_skuNmb);
		
	}
	public void waitUntilElementIsClickable(WebElement clickableElement) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		   WebDriverWait wait = new WebDriverWait(driver, 15);
		   wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}
	public void changeQuantity(String value )  {
		itemQuantityLevis511.clear();
		waitUntilElementIsClickable(itemQuantityLevis511);
		itemQuantityLevis511.sendKeys(value);
		waitUntilElementIsClickable(updateCartBtn);
		updateCartBtn.click();
		
			
	}
	public void assertPrices(String actual_price, String expected_price) {
		Assert.assertEquals(actual_price, expected_price);
		
	}
	public void navigateToCheckOutPage() {
		termsOfServiceShCart.click();
		checkOutBtn.click();
	}
		
	
}


