package BaseTest;


import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	public static WebDriver driver; // TO MAKE IT AS COMMON VARIABLE ACCROSS THE PROGRAMM WE MAKE AS STATIC 
	//public Logger logger;//log4j
	public Properties p;
	//@SuppressWarnings("deprecation")
	@BeforeClass
	  public void setup() throws IOException
	  {
		
		FileReader file = new FileReader("./src//test//java//Resourse//config.properties");
		p=new Properties();
		p.load(file);
		
		//Selenium grid code  
	//	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		//{
			//DesiredCapabilities cap= new DesiredCapabilities();
			//cap.setPlatform(Platform.WIN10);
			//cap.setBrowserName("chrome");
		//	driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"),cap);
					
					//URL("http://192.168.56.1:4444/wb/hub"), cap);
		
		//logger=core.getLogger(this.getClass());
				driver=new ChromeDriver();
			  driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 driver.get(p.getProperty("url"));
	 // }
	  }
				  
		
	@AfterClass
	  public void teardown()
	  {
		  driver.quit();
	  }

	  
	  
	  public String capturescreenshot(String tname) throws IOException
	  {
	  String  timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format( new Date());
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File sourcefile = ts.getScreenshotAs(OutputType.FILE);
	  String targetfilepath= System.getProperty("user.dir")+ "\\Screenshots\\"+tname+"-"+ timestamp+".png";
	  File targetFile=new File(targetfilepath);
	  sourcefile.renameTo(targetFile);
	  return targetfilepath;
	  }
	  
}
//	 public String randomnumaric() 
//	 {
//		 String randomNumeric = RandomStringUtils.randomNumeric(5);
//		return randomNumeric;
//	 }
//	 public String randomstring() 
//	 {
//		 String randomString = RandomStringUtils.randomAlphabetic(6);
//		return randomString;
//	 }
//	 public String randomnumber() 
//	 {
//		 String randomnumber = RandomStringUtils.randomNumeric(6);
//		return randomnumber;
//	 }
//	 public String RandomeAlphaNumber()
//	 {
//		 String generatedrandomNumeric = RandomStringUtils.randomNumeric(5);
//		 String generatedrandomString = RandomStringUtils.randomAlphabetic(6);
//		 return(generatedrandomNumeric+"@"+generatedrandomString);
	 

