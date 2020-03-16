package package_project2_email_ver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import package_project2.Base;

//*******************************************************************************************
//******************************** Class No_1 in this package *******************************
//*******************************************************************************************

public class EmailVerification extends Base
{
	private String gmail_url = "https://accounts.google.com";
	private String gmail_inbox_link = "https://mail.google.com/mail/?tab=km1";
	
	//Gmail fileds (before login)
	@FindBy(css = "input[type=email][autocomplete=username]") WebElement gmail_username;
	@FindBy(xpath = "//span[@class='RveJvd snByac'][text()='Даље']") WebElement dalje_btn;
	@FindBy(css = "input[type=password]") WebElement gmail_password;	
	
	//Inside Gmail (when logged in)
	@FindBy(xpath = "(//span[contains(text(), 'ND HCP Hi Darko Stekić, Your two factor verification code is')])[1]") WebElement mail_title;
	//@FindBy(xpath = "//a[text()='Verify Here']") WebElement verify_here_btn;
	
	//Verification page on the web 
	@FindBy(css = "input[name='two_factor_code'][placeholder='Code']") WebElement code_input_field;
	@FindBy(xpath = "//button[text()='Verify']") WebElement verify_btn;
	
	public EmailVerification(WebDriver web_d)
	{
		super(web_d);
		PageFactory.initElements(web_d, this);
	}
	
	public void getEmailURL()
	{
		getAppURL(gmail_url);
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
	
	/*
	 * public void moveFromGmailToVerificationWindow() {
	 * moveIntoCorrectWindow(code_input_field, 5, 1); }
	 * 
	 * public void useTheCodeFromEmail() throws InterruptedException { String
	 * copy_text = driver.findElement(By.
	 * xpath("//p[contains(text(), 'Your two factor verification code')]")).getText(
	 * ); System.out.println("Copied sentence with the code is: " + copy_text);
	 * Thread.sleep(3000);
	 * 
	 * this.moveFromGmailToVerificationWindow(); typeText(code_input_field,
	 * copy_text); }
	 */

}
