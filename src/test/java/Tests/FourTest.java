package Tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class FourTest extends Base{
	
	public WebDriver driver;
	
	@Test
	public void TestFour() throws IOException {
		
		System.out.println("TestFour");
		
		driver = initializeBrowser();
		
		driver.get("http://tutorialsninja.com/demo/");
		
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void CloseBrowser() {
		
		driver.close();
	}

}
