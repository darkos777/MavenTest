package package_project2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

//*******************************************************************************************
//******************************** Class No_3 in this package *******************************
//*******************************************************************************************

public class GmailVerification extends Base
{
	private String gmail_inbox_link = "https://mail.google.com/mail/?tab=km1";
	
	//Gmail fields (before login)
	@FindBy(css = "input[type=email][autocomplete=username]") WebElement gmail_username;
	@FindBy(xpath = "//span[@class='RveJvd snByac'][text()='Даље']") WebElement dalje_btn;
	@FindBy(css = "input[type=password]") WebElement gmail_password;	
	
	//Inside Gmail (when logged in)
	@FindBy(xpath = "(//span[contains(text(), 'ND HCP Hi Darko Stekić, Your two factor verification code is')])[1]") WebElement mail_title;
	@FindBy(xpath = "//p[contains(text(), 'Your two factor verification code')]") WebElement text_with_code;
	@FindBy(xpath = "//a[text()='Verify Here']") WebElement verify_here_btn;
	
	//Verification page on the web 
	@FindBy(xpath = "//div[@class='form-control-wrap']/input") WebElement code_input_field;
	@FindBy(xpath = "//button[text()='Verify']") WebElement verify_btn;
	
	public GmailVerification(WebDriver web_driver)
	{
		super(web_driver);
		PageFactory.initElements(driver, this);
	}
	
	public void openGmailInNewTab()
	{
		openLinkInNewTab(0, "https://accounts.google.com");
	}
	
	public void typeGmailUsername(String gmail_usn)
	{
		typeText(gmail_username, gmail_usn);
	}
	
	public void clickNextButton()
	{
		clickOnElement(dalje_btn);
	}
	
	public void typePassword(String gmail_pass) throws InterruptedException 
	{
		Thread.sleep(3000);
		typeText(gmail_password, gmail_pass);
	}
	
	public void openGmailInbox() throws InterruptedException
	{
		Thread.sleep(5000);
		getAppURL(gmail_inbox_link);
	}
	
	public void openTwoFactorCodeEmail() throws InterruptedException
	{
		clickOnElement(mail_title);
		Thread.sleep(5000);
	}
	
	public void copyPasteTextWithCode() throws InterruptedException
	{
		String string_txt = text_with_code.getText();
		String code_from_email = string_txt.replaceFirst("Your two factor verification code is ", "");
		clickOnElement(verify_here_btn);	
		
		/*
		Boolean is_present = driver.findElements(By.className("//form[@class='form']")).size() > 0;		//checking if elements are visible inside another element
		System.out.println("VALUE for is_present: " + is_present);
		*/
		
		Thread.sleep(7000);		
		moveIntoCorrectWindow(code_input_field, 5, 2);
		typeText(code_input_field, code_from_email);
		clickOnElement(verify_btn);
	}
	
	
}
