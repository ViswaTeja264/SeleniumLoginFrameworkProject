package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[title='My Account']")
	private WebElement MyAccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	public WebElement MyAccountDropdown() {
		
		return MyAccountDropdown;
		
	}
	
	public WebElement LoginOption() {
		
		return LoginOption;
		
	}

}
