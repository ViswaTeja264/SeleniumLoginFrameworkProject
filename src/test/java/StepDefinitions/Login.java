package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Base{
	
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	
		@Given("^Open any Browser$")
	    public void open_any_browser() throws IOException {
	        
			driver = initializeBrowser();
			
	    }
		
		@And("^Navigate to Login page$")
	    public void navigate_to_login_page() throws InterruptedException {
			
			driver.get(prop.getProperty("URL"));
			landingPage = new LandingPage(driver);
			landingPage.MyAccountDropdown().click();
			landingPage.LoginOption().click();
			Thread.sleep(3000);
	        
	    }

	    @When("^User enters email as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String Password) {
	    	
	    	loginPage = new LoginPage(driver);
			loginPage.EmailId().sendKeys(email);
			loginPage.Password().sendKeys(Password);
	        
	    }
	    
	    @And("^User clicks on Login button$")
	    public void user_clicks_on_login_button() {
	    	
	    	loginPage.LoginButton().click();
	        
	    }

	    @Then("^Verify user is able to login based on Expected login credentials$")
	    public void verify_user_is_able_to_successfully_login() {
	    	
	    	AccountPage accountPage = new AccountPage(driver);
	    	
	    	Assert.assertTrue(accountPage.EditYourAccountInformation().isDisplayed());
			
	    }
	    
	    @After
	    public void closeBrowser() {
	    	
	    	driver.close();
	    	
	    }
	    
	}


