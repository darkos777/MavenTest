package package_project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExe 
{
	WebDriver driver;
	Base base;
	
	@BeforeTest
	public void openBrowserTest()
	{
		try 
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\DigitalAtrium\\Selenium_files\\chrome_driver79\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/FreestyleForMaven/chromedriver.exe");			
			driver = new ChromeDriver();
		} 
		catch (Exception e) 
		{
			System.out.println("STARTING BROWSER NOT POSSIBLE: " + e.getMessage());
		}
	}
	
	@Test(priority = 1)
	public void startAppTest()
	{
		base = new Base(driver);
		base.getAppURL("https://nd-cta-staging.com/login");
	}
}
