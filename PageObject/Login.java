package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.BaseClass;

public class Login 
{
WebDriver driver;

  public Login(WebDriver driver) 
  {
   this. driver=driver;
   PageFactory.initElements(driver, this);
}
  
  
  @FindBy(xpath="//input[@id='input-email']")
  private WebElement txt_username;
  
  
  @FindBy(xpath="//input[@id='input-password']")
  private WebElement txt_pasword;
  
  
  @FindBy(xpath="//input[@value='Login']")
  private WebElement btn_login  ;
  
  
  
  public void sendUsername (String username)
  {
	  txt_username.sendKeys(username);
  }
  
  public void sendPasword (String password)
  {
	  txt_pasword.sendKeys(password);
  }
  public void clcikLogin ()
  {
	  btn_login.click();
  }
  
}
