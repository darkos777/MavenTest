package package_project2;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//*******************************************************************************************
//******************************** Class No_1 in this package *******************************
//*******************************************************************************************

public class Base 
{
	public WebDriver driver;
	WebDriverWait wait;
	
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
	
	public void typeText(WebElement txt_element, String text)
	{
		txt_element.sendKeys(text);
	}
	
	public void clickOnElement(WebElement element)
	{
		try 
		{
			element.click();
		} 
		catch (NoSuchElementException nse) 
		{
			System.out.println("THERE IS NO ELEMENT THAT YOU ARE SEARCHING FOR: " + nse.getMessage());
		}
	}
	
	public void openLinkInNewTab(int tab_index, String url_link)
	{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab_index));
		driver.get(url_link);
	}
	
	public void waitForElement(WebElement waiting_element, int seconds)
	{
		try 
		{
			wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(waiting_element));
		} 
		catch (TimeoutException te) 
		{
			System.out.println("TIMEOUT EXCEPTION: " + te.getMessage());
		}
	}
	
	public void moveIntoCorrectWindow(WebElement wait_for_element, int number_of_seconds, int window_number)
	{
		int count = 0;
		Set<String> all_windows = driver.getWindowHandles();
		
		for(String each_window1:all_windows)
		{
			driver.switchTo().window(each_window1);
			count++;
			
			if(count == window_number)
			{
				this.waitForElement(wait_for_element, number_of_seconds);
			}
		}
	}
	
	  // Prefix, sufix for TESTER'S USERNAME
	/*
    public void typeTesterEmail2()
    {
    	long nano_start_time = System.nanoTime();
    	String tester_sufix_usn = String.valueOf(nano_start_time);
    	
    	System.out.println("Nano time is: " + tester_sufix_usn);
    }
    */
}
