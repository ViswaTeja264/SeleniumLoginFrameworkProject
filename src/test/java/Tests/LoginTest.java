package Tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	
	@BeforeMethod
	public void OpenApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getClass());
		
		driver = initializeBrowser();
		log.debug("Browser Got Launched");
		driver.get(prop.getProperty("URL"));
		log.debug("Navigated To Application URL");
		
	}
	
	@Test(dataProvider="AccountLoginData")
	public void login(String Email, String Password, String ExpectedResult) throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.MyAccountDropdown().click();
		log.debug("Clicked On MyAccount Dropdown");
		landingPage.LoginOption().click();
		log.debug("Clicked On Login Option");
		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.EmailId().sendKeys(Email);
		log.debug("Email Address Got Entered");
		loginPage.Password().sendKeys(Password);
		log.debug("Password Got Entered");
		loginPage.LoginButton().click();
		log.debug("Clicked On Login Button");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String ActualResult;
		
		try {
			
			accountPage.EditYourAccountInformation().isDisplayed();
			ActualResult = "Successful";
			log.debug("User Got Logged In");
			
		}catch(Exception e) {
			
			ActualResult = "Failure";
			log.debug("User Doesn't Logged In");
			
		}
		
		Assert.assertEquals(ActualResult, ExpectedResult);
		log.info("Login Test Got Passed");
		
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] AccountLoginData() {
		
		Object[][] data = {{"viswateja209@gmail.com","@Viswa264","Successful"},{"Dummy@gmail.com","Dummy","Failure"}};
		
		return data;
		
	}
	
	@AfterMethod
	public void closure() {
		
		driver.close();
		log.debug("Browser Got Closed");
		
	}

}

