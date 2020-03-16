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
	LoginPage login_page;
	GmailVerification gmail_ver;
	LoggedInAdmin logged_in;
	
	@BeforeTest
	public void openBrowserTest()
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
	public void startAppTest()
	{
		base = new Base(driver);
		base.getAppURL("***");
	}
	
	@Test(priority = 2)
	public void LoginPageTest() throws InterruptedException
	{
		login_page = new LoginPage(driver);
		
		login_page.typeEmail("***");
		login_page.typePassword("***");
		login_page.clickLoginButton();
	}
	
	@Test(priority = 3)
	public void gmailAutomationTest() throws InterruptedException
	{
		gmail_ver = new GmailVerification(driver);
		
		gmail_ver.openGmailInNewTab();
		gmail_ver.typeGmailUsername("***");
		gmail_ver.clickNextButton();
		gmail_ver.typePassword("***");
		gmail_ver.clickNextButton();
		gmail_ver.openGmailInbox();
		gmail_ver.openTwoFactorCodeEmail();
		gmail_ver.copyPasteTextWithCode();
	}
	
	@Test(priority = 4)
	public void loggedInAdmin()
	{
		logged_in = new LoggedInAdmin(driver);
		
		logged_in.addNewTester();
		logged_in.typeTestersName("TestQA");
		logged_in.typeTestersUsername("TestQA");
		logged_in.typeTestersEmail("testqa@gmail.com");
		logged_in.typeTestersPIN("1234");
		logged_in.confirmToAddNewTester();
	}
}
