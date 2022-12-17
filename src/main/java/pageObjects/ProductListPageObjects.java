package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;
import testData.TestData;

public class ProductListPageObjects extends Base {
	
	TestData td = new TestData();
	
	@FindBy(xpath = "(//a[@href=\"/cell-phones\"])[5]")
	public	WebElement cellPhonesSubCategory;
	@FindBy(xpath = "(//button[@title=\"Add to compare list\"])[2]")
	public	WebElement addCompareHtcOneMiniBlue;
	@FindBy(xpath = "(//button[@title='Add to compare list'])[3]")
	public	WebElement addCompareNokiaLumia;
	@FindBy(xpath = "//a[@href=\"/compareproducts\"]")
	public	WebElement productComparisonBtn;
	@FindBy(xpath = "//tr[@class=\"product-name\"]/descendant::a")
	public	WebElement compareNokiaLumia;
	@FindBy(xpath = "//tr[@class=\"product-name\"]/descendant::a[2]")
	public	WebElement comapreHtcOneMiniBlue;
	@FindBy(xpath = "//a[@class=\"clear-list\"]")
	public WebElement clearCompareListBtn;
	@FindBy(xpath = "//div[@class=\"no-data\"]")
	public WebElement noProductsToCompare;
	@FindBy(xpath = "//h2[@class=\"product-title\"]/descendant::a[@href=\"/nike-tailwind-loose-short-sleeve-running-shirt\"]")
	public	WebElement nikeTailwindLoose;
	@FindBy(xpath = "//a[@href=\"/night-visions\"]")
	public WebElement nightVisionsProduct;
	@FindBy(xpath = "(//button[@class=\"button-2 product-box-add-to-cart-button\"])[2]")
	public WebElement addToCartWindows8;
	
	
	
	
	
	public ProductListPageObjects() {
	PageFactory.initElements(driver, this);
}
	public void verifyComparisonFunctionality(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
		}
	public void verifyClearListBtnFunctionality (String actual_text, String expected_text) {
		Assert.assertEquals(actual_text, expected_text);
	}


}
