package testNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DepondsOnMethodsTest {
		
		public String baseUrl = "http://www.newtours.demoaut.com/mercuryregister.php";
	
		String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
		
		public WebDriver driver;
			
// This makes the tool to check whether the previous method was executed successfully. If not, the method will be skipped. Applicable only for @Test.
		
  @Test(dependsOnMethods={"validate_support"})
  public void validate_register()
  {
	  System.out.println("Validating the register page...");
	  
	  driver.findElement(By.linkText("REGISTER")).click();
	  
	  String actualTitle = driver.getCurrentUrl();
	  
	  String expectedTilte = "http://www.newtours.demoaut.com/mercuryregister.php";
	  
	  Assert.assertEquals(actualTitle, expectedTilte);
	  
	//  fail("Validation failed");
  }
  
  @Test(priority = 0)
  public void validate_support()
  {
	  System.out.println("Validating the support page...");
	  
	  driver.findElement(By.linkText("SUPPORT")).click();
	  
	  String actualTitle = driver.getCurrentUrl();
	  
	  String expectedTilte = "http://www.newtours.demoaut.com/mercuryunderconst.php";
	  
	  Assert.assertEquals(actualTitle, expectedTilte);
	  
	  // fail("Validation failed");
  }
 
  @Test(enabled = false)
  public void validate_contact()
  {
	  System.out.println("Validating the contct page...");
	  
	  driver.findElement(By.linkText("CONTACT")).click();
	  
	  String actualTitle = driver.getCurrentUrl();
	  
	  String expectedTilte = "http://www.newtours.demoaut.com/mercuryunderconst.php";
	  
	  Assert.assertEquals(actualTitle, expectedTilte);
	  
	// fail("Validation failed");
  }
  
  @Test(enabled = false)
  public void validate_signOn()
  {
	  System.out.println("Validating the SignOn page...");
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
	  
	  String actualTitle = driver.getCurrentUrl();
	  
	  String expectedTilte = "http://www.newtours.demoaut.com/mercurysignon.php";
	  
	  Assert.assertEquals(actualTitle, expectedTilte);
	  
	   // fail("Validation failed");
  }
  
  @BeforeClass 
  public void openBrowser()
  {
	  System.out.println("***Opening the browser");
	  
	  System.setProperty("webdriver.chrome.driver", chromepath);
		
		driver = new ChromeDriver();
		
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
  }
  
  @AfterClass
  public void closeBrowser()
  {
	  System.out.println("***Closing the browser");
	  
	  driver.close();
  }
  
  @BeforeMethod
  public void home()
  {
	  System.out.println("Navigating to home page...");
	  
	  driver.findElement(By.linkText("Home")).click();
	  
  }
  
  @AfterMethod
  public void message()
  {
	  System.out.println("### validation completed ###");
  }
  
  
}


