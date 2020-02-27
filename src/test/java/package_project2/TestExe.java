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
		WebDriverManager.chromedriver().version("79.0.3945.36").setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("no-sandbox"); 			//--
		options.addArguments("disable-infobars");		//--
		options.addArguments("disable-dev-shm-usage");	//--
		options.addArguments("disable-browser-side-navigation"); 	//--
		options.addArguments("disable-gpu"); 			//--
		
		driver = new ChromeDriver(options); 
	}
	
	@Test(priority = 1)
	public void startAppTest()
	{
		base = new Base(driver);
		base.getAppURL("https://nd-cta-staging.com/login");
	}
}
