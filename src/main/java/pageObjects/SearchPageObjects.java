package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Base;
import testData.TestData;

public class SearchPageObjects extends Base {
	TestData td = new TestData();
	
	@FindBy(xpath = "//button[@class=\"button-1 search-box-button\"]")
		   WebElement searchBtn;
	@FindBy(xpath = "//input[@id=\"small-searchterms\"]")
		   WebElement searchField;
	@FindBy(xpath = "//input[@id=\"advs\"]")
	public WebElement advancedSearchRadioBtn;
	@FindBy(xpath = "//select[@id=\"cid\"]")
	public WebElement categoryAdvancedSrc;
	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")
	public WebElement advancedSearchBtn;
	@FindBy(xpath = "//select[@id=\"mid\"]")
		WebElement manufacturerAdvancedSrc;
	@FindBy(xpath = "//div[@class=\"no-result\"]")
	public	WebElement noResultMsg;
	
	
	
	
	public SearchPageObjects() {
	PageFactory.initElements(driver, this);
	}
	
	public void searchFunctionality(String searchword) {
		searchField.sendKeys(searchword);
		searchBtn.click();
	}
	public void verifySearchFunctionality(String actual, String expected) {
		Assert.assertEquals(actual, expected);

	}
	public void Select (WebElement category, String categoryvalues) {
		Select categoryMenu = new Select(category);
		categoryMenu.selectByValue(categoryvalues);	
	}
	public void manufacturerMenuAdvSearch(WebElement category, String categoryvalues) {
		Select manufacturerMenu = new Select(manufacturerAdvancedSrc);
		manufacturerAdvancedSrc.click();
		manufacturerMenu.selectByVisibleText(categoryvalues);
	}

	
}
