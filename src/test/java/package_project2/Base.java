package package_project2;

import org.openqa.selenium.WebDriver;

public class Base 
{
public WebDriver driver;
	
	public Base(WebDriver web_driver)
	{
		this.driver = web_driver;
	}
	
	public void getAppURL(String app_url)
	{
		try 
		{
			driver.get(app_url);
			driver.manage().window().maximize();
		} 
		catch (Exception e) 
		{
			System.out.println("URL EXCEPTION: " + e.getMessage());
		}
	}
}
