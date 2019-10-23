

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
	
		
		String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		String MainWindow = driver.getWindowHandle();
		
		System.out.println("MainWindow ID is" +MainWindow);
		
		Set<String> s1 = driver.getWindowHandles();
		
		for (String ch : s1) 	
		{
			String childWindow = ch;
		
		System.out.println("ChildWindows ID are " +childWindow);
		
		driver.switchTo().window(childWindow);
	}
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("sudhakar@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		driver.switchTo().window(MainWindow);
		
		driver.close();
		
}

}
