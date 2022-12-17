package testCases;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class DynamicTable extends Base {
	
	
	
	@Test
	public void dynamicTableTestCase() {
		openApplicationWithUrl("http://uitestingplayground.com/dynamictable");
		String chrome_cpu_table = driver.findElement(By.xpath("*//span[text()='Chrome']/following-sibling::span[contains(text(),'%')] ")).getText();
		String chrome_cpu_msg = driver.findElement(By.xpath("//p[@class=\"bg-warning\"]")).getText().replace("Chrome CPU: ","");
		Assert.assertEquals(chrome_cpu_table, chrome_cpu_msg);
		System.out.println(chrome_cpu_table);
		System.out.println(chrome_cpu_msg);
		driver.quit();
	
	}
	

}
