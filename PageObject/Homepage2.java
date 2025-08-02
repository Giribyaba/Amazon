package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.BaseClass;

public class Homepage2
{
WebDriver driver;

  public Homepage2(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  @FindBy(xpath="//span[.='My Account']")
  private WebElement btn_myacc;
  
  @FindBy(xpath="//a[.='Login']")
  private WebElement btn_Login ;
  
  
  
  
  public void myaccount()
  {
	  btn_myacc.click();
  }
  public void btn_Login()
  {
	  btn_Login.click(); 
  }
  
}
