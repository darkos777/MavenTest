package package_project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//*******************************************************************************************
//******************************** Class No_2 in this package ********************************
//*******************************************************************************************

public class LoginPage extends Base
{
	@FindBy(id="email") WebElement email_field;
	@FindBy(id="password") WebElement password_field;
	@FindBy(css="button[type=submit]") WebElement login_btn_admin;
	
	public LoginPage(WebDriver web_driver)
	{
		super(web_driver);
		PageFactory.initElements(driver, this);
	}
	
	public void typeEmail(String admin_email)
	{
		typeText(email_field, admin_email);
	}
	
	public void typePassword(String admin_password)
	{
		typeText(password_field, admin_password);
	}
	
	public void clickLoginButton() throws InterruptedException
	{
		clickOnElement(login_btn_admin);
		Thread.sleep(8000);
	}
}
