package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider1 {

	@Test(dataProvider = "dp")
			
		public void registerUser(String User, String pwd, String confpwd) throws InterruptedException {
			
			String iePath = "C:\\Users\\sudhakar.a.ramasamy\\Documents\\Learning Selenium\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", iePath);
				
			WebDriver driver = new ChromeDriver();
				
			driver.get("http://www.newtours.demoaut.com/");
				
			driver.manage().window().maximize();
			
			driver.findElement(By.linkText("REGISTER")).click();
				
			driver.findElement(By.id("email")).sendKeys(User);
			
			driver.findElement(By.name("password")).sendKeys(pwd);
			
			driver.findElement(By.name("confirmPassword")).sendKeys(confpwd);;
			
			driver.findElement(By.name("register")).click();	
			
			Thread.sleep(3000);
			
			driver.close();
	}
	

// Data Provider

	@DataProvider
  public Object[][] dp() {
  return new Object[][] {
      new Object[] { "bmc", "bmc123", "bmc123" },
      new Object[] { "abc", "abc123", "abc123" },
      new Object[] { "qwe", "qwe123", "qwe123" },
	    };
	  }
	
}