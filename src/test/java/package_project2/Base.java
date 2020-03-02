package package_project2;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//*******************************************************************************************
//******************************** Class No_1 in this package ********************************
//*******************************************************************************************

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
}
