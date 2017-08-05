package stepdefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.HomePageElements;
import tests.SigninPageElements;
import tests.TaskPageElements;
import tests.SubTaskPageElements;

public class SubtaskTeststeps {
	static WebDriver driver;
	HomePageElements homePage;
	SigninPageElements signIn;
	TaskPageElements taskPage;
	SubTaskPageElements subtaskPage;
		
	@Given("^I am on the MyTasks page$")
	public void I_am_on_the_MyTasks_page() {
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
		
		homePage.clickMyTasksLink();
	}
	
	@Then("^I should be able to see Manage SubTasks button$")
	public void I_should_be_able_to_see_Manage_SubTasks_button() {
		taskPage = new TaskPageElements(driver);
		taskPage.subTaskMessage();
	}
	
	@When("^I click on the button$")
	public void I_click_on_the_button() {
		taskPage.clickSubTaskButton();
	}
	
	@Then("^I should see a subtask modal dialog box$")
	public void I_should_see_a_subtask_modal_dialog_box() {
		 subtaskPage = new SubTaskPageElements(driver);
		 subtaskPage.verifySubTaskPageLoads();
	}
	
	@Given("^I am on MyTasks page$")
	public void I_am_on_MyTasks_page() {
		  I_am_on_the_MyTasks_page(); 
	}
	
	@Then("^I should see Manage SubTasks button$")
	public void I_should_see_Manage_SubTasks_button() {
		taskPage = new TaskPageElements(driver);
		taskPage.subTaskMessage();
	}
	
	@Then("^I should see updated no of subtasks when I add/delete a subtask$")
	public void I_should_see_the_no_of_subtasks_on_the_button() {
		subtaskPage = new SubTaskPageElements(driver);	
		taskPage.enterTask("Test sub task");
		taskPage.clickSubTaskButton();
		subtaskPage.enterSubtaskDesc("subtask1");
		subtaskPage.clickcloseButton();
		subtaskPage.verifySubTaskContainsNumber1();  
		
		//when you add/delete a subtask the number should be correct
		taskPage.clickSubTaskButton();
		subtaskPage.enterSubtaskDesc("subtask2");
		subtaskPage.clickcloseButton();
		subtaskPage.verifySubTaskContainsNumber2();
	}    
	
}

