package TestCase;

import org.junit.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObject.Homepage2;
import PageObject.Login;
import PageObject.MyAccountPage;
import Utilities.Dataprovider;
import Utilities.RetryAnalyzer;
public class TC03_Logindata  extends BaseClass
{
	@Test(dataProvider="logindata", 
			dataProviderClass= Dataprovider.class,
			retryAnalyzer=RetryAnalyzer.class)//if the dataprovider created in the another class to access the data providerclass 
public void verify_loginDDT(String username, String password, String res ) throws InterruptedException
{
		  Homepage2 hp=new Homepage2(driver);
		  Thread.sleep(2000);
			hp.myaccount();
			hp.btn_Login();
			
		//login page 	
			 Thread.sleep(2000);
			Login lp = new Login(driver);
			lp.sendUsername(username);
			lp.sendPasword(password);
			lp.clcikLogin();
			
		//
			 Thread.sleep(2000);
			MyAccountPage my=new MyAccountPage(driver);
			boolean targetpage = my.isMyAccountisdisplayed();
			
			
			if(res.equalsIgnoreCase("valid"))
		{
				if(targetpage==true)
				{
				my.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			if (res.equalsIgnoreCase("invalid"))
		{

				if(targetpage==true)
				{
				my.clicklogout();
				Assert.assertTrue(false);
				}
			
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
}
}
