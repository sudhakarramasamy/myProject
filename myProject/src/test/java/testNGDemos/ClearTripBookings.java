package testNGDemos;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class ClearTripBookings {
				
			String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
			
			String baseURL = "https://www.cleartrip.com/";
	// WebDriver is an interface. driver = ref variable. Any object [chromeDriver] we assign to it must be instance of the class.
			public WebDriver driver; 
			
		@BeforeClass		
		public void openBrowser() throws Exception{
			
		System.setProperty("webdriver.chrome.driver", chromepath);
			
			driver = new ChromeDriver();
			
			driver.get(baseURL);
			
			Thread.sleep(3000);
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
		}
		
	
	  @AfterClass 
	  
	  public void closeBrowser() {
	  
		  driver.close();
	  
	  }
	 		
		@Test(priority = 0)
		public void selectFrom() {			
		
			WebElement from = driver.findElement(By.xpath("//input[@id='FromTag']"));
			
			from.clear();
					
			from.sendKeys("Bang");
			
			WebDriverWait waitFrom =new WebDriverWait(driver, 10);		
				
			waitFrom.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']//li/descendant::a[@tabindex='-1']")));
				
			List<WebElement> allElementsFrom = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li/descendant::a[@tabindex='-1']"));
			
			System.out.println("Total no of elements" +allElementsFrom.size());	
			
			for(int i = 0 ;i< allElementsFrom.size(); i++)
			
			{
			
			if(allElementsFrom.get(i).getText().equals("Bangalore, IN - Kempegowda International Airport (BLR)"))
			
			{
			allElementsFrom.get(i).click();
			
			break;
			} 
			}
			
			}
			
		@Test(priority = 1)	
			
		public void selectTo() throws Exception {
			
			WebElement to = driver.findElement(By.xpath("//input[@id='ToTag']"));
			
			to.clear();
					
			to.sendKeys("Chen");
			
					
			WebDriverWait waitTo =new WebDriverWait(driver, 10);		
				
			waitTo.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-2")));					
			
			List<WebElement> allElementsTo = driver.findElements(By.xpath("//ul[@id='ui-id-2']//li/descendant::a[@tabindex='-1']"));
			
			System.out.println("Total no of elements" +allElementsTo.size());	
			
			for(int j = 0 ;j< allElementsTo.size(); j++)
			
			{
			
			if(allElementsTo.get(j).getText().equals("Chennai, IN - Chennai Airport (MAA)"))
			
			{
			allElementsTo.get(j).click();
			
			break;
			}
			
			}
			
		}
		
		@Test(priority = 2)
		
		public void selectDate() {
		
			driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys("Fri, 15 Oct, 2019");
			
			driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys(Keys.ENTER);
			
		}
		
		@Test(priority = 3)
		
		public void adultSelect() {
			
			// Select is class here...
			
			Select adultSelect = new Select(driver.findElement(By.id("Adults")));
			
			adultSelect.selectByVisibleText("1");
			
		}
			
		@Test(priority = 4)
		
		public void childSelect() {
			
			Select childSelect = new Select(driver.findElement(By.id("Childrens")));
			
			childSelect.selectByVisibleText("1");
			
		}
		
		@Test(priority = 5)
		
		public void infantSelect() {
			
			Select infantSelect = new Select(driver.findElement(By.id("Infants")));
			
			infantSelect.selectByVisibleText("1");
			
		}
			
		@Test(priority = 6)
		
		public void searchSelect() throws Exception {
			
			driver.findElement(By.id("SearchBtn")).click();
			
		}
		
		@Test(priority = 7)
		
		public void seleccheapestFlight(){
		
			WebDriverWait searchWait = new WebDriverWait(driver,20);
		
		// Customized XPath
			
			searchWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='listView flights']//li[1]//table[1]//tbody[2]//tr[2]//td[3]//button[1]")));
					
			driver.findElement(By.xpath("//ul[@class='listView flights']//li[1]//table[1]//tbody[2]//tr[2]//td[3]//button[1]")).click();
			
		}
		
		@Test(priority = 8)
		
		public void iteneryCheck() {
			
			WebDriverWait iteneryButtonWait = new WebDriverWait(driver, 10);
			
			iteneryButtonWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#itineraryBtn")));
			
			driver.findElement(By.xpath("//input[@id='insurance_box']")).click();
			
			driver.findElement(By.xpath("//input[@id='insurance_confirm']")).click();
			
			driver.findElement(By.cssSelector("#itineraryBtn")).click();
			
		}
		
		@Test(priority = 9)
		
		public void emailAddress() {
			
			WebDriverWait emailAddressWait = new WebDriverWait(driver, 10);
			
			emailAddressWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#LoginContinueBtn_1")));
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sudhakar.a.ramasamy@gmail.com");
			
			driver.findElement(By.cssSelector("#LoginContinueBtn_1")).click();
			
		}
		
		@Test(priority = 10)
		
		public void adult1Details() {

			WebDriverWait travellDetailsWait = new WebDriverWait(driver, 10);
			
			travellDetailsWait.until(ExpectedConditions.elementToBeClickable(By.id("travellerBtn")));
			
			Select adultTitle1 = new Select(driver.findElement(By.id("AdultTitle1")));
			
			adultTitle1.selectByValue("Mr");
			
			driver.findElement(By.id("AdultFname1")).sendKeys("Sudhakar");
			
			driver.findElement(By.id("AdultLname1")).sendKeys("Ramasamy");
			
			Select AdultDobDay1 = new Select(driver.findElement(By.id("AdultDobDay1")));
			
			AdultDobDay1.selectByValue("1");
			
			Select AdultDobMonth1 = new Select(driver.findElement(By.id("AdultDobMonth1")));
			
			AdultDobMonth1.selectByValue("2");
			
			Select AdultDobYear1 = new Select(driver.findElement(By.id("AdultDobYear1")));
			
			AdultDobYear1.selectByValue("1990");
			
			
			WebElement adultNationality1 = driver.findElement(By.xpath("//div[@id='intADDAD1']//input[@placeholder='Nationality']"));
					
			adultNationality1.sendKeys("India");
			
			WebDriverWait waitadultNationality =new WebDriverWait(driver, 10);		
			
			waitadultNationality.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/ul[1]/li[1]/a[1]")));
			
			driver.findElement(By.xpath("/html[1]/body[1]/ul[1]/li[1]/a[1]")).click();	
			
			
		}
		
		@Test(priority = 11)
		
			public void child1Details() {
				
				Select ChildTitle1 = new Select(driver.findElement(By.id("ChildTitle1")));
				
				ChildTitle1.selectByValue("Miss");
				
				driver.findElement(By.id("ChildFname1")).sendKeys("Liya");
				
				driver.findElement(By.id("ChildLname1")).sendKeys("Nallamangai");
				
				Select ChildDobDay1 = new Select(driver.findElement(By.id("ChildDobDay1")));
				
				ChildDobDay1.selectByValue("1");
				
				Select ChildDobMonth1 = new Select(driver.findElement(By.id("ChildDobMonth1")));
				
				ChildDobMonth1.selectByValue("10");
				
				Select ChildDobYear1 = new Select(driver.findElement(By.id("ChildDobYear1")));
				
				ChildDobYear1.selectByValue("2016");
				
				WebElement childNationality1 = driver.findElement(By.xpath("//div[@id='intADDCD1']//input[@placeholder='Nationality']"));
				
				childNationality1.sendKeys("India");
				
				WebDriverWait waitchildNationality =new WebDriverWait(driver, 10);		
				
				waitchildNationality.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/ul[2]/li[1]/a[1]")));
				
				driver.findElement(By.xpath("/html[1]/body[1]/ul[2]/li[1]/a[1]")).click();			
				
			}
			
		@Test(priority = 12)
		
		public void infant1Details() {
			
			Select InfantTitle1 = new Select(driver.findElement(By.id("InfantTitle1")));
			
			InfantTitle1.selectByValue("Miss");
			
			driver.findElement(By.id("InfantFname1")).sendKeys("Aradhana");
			
			driver.findElement(By.id("InfantLname1")).sendKeys("Nallamangai");
			
			Select InfantDobDay1 = new Select(driver.findElement(By.id("InfantDobDay1")));
			
			InfantDobDay1.selectByValue("1");
			
			Select InfantDobMonth1 = new Select(driver.findElement(By.id("InfantDobMonth1")));
			
			InfantDobMonth1.selectByValue("10");
			
			Select InfantDobYear1 = new Select(driver.findElement(By.id("InfantDobYear1")));
			
			InfantDobYear1.selectByValue("2019");
			
			WebElement infantNationality1 = driver.findElement(By.xpath("//div[@id='intADDIN1']//input[@placeholder='Nationality']"));
			
			infantNationality1.sendKeys("India");
			
			WebDriverWait waitInfantNationality =new WebDriverWait(driver, 10);		
			
			waitInfantNationality.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/ul[3]/li[1]/a[1]")));
			
			driver.findElement(By.xpath("/html[1]/body[1]/ul[3]/li[1]/a[1]")).click();			
			
		}
		
		@Test(priority = 13) 
		
		public void mobileNumber() {
	
			driver.findElement(By.id("mobileNumber")).sendKeys("+917406414777");
			
			driver.findElement(By.id("travellerBtn")).click();;
			
		}
		
		@Test(priority = 14) 
		
		public void paymentPage() throws IOException {
	
			WebDriverWait payWebDriver = new WebDriverWait(driver, 15);
			
			payWebDriver.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("paymentSubmit"))));
			
			File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			// Have to import jar files to make it work...
			
			FileUtils.copyFile(screenShotFile, new File("C:\\Users\\sudhakar.a.ramasamy\\Documents\\Training\\screenshot.png"));
			
		}
	
	}
		
		
		
		
		
		
		
		
			
	
	
		 
		
		
		
	
	
