package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement EmailId;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	public WebElement EmailId() {

		return EmailId;
		
	}
	
	public WebElement Password() {
		
		return Password;
		
	}
	
	public WebElement LoginButton() {
		
		return LoginButton;
		
	}

}
