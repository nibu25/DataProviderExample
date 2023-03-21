package ExampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	@Test (dataProvider = "provideLogInData")  
	public void logIn (String username, String password) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);    
	  driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);    
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  System.out.println(driver.getTitle());
	    
	}
	@DataProvider (name = "provideLogInData")
	public Object [] [] logInData ()
	{
	  Object [] [] data = new Object [3] [2];
	  
	  data [0] [0] = "SignUpForFree@InvalidEmail.com";    data [0] [1] = "Password_ABC";  
	  
	  data [1] [0] = "Rex.Jones@Test4Success.org";      data [1] [1] = "UseMyValidPassword";
	  
	  data [2] [0] = "Admin";                           data [2] [1] = "admin13";  
	  
	  return data;
	}
}
