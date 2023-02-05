package pageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class ShoppingCartPageObjects extends Base {
	TestData td = new TestData();
	public ShoppingCartPageObjects() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id = "termsofservice")  
	public WebElement termsOfService;
	@FindBy(id = "checkout") 
	public WebElement checkOutBtnShoppingCart;
	@FindBy(xpath = "//button[@class=\"remove-btn\"]")
	public WebElement removeBtnShoppingCart;
	@FindBy(xpath = "//div[@class=\"no-data\"]")
	public WebElement textEmptyShoppingCart;
	@FindBy(xpath = "//div[@id=\"terms-of-service-warning-box\"]")
	public WebElement termsOfServiceErrorMsg;
		
}


