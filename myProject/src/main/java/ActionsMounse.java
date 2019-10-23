import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMounse {

	public static void main(String[] args) throws InterruptedException {
		

		String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
		
		// TODO Auto-generated method stubString chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]"))).perform();
		
		actions.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Desktops')]"))).click().build().perform();
		
		driver.close();

	}

}
