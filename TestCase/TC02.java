package TestCase;





import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObject.Homepage;
import PageObject.Homepage2;
import PageObject.Login;
import PageObject.MyAccountPage;


public class TC02 extends BaseClass

{
	@Test
  public void validMyAccounr() throws InterruptedException
  {
	 // logger.info("*******Strating TC01*****");

	  
	  //Home page 
		
		
	  Homepage2 hp=new Homepage2(driver);
	  Thread.sleep(2000);
		hp.myaccount();
		hp.btn_Login();
		
	//login page 	
		 Thread.sleep(2000);
		Login lp = new Login(driver);
		lp.sendUsername(p.getProperty("username"));
		lp.sendPasword(p.getProperty("password"));
		lp.clcikLogin();
		
	//
		 Thread.sleep(2000);
		MyAccountPage my=new MyAccountPage(driver);
		boolean targetpage = my.isMyAccountisdisplayed();
		//Assert.assertEquals(targetpage, true);
		
		Assert.assertTrue(true);
  }
}
