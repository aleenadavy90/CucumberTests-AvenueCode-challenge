package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.HomePageElements;
import tests.SigninPageElements;
import tests.TaskPageElements;

public class MytaskTestingSteps {
	static WebDriver driver;
    HomePageElements homePage;
	SigninPageElements signIn;
	TaskPageElements taskPage;
		
	@Given("^I am signed in as a user$")
	public void I_am_signed_in_as_a_user() {
		System.setProperty("webdriver.gecko.driver","/Users/aleenadavy/Documents/workspace/geckodriver");
		driver = new FirefoxDriver();
		String baseURL = "http://qa-test.avenuecode.com/";
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
	
	@Given("^I am not signed in as a user$")
	public void I_am_not_signed_in_as_a_user$() {
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

	@Given("^I am signed in as a valid user$")
	public void I_am_signed_in_as_a_valid_user() {
		I_am_signed_in_as_a_user();
		homePage.clickMyTasksLink();	
	}
	
	@When("^I am on the Tasks page$")
	public void I_am_on_the_Tasks_page(){
		homePage.verifyMyTasksPageload();
	}
	
	@Then("^I should see the correct message$")
	public void I_should_see_the_correct_message(){
		taskPage = new TaskPageElements(driver);
		taskPage.verifyDisplayMessage();
		driver.close();
	}

	@Given("^I am signed in as a user with valid credentials$")
	public void I_am_signed_in_as_a_user_with_valid_credentials() {
		I_am_signed_in_as_a_user();
		homePage.clickMyTasksLink();	
	}
	
	@Then("^I add a task with more than twofifty characters$")
	public void I_add_a_task_with_more_than_twofifty_characters() {
		taskPage = new TaskPageElements(driver);
		taskPage.verifyMaximumChar();
	}

	@Then("^The added task should not be more than twofifty characters$")
	public void The_added_task_should_not_be_more_than_twofifty_characters() {
    taskPage = new TaskPageElements(driver);
    taskPage.verifyRealCharLength();
    driver.close();
	}
	
	@Given("^I am on the My Tasks page$")
	public void I_am_on_the_My_Tasks_page() {
		I_am_signed_in_as_a_user_with_valid_credentials();				
	}
	
	@When("^I hit enter on a valid task$")
	public void I_hit_enter_on_a_valid_task() {
		taskPage = new TaskPageElements(driver);
		taskPage.enterTask("finish assesment by tuesday");
	}
	
	@When("^I click on the add button$")
	public void I_click_on_the_add_button() {
	   taskPage.clickAddButtonTask("do laundry");	
	}
	
	@Then("^The task should be entered$")
	public void The_task_should_be_entered() {
		String text = "finish assesment by tuesday";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
	}
	
	@Then("^I should not be able to enter an empty task$")
	public void I_should_not_be_able_to_enter_an_empty_task() {
		taskPage.clickAddButtonTask("");	
	    Assert.assertTrue(taskPage.isTextPresent("Please fill out this field"));
		   
	}
}
