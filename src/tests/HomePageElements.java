package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageElements {
	
WebDriver driver;
	
	@FindBy(linkText="Sign In")
	WebElement signIn;
	
	@FindBy(linkText="My Tasks")
	WebElement myTasksLink;
	
	@FindBy(linkText="Sign Out")
	WebElement signOut;
	
/*	@FindBy(id="tab-flight-tab-hp")
	WebElement fligthsTab;
	
	@FindBy(id="flight-origin")
	WebElement originCity;
	
	@FindBy(id="flight-destination")
	WebElement destinationCity;
	
	@FindBy(id="flight-departing")
	WebElement departureDate;
	
	@FindBy(id="flight-returning")
	WebElement returnDate;
	*/
	public HomePageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public void checkForMyTasksLink() {	
		if(myTasksLink.isDisplayed())
		{
		System.out.println("My Tasks link present");
		}
		else
		{
		System.out.println("My Tasks link is not present");
		}	
	}
	
	public void clickMyTasksLink() {
		myTasksLink.click();
	}
	
	public void verifyMyTasksPageload(){
		String expectedUrl = "http://qa-test.avenuecode.com/tasks";
		driver.get(expectedUrl);
		try{
		  Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
		  System.out.println("Navigated to correct webpage");
		}
		catch(Throwable pageNavigationError){
		  System.out.println("Didn't navigate to correct webpage");
		}
	}
	
	public void clickSignOut() {
		signOut.click();
	}
	
	public void verifyDisplayMessage(){
		String bodyText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Hey Aleena Davy, this is your todo list for today:", bodyText);		
	}
/*	public void setOriginCity(String origin) {
		originCity.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination) {
		destinationCity.sendKeys(destination);  
	}   */

}
