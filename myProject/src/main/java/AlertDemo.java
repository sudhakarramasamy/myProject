

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String args[]) throws InterruptedException {
		
		String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/v4/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("uid")).sendKeys("Sudhakar");
		
		driver.findElement(By.name("password")).sendKeys("1234");
		
		driver.findElement(By.name("btnLogin")).click();
		
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		String alertMessage = alert.getText();
		
		System.out.println(alertMessage);
		
		alert.accept();
		
	}
	
}
