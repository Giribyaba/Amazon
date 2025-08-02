package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 

{
	WebDriver driver;

	  public MyAccountPage(WebDriver driver) 
	  {
	   this. driver=driver;
	   PageFactory.initElements(driver, this);
	}
	  
	  @FindBy(xpath="//h2[normalize-space()='My Account']")
	  WebElement msgheading;
	  
	  @FindBy(xpath="//a[@class=\"list-group-item\"][normalize-space()='Logout']")
	  WebElement lnklogout;
	  
	  public boolean isMyAccountisdisplayed()
	  {
		try {
			
		return(  msgheading.isDisplayed());
		  	}
	  
	  catch(Exception e)
	  {
		  return false;
	  }
	  }
		
	public void clicklogout()
	{
			lnklogout.click();
		}
	  

}

