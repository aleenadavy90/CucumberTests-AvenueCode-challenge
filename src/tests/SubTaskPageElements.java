package tests;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SubTaskPageElements {
	
WebDriver driver;

   @FindBy(xpath="//*[contains(text(), 'Create a SubTask')]")
   WebElement editSubTaskButton;
   
   @FindBy(id="new_sub_task")
	WebElement subtaskdescriptionField;
   
   @FindBy(id="add-subtask")
	WebElement addsubtask;
   
   @FindBy(xpath="//*[contains(text(), 'Close')]")
   WebElement closeButton;
   
   @FindBy(xpath="//*[contains(text(), 'Manage Subtasks')]")
  	WebElement editSubTask;
   
	public SubTaskPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifySubTaskPageLoads(){
		String subTasksload = editSubTaskButton.getText();
		Assert.assertEquals("Create a SubTask", subTasksload);		
	}
   
	public void enterSubtaskDesc(String desc)
	{
		subtaskdescriptionField.sendKeys(desc);
		subtaskdescriptionField.sendKeys(Keys.RETURN);
	}
	
	
	public void clickcloseButton()
	{
		closeButton.click();;
	}
	
	public void verifySubTaskContainsNumber1() {
		String buttonText = editSubTask.getText();
		if((buttonText.contains("(1)")))
		{
		System.out.println("I can see the no 1 on the button");
		}		
	}
	
	public void verifySubTaskContainsNumber2() {
		String buttonText = editSubTask.getText();
		if((buttonText.contains("(2)")))
		{
		System.out.println("I can see the no 2 on the button");
		}		
	}
   }


