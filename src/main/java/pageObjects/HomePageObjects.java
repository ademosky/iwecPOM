package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;


public class HomePageObjects extends Base {
	
	@FindBy(xpath = "//a[@class=\"ico-login\"]")
		WebElement logInBtnHomePage;
	@FindBy(xpath = "//a[@class=\"ico-register\"]")
		WebElement registerBtnHomePage;
	@FindBy(xpath = "//span[@class=\"wishlist-label\"]")
		WebElement wishListHomePage;
	@FindBy(xpath = "//span[@class=\"cart-label\"]")
		WebElement shoppingBtnHomePage;
	@FindBy(xpath = "//button[@class=\"button-1 search-box-button\"]")
		WebElement searchBtnHomePage;
	@FindBy(xpath = "//input[@id=\"small-searchterms\"]")
		WebElement searchFieldHomePage;
	@FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/descendant::a[@href=\"/computers\"]")
	public	WebElement computersCategory;
	@FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/descendant::a[@href=\"/electronics\"]")
		WebElement electronicsCategory;
	@FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/descendant::a[@href=\"/apparel\"]")
	public	WebElement apparelCategory;
	@FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/descendant::a[@href=\"/digital-downloads\"]")
		WebElement digitalDownloadsCategory;
	@FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/descendant::a[@href=\"/books\"]")
		WebElement booksCategory;
	@FindBy(xpath = "//a[@href=\"/clothing\"]")
	public	WebElement clothingSubCategory;
	@FindBy(xpath = "//a[@href=\"/software\"]")
	public WebElement softwareSubcategory;
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
		}
	
	
	public void navigateToLogInPage() {
		logInBtnHomePage.click();
	}
	public void navigateToRegisterPage() {
		registerBtnHomePage.click();
	}
	public void navigateToWishList() {
		wishListHomePage.click();
	}
	public void navigateToShoppingCart() {
		shoppingBtnHomePage.click();
	}
	public void navigateToSearchPage() {
		searchBtnHomePage.click();
	}
	public void navigateToComputersCategory() {
		computersCategory.click();
	}
	public void navigateToElectronicsCategory() {
		electronicsCategory.click();
	}
	public void navigateToApparelCategory() {
		apparelCategory.click();
	}
	public void navigateToDigitalCategory() {
		digitalDownloadsCategory.click();
	}
	public void navigateToBooksCategory() {
		booksCategory.click();
	}
	public void navigateToClothingSubCategory() {
		
		Actions action = new Actions(driver);
		action.moveToElement(apparelCategory).perform();
		clothingSubCategory.click();
		
	}
	public void navigateToSubcategory(WebElement category, WebElement subcategory) {
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		subcategory.click();
	}
	
	
}