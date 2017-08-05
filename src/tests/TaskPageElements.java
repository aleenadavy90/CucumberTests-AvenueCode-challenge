package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TaskPageElements {
	
WebDriver driver;

 @FindBy(id="new_task")
	WebElement taskField;
 
 @FindBy(xpath="//input[@ng-model='$data']")
	WebElement editTaskField;
 
 @FindBy(xpath="//span[@ng-click='addTask()']")
    WebElement addButton;
 
 @FindBy(xpath="//*[contains(text(), 'Manage Subtasks')]")
	WebElement editSubTaskButton;
	
	public TaskPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDisplayMessage(){
		String bodyText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("Hey Aleena Davy, this is your todo list for today:", bodyText);		
	}
  
	public void verifyMaximumChar() {
		String myLongChar = "gschbdjfshzdghsdgdhdjkzhsjcjhsdkvjsvkvkkdhcguydgkaugkasguwygwauygduwdjbejhfrufhbcsjdbcjhdsbjcdhsjgchjsdgcueuywgeuwbhesbckshbdhcudghjchjgyuegweiuwoedbxnxwewgvwhvvbnnssnsnnsnsnsbccxcjdhjdgejdgejggegggdhgedgeegdgdgegeyegdyegdegegeeywywwyeyeyhelloawesomeehyuegweiuwoedbxnxwewgvwhvvbnnssnsnnsnsnsbccxcjdhjdgejdgejggegggdhgedgeegdgdgegeyegdyegdegegeeywywwyeyeyhelloawesomeenhbmnmnmnawesomeetest";
		int longCharLength = myLongChar.length();
		taskField.sendKeys(myLongChar);
		taskField.sendKeys(Keys.RETURN);
		
		WebElement charCount = driver.findElement(By.xpath("//*[contains(text(), 'gschbdjfshzdghsdgdhdjkzhsjcjhsdkvjsvkvkkdhcguydgkaugkasguwygwauygduwdjbejhfrufhbcsjdbcjhdsbjcdhsjgchjsdgcueuywgeuwbhesbckshbdhcudghjchjgyuegweiuwoedbxnxwewgvwhvvbnnssnsnnsnsnsbccxcjdhjdgejdgejggegggdhgedgeegdgdgegeyegdyegdegegeeywywwyeyeyhelloawesomeehyu')]"));
		charCount.click();
		editTaskField.click();
		int realLength = editTaskField.getAttribute("value").length();
		Assert.assertEquals(longCharLength, realLength);  
	}
	
	public void verifyRealCharLength() {
		int realLength = editTaskField.getAttribute("value").length();
		if(realLength > 250 ){
			System.out.println("User able to enter Tasks with more than 250 characters");
		}
	}
	
	public void enterTask(String taskname){
		taskField.sendKeys(taskname);
		taskField.sendKeys(Keys.RETURN);
	}
	
	public void clickAddButtonTask(String taskname){
		taskField.sendKeys(taskname);
		addButton.click();
	}
	
	public boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
	  }
    public void subTaskMessage() {
    		String buttonText = editSubTaskButton.getText();
    		if((buttonText.contains("Manage SubTask")))
    		{
    		System.out.println("Manage SubTasks button visible");
    		}		
    	}
    
    public void clickSubTaskButton(){
    	editSubTaskButton.click();
    }
   }

