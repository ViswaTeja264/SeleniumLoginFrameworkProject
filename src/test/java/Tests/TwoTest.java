package Tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Resources.Base;

public class TwoTest extends Base{
	
	WebDriver driver;
	
	@Test
	public void TestTwo() throws IOException {
		
		System.out.println("TestTwo");
		
		driver = initializeBrowser();
		
		driver.get("http://tutorialsninja.com/demo/");
		
		//Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void CloseBrowser() {
		
		driver.close();
	}
	
}
	
	


