package com.parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametersTest {
	
	public WebDriver driver; 	
	
	String chromepath = "C:\\Users\\sudhakar.a.ramasamy\\Documents\\Learning Selenium\\chromedriver.exe";
	
@Test
@Parameters({"baseURL"})

	public void openBrowser(String baseURL) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", chromepath);
			
			driver = new ChromeDriver();
			
			driver.get(baseURL);
			
			Thread.sleep(3000);
			
			driver.manage().window().maximize();


			
}
}
