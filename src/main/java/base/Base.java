package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

		public static WebDriver driver;
		public String homeURL = "https://demo.nopcommerce.com/";
		
		
		
		public void openApplication() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(homeURL);
			driver.manage().window().maximize();
			
		}
		public void openApplication1() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");
			driver.manage().window().maximize();
		}
		public void openApplication2() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
			driver.manage().window().maximize();
			
		}
		public void openApplication3() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
			driver.manage().window().maximize();
			
		}
		public void openApplication4() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://uitestingplayground.com/ajax");
			driver.manage().window().maximize();
		}
		public void openApplicationWithUrl(String typeUrl) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(typeUrl);
			driver.manage().window().maximize();
		}
}

