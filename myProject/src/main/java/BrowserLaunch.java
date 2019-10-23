import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class BrowserLaunch {
	
	public static void main(String args[]) throws InterruptedException {
		
		String iePath = "C:\\Users\\sudhakar.a.ramasamy\\Documents\\Learning Selenium\\chromedriver.exe";
		
		/* 
		 * 
		> In selenium, you use this method because the browser doesn't have a built-in server to run the automation code so you will need 
		
		a Chrome/IE/Gecko(according to requirement) driver server for communicating your Selenium code to the browser.
		
		> ChromeDriver is a separate executable that Selenium WebDriver uses to control Chrome. It is maintained by the Chromium team with help from WebDriver contributors.
		
		
		*/
	 System.setProperty("webdriver.chrome.driver", iePath);
				
		WebDriver driver = new ChromeDriver();
				
		driver.get("http://www.newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Sudhakar");
		
		driver.findElement(By.name("lastName")).sendKeys("Ramasamy");
		
		driver.findElement(By.name("phone")).sendKeys("74064114777");
		
		driver.findElement(By.name("userName")).sendKeys("sudhakar.a.ramasamy@yahoo.com");
		
		// To select an option from the drop down. We use select class and create reference in order to communicate with the values.
		
		Select select = new Select(driver.findElement(By.name("country")));
				
		select.selectByVisibleText("ALBANIA");

				
		driver.findElement(By.id("email")).sendKeys("sudhakar03");
		
		driver.findElement(By.name("password")).sendKeys("123");
		
		driver.findElement(By.name("confirmPassword")).sendKeys("123");;
		
		driver.findElement(By.name("register")).click();	
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		String urlString = driver.getCurrentUrl();
		
		if(urlString.isEmpty())
			
			System.out.println("URL not received...");
		
		else		
		
		System.out.println(urlString);
		
		
	/*	WebElement uName = driver.findElement(By.name("UserName");
		
		uName.sendKeys("Sudhakar02");
		
		uName.clear();
		
	*/
	}

}
