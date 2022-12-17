package pageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ShoppingCartPageObjects extends Base {
	public ShoppingCartPageObjects() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id = "termsofservice")  public WebElement termsOfService;
	@FindBy(id = "checkout") public WebElement checkOutBtnShoppingCart;
	

}
