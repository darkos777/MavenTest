package package_project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//******************************************************************************************
//******************************** Class No_4 in this package ******************************
//******************************************************************************************

public class LoggedInAdmin extends Base
{
	@FindBy(className = "btn-primary") WebElement add_tester_btn;
	@FindBy(css = "input[type=text][name=name]") WebElement tester_name;
    @FindBy(css = "input[type=text][name=username]") WebElement tester_username;
    @FindBy(css = "input[type=email][name=email ]") WebElement tester_email;
    @FindBy(css = "input[type=text][name=pin]") WebElement tester_pin;
    @FindBy(xpath = "//span[text()='ADD TESTER']") WebElement add_tester_confirm_button;

	public LoggedInAdmin(WebDriver web_driver) 
	{
		super(web_driver);
		PageFactory.initElements(driver, this);
	}
	
	public void addNewTester()
	{
		clickOnElement(add_tester_btn);
		waitForElement(tester_name, 5);
	}
	
	public void typeTestersName(String name)
    {
        typeText(tester_name, name);
    }

    public void typeTestersUsername(String username)
    {
    	long nano_start_time = System.nanoTime();
    	String tester_sufix_usn = String.valueOf(nano_start_time);
    	
        typeText(tester_username, username + tester_sufix_usn);
    }

    public void typeTestersEmail(String email)
    {
        typeText(tester_email, email);
    }
    
    public void typeTestersPIN(String pin)
    {
        typeText(tester_pin, pin);
    }
    
    
	public void confirmToAddNewTester()
	{
		clickOnElement(add_tester_confirm_button);
		waitForElement(add_tester_btn, 3);
	}
}
