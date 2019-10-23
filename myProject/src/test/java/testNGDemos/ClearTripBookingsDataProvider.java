package testNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class ClearTripBookingsDataProvider {
				
			String chromepath = "C:\\\\Users\\\\sudhakar.a.ramasamy\\\\Documents\\\\Learning Selenium\\\\chromedriver.exe";
			
			String baseURL = "https://www.cleartrip.com/";
	// WebDriver is an interface. driver = ref variable. Any object [chromeDriver] we assign to it must be instance of the class.
				public WebDriver driver; 
			
				public static XSSFWorkbook workbook;
			
			 	public static String fromValue;
			 	public static String fromEqualsValue;			
			 	public static String toValue;
			 	public static String toEqualsValue;
			 	public static String selectDataValue;
			 	public static String emailAdressValue;		 
				public static String adultTitle1Value;			
				public static String adultFname1Value;				
				public static String adultLname1Value;				
				public static String adultDobDay1Value;				
				public static String AdultDobMonth1Value;				
				public static String adultDobYear1Value;				
				public static String adultNationality1Value;
				public static String ChildTitle1Value;				
				public static String ChildFname1Value;
				public static String ChildLname1Value;
				public static String ChildDobDay1Value;
				public static String ChildDobMonth1Value;
				public static String ChildDobYear1Value;
				public static String childNationality1Value;
				public static String InfantTitle1Value;
				public static String InfantFname1Value;
				public static String InfantLname1Value;
				public static String InfantDobDay1Value;				
				public static String InfantDobMonth1Value;				
				public static String InfantDobYear1Value;			
				public static String infantNationality1Value;
				public static String mobileNumberValue;	
						
			
		@BeforeSuite		
		public void openBrowser() throws Exception{
			
		System.setProperty("webdriver.chrome.driver", chromepath);
			
			driver = new ChromeDriver();
			
			driver.get(baseURL);
			
			Thread.sleep(3000);
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
		}
		
	
	  @AfterSuite
	  
	  public void closeBrowser() {
	  
		  driver.close();
	  
	  }
	  
	  
	  @BeforeTest
	  public static void excel() throws IOException{
		  
		  String filePath = "C:\\Users\\sudhakar.a.ramasamy\\eclipse-workspace\\myProject\\src\\test\\java\\com\\testData\\testData.xlsx";
		  
		  FileInputStream excelFileInput = new FileInputStream(filePath);
		  
		  workbook = new XSSFWorkbook(excelFileInput);
		  
		  XSSFSheet sheet = (XSSFSheet)workbook.getSheetAt(0);
		  
		  int rowCount = sheet.getLastRowNum();
		  
		  int colCount = sheet.getRow(1).getLastCellNum();
		  
		  for(int i = 1; i <= rowCount; i++  )
		  
		  {
			  
			  String data[] = new String[colCount];
	
			  for(int j = 0; j < colCount; j++)
				  
			  {
				  
				  XSSFCell cell = (XSSFCell) sheet.getRow(i).getCell(j);
				  
				
				   if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					   
					   data[j] = cell.getRawValue();
					   
				  
				 } else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				 
				 	{ 
					 
					 data[j] = cell.getStringCellValue();
					
				 	}
			  
				ClearTripDataPOJO.setFrom(data[0]);
				ClearTripDataPOJO.setFromEquals(data[1]);
				ClearTripDataPOJO.setTo(data[2]);
				ClearTripDataPOJO.setToEquals(data[3]);
				ClearTripDataPOJO.setSelectDate(data[4]);
				ClearTripDataPOJO.setEmail(data[5]);
				ClearTripDataPOJO.setAdultTitle1(data[6]);
				ClearTripDataPOJO.setAdultFname1(data[7]);
				ClearTripDataPOJO.setAdultLname1(data[8]);
				ClearTripDataPOJO.setAdultDobDay1(data[9]);
				ClearTripDataPOJO.setAdultDobMonth1(data[10]);
				ClearTripDataPOJO.setAdultDobYear1(data[11]);
				ClearTripDataPOJO.setAdultNationality1(data[12]);
				ClearTripDataPOJO.setChildTitle1(data[13]);
				ClearTripDataPOJO.setChildFname1(data[14]);
				ClearTripDataPOJO.setChildLname1(data[15]);
				ClearTripDataPOJO.setChildDobDay1(data[16]);
				ClearTripDataPOJO.setChildDobMonth1(data[17]);
				ClearTripDataPOJO.setChildDobYear1(data[18]);
				ClearTripDataPOJO.setChildNationality1(data[19]);
				ClearTripDataPOJO.setInfantTitle1(data[20]);
				ClearTripDataPOJO.setInfantFname1(data[21]);
				ClearTripDataPOJO.setInfantLname1(data[22]);
				ClearTripDataPOJO.setInfantDobDay1(data[23]);
				ClearTripDataPOJO.setInfantDobMonth1(data[24]);
				ClearTripDataPOJO.setInfantDobYear1(data[25]);
				ClearTripDataPOJO.setInfantNationality1(data[26]);
				ClearTripDataPOJO.setMobileNumber(data[27]);
			  
		  }
			
			  fromValue = ClearTripDataPOJO.getFrom();
			  fromEqualsValue = ClearTripDataPOJO.getFromEquals();				
			  toValue = ClearTripDataPOJO.getTo();
			  toEqualsValue = ClearTripDataPOJO.getToEquals();
			  selectDataValue = ClearTripDataPOJO.getSelectDate();
			  emailAdressValue = ClearTripDataPOJO.getEmail();
			  adultTitle1Value = ClearTripDataPOJO.getAdultTitle1();
			  adultFname1Value = ClearTripDataPOJO.getAdultFname1();
			  adultLname1Value = ClearTripDataPOJO.getAdultLname1();
			  adultDobDay1Value = ClearTripDataPOJO.getAdultDobDay1();
			  AdultDobMonth1Value = ClearTripDataPOJO.getAdultDobMonth1();				
			  adultDobYear1Value = ClearTripDataPOJO.getAdultDobYear1();				
			  adultNationality1Value = ClearTripDataPOJO.getAdultNationality1();
			  ChildTitle1Value = ClearTripDataPOJO.getChildTitle1();				
			  ChildFname1Value = ClearTripDataPOJO.getChildFname1();				
			  ChildLname1Value = ClearTripDataPOJO.getChildLname1();				
			  ChildDobDay1Value = ClearTripDataPOJO.getChildDobDay1();				
			  ChildDobMonth1Value = ClearTripDataPOJO.getChildDobMonth1();				
			  ChildDobYear1Value = ClearTripDataPOJO.getChildDobYear1();				
			  childNationality1Value = ClearTripDataPOJO.getChildNationality1();
			  InfantTitle1Value = ClearTripDataPOJO.getInfantTitle1();
			  InfantFname1Value = ClearTripDataPOJO.getInfantFname1();				
			  InfantLname1Value = ClearTripDataPOJO.getInfantLname1();				
			  InfantDobDay1Value = ClearTripDataPOJO.getInfantDobDay1();				
			  InfantDobMonth1Value = ClearTripDataPOJO.getInfantDobMonth1();				
			  InfantDobYear1Value = ClearTripDataPOJO.getInfantDobYear1();			
			  infantNationality1Value = ClearTripDataPOJO.getInfantNationality1();
			  mobileNumberValue = ClearTripDataPOJO.getMobileNumber();	
		  }
		  
	  }	  
	   	
	 		
		@Test(priority = 0)
		public void selectFrom() {			
		
			WebElement from = driver.findElement(By.xpath("//input[@id='FromTag']"));
			
			from.clear();
					
			from.sendKeys(fromValue);
			
			WebDriverWait waitFrom = new WebDriverWait(driver, 10);		
				
			waitFrom.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']//li/descendant::a[@tabindex='-1']")));
				
			List<WebElement> allElementsFrom = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li/descendant::a[@tabindex='-1']"));
			
			System.out.println("Total no of elements" +allElementsFrom.size());	
			
			for(int i = 0 ;i< allElementsFrom.size(); i++)
			
			{
			
			if(allElementsFrom.get(i).getText().equals(fromEqualsValue))
			
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
			
			to.sendKeys(toValue);
					
			WebDriverWait waitTo =new WebDriverWait(driver, 10);		
				
			waitTo.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-2")));					
			
			List<WebElement> allElementsTo = driver.findElements(By.xpath("//ul[@id='ui-id-2']//li/descendant::a[@tabindex='-1']"));
			
			System.out.println("Total no of elements" +allElementsTo.size());	
			
			for(int j = 0 ;j< allElementsTo.size(); j++)
			
			{
			
			if(allElementsTo.get(j).getText().equals(toEqualsValue))
			
			{
			allElementsTo.get(j).click();
			
			break;
			}
			
			}
			
		}
		
		@Test(priority = 2)
		
		public void selectDate() {
		
			driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys(selectDataValue);
			
			driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys(Keys.ENTER);
			
		}
		
		@Test(priority = 3, groups = "Passenger count")
		
		public void adultSelect() {
			
			// Select is class here...
			
			Select adultSelect = new Select(driver.findElement(By.id("Adults")));
			
			adultSelect.selectByVisibleText("1");
			
		}
			
		@Test(priority = 4, groups = "Passenger count")
		
		public void childSelect() {
			
			Select childSelect = new Select(driver.findElement(By.id("Childrens")));
			
			childSelect.selectByVisibleText("1");
			
		}
		
		@Test(priority = 5, groups = "Passenger count")
		
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
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailAdressValue);
			
			driver.findElement(By.cssSelector("#LoginContinueBtn_1")).click();
			
		}
		
		@Test(priority = 10)
		
		public void adult1Details() {
	

			WebDriverWait travellDetailsWait = new WebDriverWait(driver, 10);
			
			travellDetailsWait.until(ExpectedConditions.elementToBeClickable(By.id("travellerBtn")));
			
			Select adultTitle1 = new Select(driver.findElement(By.id("AdultTitle1")));
			
			adultTitle1.selectByValue(adultTitle1Value);
			
			driver.findElement(By.id("AdultFname1")).sendKeys(adultFname1Value);
			
			driver.findElement(By.id("AdultLname1")).sendKeys(adultLname1Value);
			
			Select AdultDobDay1 = new Select(driver.findElement(By.id("AdultDobDay1")));
			
			AdultDobDay1.selectByValue(adultDobDay1Value);
			
			Select AdultDobMonth1 = new Select(driver.findElement(By.id("AdultDobMonth1")));
			
			AdultDobMonth1.selectByValue(AdultDobMonth1Value);
			
			Select AdultDobYear1 = new Select(driver.findElement(By.id("AdultDobYear1")));
			
			AdultDobYear1.selectByValue(adultDobYear1Value);
			
			
			WebElement adultNationality1 = driver.findElement(By.xpath("//div[@id='intADDAD1']//input[@placeholder='Nationality']"));
					
			adultNationality1.sendKeys(adultNationality1Value);
			
			WebDriverWait waitadultNationality =new WebDriverWait(driver, 10);		
			
			waitadultNationality.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/ul[1]/li[1]/a[1]")));
			
			driver.findElement(By.xpath("/html[1]/body[1]/ul[1]/li[1]/a[1]")).click();	
			
			
		}
		
		@Test(priority = 11)
		
			public void child1Details() {
				
				Select ChildTitle1 = new Select(driver.findElement(By.id("ChildTitle1")));
				
				ChildTitle1.selectByValue(ChildTitle1Value);
				
				driver.findElement(By.id("ChildFname1")).sendKeys(ChildFname1Value);
				
				driver.findElement(By.id("ChildLname1")).sendKeys(ChildLname1Value);
				
				Select ChildDobDay1 = new Select(driver.findElement(By.id("ChildDobDay1")));
				
				ChildDobDay1.selectByValue(ChildDobDay1Value);
				
				Select ChildDobMonth1 = new Select(driver.findElement(By.id("ChildDobMonth1")));
				
				ChildDobMonth1.selectByValue(ChildDobMonth1Value);
				
				Select ChildDobYear1 = new Select(driver.findElement(By.id("ChildDobYear1")));
				
				ChildDobYear1.selectByValue(ChildDobYear1Value);
				
				WebElement childNationality1 = driver.findElement(By.xpath("//div[@id='intADDCD1']//input[@placeholder='Nationality']"));
				
				childNationality1.sendKeys(childNationality1Value);
				
				WebDriverWait waitchildNationality =new WebDriverWait(driver, 10);		
				
				waitchildNationality.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/ul[2]/li[1]/a[1]")));
				
				driver.findElement(By.xpath("/html[1]/body[1]/ul[2]/li[1]/a[1]")).click();			
				
			}
			
		@Test(priority = 12)
		
		public void infant1Details() {
			
			Select InfantTitle1 = new Select(driver.findElement(By.id("InfantTitle1")));
			
			InfantTitle1.selectByValue(InfantTitle1Value);
			
			driver.findElement(By.id("InfantFname1")).sendKeys(InfantFname1Value);
			
			driver.findElement(By.id("InfantLname1")).sendKeys(InfantLname1Value);
			
			Select InfantDobDay1 = new Select(driver.findElement(By.id("InfantDobDay1")));
			
			InfantDobDay1.selectByValue(InfantDobDay1Value);
			
			Select InfantDobMonth1 = new Select(driver.findElement(By.id("InfantDobMonth1")));
			
			InfantDobMonth1.selectByValue(InfantDobMonth1Value);
			
			Select InfantDobYear1 = new Select(driver.findElement(By.id("InfantDobYear1")));
			
			InfantDobYear1.selectByValue(InfantDobYear1Value);
			
			WebElement infantNationality1 = driver.findElement(By.xpath("//div[@id='intADDIN1']//input[@placeholder='Nationality']"));
			
			infantNationality1.sendKeys(infantNationality1Value);
			
			WebDriverWait waitInfantNationality =new WebDriverWait(driver, 10);		
			
			waitInfantNationality.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/ul[3]/li[1]/a[1]")));
			
			driver.findElement(By.xpath("/html[1]/body[1]/ul[3]/li[1]/a[1]")).click();			
			
		}
		
		@Test(priority = 13) 
		
		public void mobileNumber() {
			
			driver.findElement(By.id("mobileNumber")).sendKeys(mobileNumberValue);
			
			driver.findElement(By.id("travellerBtn")).click();
			
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
		
		
		
		
		
		
		
		
			
	
	
		 
		
		
		
	
	
