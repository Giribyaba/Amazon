package TestCase;

import java.time.Duration;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BaseTest.BaseClass;
import PageObject.AccountRegistration;
import PageObject.Homepage;


public class TC001_AccountRegistration extends BaseClass
{


	
	
	@Test(dataProvider="dp")
  public void verify_accountmanahment(String Username, String pswrd, String expectedResult) throws InterruptedException
	{
		
	//	try {
			
	//	logger.info("test started execution ");
		Homepage hp=new Homepage(driver);
		
		Thread.sleep(2000);
		hp.Username(Username);
	//	logger.debug("enter username:" + Username);
		Thread.sleep(2000);
		hp.Password(pswrd);
	//	logger.debug("enter username:" + pswrd);

		Thread.sleep(2000);
		hp.Login();
		Thread.sleep(2000);
		if(expectedResult.equals("valid"))
		{
			boolean contains = driver.getCurrentUrl().toLowerCase().contains("dashboard");
			Assert.assertTrue(contains,"is dashboard visible:" + Username);
		}
		else if(expectedResult.equals("invalid"))
		{
			boolean isErrorisdisplyed = driver.getPageSource().contains("Invalid credentials");
			Assert.assertTrue(isErrorisdisplyed,"Expected error shown for invalid credentials:" + Username);
		}
	}
	
	//	catch(Exception e)
	//	{
		//	logger.error("an exception occured during the login:" + e.getMessage() );
	//	}
		
	//	logger.info("login test completed");
	// }
	
	@DataProvider(name="dp")
	Object [][] logindata ()
	{
		Object data[][]= {
			
				{"axy","abc","invalid"},
				{"abc","xyz","invalid"},
				{"qwr","18uy","invalid"},
				{"admin","admin123","valid"}
				};
		return data;
	}
}


		

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
