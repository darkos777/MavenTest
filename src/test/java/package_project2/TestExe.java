package package_project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExe 
{
	WebDriver driver;
	Base base;
	
	@BeforeTest
	public void openBrowserTest()
	{
		/*
		try 
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\DigitalAtrium\\Selenium_files\\chrome_driver79\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/FreestyleForMaven/chromedriver_linux");			
			driver = new ChromeDriver();
		} 
		catch (Exception e) 
		{
			System.out.println("STARTING BROWSER NOT POSSIBLE: " + e.getMessage());
		}
		*/
		
		WebDriverManager.chromedriver().version("79.0.3945.36").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options); 
	}
	
	@Test(priority = 1)
	public void startAppTest()
	{
		base = new Base(driver);
		base.getAppURL("https://nd-cta-staging.com/login");
	}
}
