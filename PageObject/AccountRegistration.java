package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration {
	WebDriver driver;
public AccountRegistration (WebDriver driver)
{
	this.driver=driver;
	 PageFactory.initElements(driver, this);  // this is required
	   
}

	@FindBy(xpath="//input[@type='text']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSearch;

	 public void search(String searchTerm) 
	 {
	        searchBox.sendKeys(searchTerm);
	        btnSearch.click();
    
	 }
}


	

	

	
	

