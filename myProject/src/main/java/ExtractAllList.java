import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtractAllList {
	
public static void main(String args[]) throws InterruptedException {
		
		String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/v4/");
		
		driver.manage().window().maximize();
		
		driver.getCurrentUrl();
		
		
		
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links " + linkList.size());
		
		for (WebElement links : linkList)
			
			System.out.println(links.getText() + " "  + links.getAttribute("href"));
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
		driver.close();


}

}
