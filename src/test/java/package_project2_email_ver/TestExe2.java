package package_project2_email_ver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExe2 
{
	WebDriver driver;
	EmailVerification verification;
	
	
	  @BeforeTest 
	  public void openBrowserTest2() 
	  {
	  WebDriverManager.chromedriver().version("79.0.3945.36").setup();
	  
	  ChromeOptions options = new ChromeOptions();
	  
	  options.addArguments("start-maximized");
	  options.addArguments("enable-automation");
	  options.addArguments("--no-sandbox");
	  options.addArguments("--disable-infobars");
	  options.addArguments("--disable-dev-shm-usage");
	  options.addArguments("--disable-browser-side-navigation");
	  options.addArguments("--disable-gpu"); 
	  //options.addArguments("--headless");
	  options.addArguments("--remote-debugging-port=9222");
	  
	  driver = new ChromeDriver(options); 
	  }
	 
	
	@Test(priority = 1)
	public void startGmail() throws InterruptedException
	{
		verification = new EmailVerification(driver);
		
		verification.getEmailURL();
		verification.typeGmailUsername("test.random.acc1@gmail.com");
		verification.clickNextButton();
		verification.typePassword("testaccount789");
		verification.clickNextButton();
		verification.openGmailInbox();
		verification.openTwoFactorCodeEmail();
		//verification.useTheCodeFromEmail();
	}
}
