package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.HomePageElements;
import tests.SigninPageElements;
import tests.TaskPageElements;

public class TestingSteps {
	static WebDriver driver;
	HomePageElements homePage;
	SigninPageElements signIn;
	TaskPageElements taskPage;
	
	
	@Given("^User is signed in to the homepage$")
	public void User_is_signed_in_to_the_homepage() {
		System.setProperty("webdriver.gecko.driver","/Users/aleenadavy/Documents/workspace/geckodriver");
		driver = new FirefoxDriver();
		String baseURL = "http://qa-test.avenuecode.com/";
		// driver.manage().window().maximize();
		homePage = new HomePageElements(driver);
		signIn = new SigninPageElements(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
		
		homePage.clickSignIn();
		signIn.enterEmail("aleenadavy90@gmail.com");
		signIn.enterPassword("alpha777");
		signIn.clickSignInButton();
		
	}

	@Then("^I can see the My Tasks link on NavBar$")
	public void I_can_see_the_My_Tasks_link_on_NavBar(){
		homePage.checkForMyTasksLink();
	}
	
	@Then("^I can click on My Tasks link$")
	public void I_can_click_on_My_Tasks_link(){
		homePage.clickMyTasksLink();
	}
	
	@Then("^I am navigated to Tasks page$")
	public void I_am_navigated_to_Tasks_page(){
		homePage.verifyMyTasksPageload();
		driver.close();
	}
	
	@Given("^User is not signed in to the homepage$")
	public void User_is_not_signed_in_to_the_homepage$() {
		System.setProperty("webdriver.gecko.driver","/Users/aleenadavy/Documents/workspace/geckodriver");
		driver = new FirefoxDriver();
		String baseURL = "http://qa-test.avenuecode.com/";
		homePage = new HomePageElements(driver);
		signIn = new SigninPageElements(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(baseURL);
	}
	
	@Then("^I can still see the My Tasks link on NavBar$")
	public void I_can_still_see_the_My_Tasks_link_on_NavBar(){
		homePage.checkForMyTasksLink();
	}
	
	@Then("^I am able to click on My Tasks link$")
	public void I_am_able_to_click_on_My_Tasks_link(){
		homePage.clickMyTasksLink();
	}
	
	@Then("^I am navigated to Sign in page$")
	public void I_am_navigated_to_Sign_in_page(){
		signIn.verifySignInPageload();
		driver.close();
	}

	@Given("^User is signed in with valid credntials$")
	public void User_is_signed_in_with_valid_credntials$() {
		User_is_signed_in_to_the_homepage();
		homePage.clickMyTasksLink();	
	}
	
	@When("^User is on the Tasks page$")
	public void User_is_on_the_Tasks_page(){
		homePage.verifyMyTasksPageload();
		//driver.close();
	}
	
	@Then("^I should see the correct message$")
	public void I_should_see_the_correct_message(){
		taskPage = new TaskPageElements(driver);
		taskPage.verifyDisplayMessage();
	}

	@Given("^User is signed with valid credentials$")
	public void User_is_signed_with_valid_credentials$() {
		User_is_signed_in_to_the_homepage();
		homePage.clickMyTasksLink();	
	}
	
	@Then("^I add a task with more than twofifty characters$")
	public void I_add_a_task_with_more_than_twofifty_characters() {
		taskPage = new TaskPageElements(driver);
		taskPage.verifyMaximumChar();
	}

	@Then("^The task should not be more than twofifty characters$")
	public void The_task_should_not_be_more_than_twofifty_characters() {
    taskPage = new TaskPageElements(driver);
    taskPage.verifyRealCharLength();	
	}
}
