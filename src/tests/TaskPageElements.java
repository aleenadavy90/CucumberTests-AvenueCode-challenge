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
 
// @FindBy(xpath="//*[contains(text(), 'gschbdjfshzdghsdgdhdjkzhsjcjhsdkvjsvkvkkdhcguydgkaugkasguwygwauygduwdjbejhfrufhbcsjdbcjhdsbjcdhsjgchjsdgcueuywgeuwbhesbckshbdhcudghjchjgyuegweiuwoedbxnxwewgvwhvvbnnssnsnnsnsnsbccxcjdhjdgejdgejggegggdhgedgeegdgdgegeyegdyegdegegeeywywwyeyeyhelloawesomeehyu')]");
//	WebElement charCount;
	
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

	//	WebElement elem = driver.findElement(By.id("new_task"));
		taskField.sendKeys(myLongChar);
		taskField.sendKeys(Keys.RETURN);
		
		WebElement charCount = driver.findElement(By.xpath("//*[contains(text(), 'gschbdjfshzdghsdgdhdjkzhsjcjhsdkvjsvkvkkdhcguydgkaugkasguwygwauygduwdjbejhfrufhbcsjdbcjhdsbjcdhsjgchjsdgcueuywgeuwbhesbckshbdhcudghjchjgyuegweiuwoedbxnxwewgvwhvvbnnssnsnnsnsnsbccxcjdhjdgejdgejggegggdhgedgeegdgdgegeyegdyegdegegeeywywwyeyeyhelloawesomeehyu')]"));
		charCount.click();
	//	WebElement test2 = driver.findElement(By.xpath("//input[@ng-model='$data']"));

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
}

