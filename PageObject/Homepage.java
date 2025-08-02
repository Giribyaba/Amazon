package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Homepage
{
	
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  // this is required in 
		   
	}
	
	

	@FindBy(xpath="//input[@placeholder='Username']") 
	private WebElement txt_username;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement txt_password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement btn_login;
	@FindBy(xpath="//h6[.='Dashboard']")
	private WebElement page_header;
				
	
	public void Username(String User)
	{
		txt_username.sendKeys(User);
	}
	
	public void Password(String Pswrd)
	{
		txt_password.sendKeys(Pswrd);
	}
	public void Login()
	{
		btn_login.click();
	}
	
}
