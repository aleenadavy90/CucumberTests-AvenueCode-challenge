package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPageElements {
	
WebDriver driver;
	
	@FindBy(id="user_email")
	WebElement userEmail;
	
	@FindBy(id="user_password")
	WebElement userPassword;
	
	@FindBy(xpath="//input[contains(@class,'btn-primary')]")
	WebElement signInButton;
	
	public SigninPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		userEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		userPassword.sendKeys(password);
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void verifySignInPageload(){
		String expectedUrl = "http://qa-test.avenuecode.com/users/sign_in";
		driver.get(expectedUrl);
		try{
		  Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
		  System.out.println("Navigated to correct webpage");
		}
		catch(Throwable pageNavigationError){
		  System.out.println("Didn't navigate to correct webpage");
		}
	}

}
