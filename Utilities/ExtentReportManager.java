package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseTest.BaseClass;


public class ExtentReportManager implements ITestListener 
{
	public static  ExtentSparkReporter sparkReporter; 
	public static ExtentReports extent;//populate common info on the report
	public static ExtentTest test;//  creating the test case entries
	String repname ;

	@Override
	public void onStart(ITestContext context)
	{		
		String  timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format( new Date());
		repname = "Test-Report-"+timestamp+".html";
		 
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+ repname);
				
				//System.getProperty("user.dir")+ "/reports/myReport.html");//UI of the report
		sparkReporter.config().setDocumentTitle("Automation report");
		sparkReporter.config().setReportName("Functional testing ");
		
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		 
	
		 
		 extent.setSystemInfo("computer Name", "local host");
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
				test = extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getMethodName());
				test.log(Status.PASS, "Test is passed is:" + result.getName());
			   
			  }

	@Override
	public void onTestFailure(ITestResult result) 
		{ 
			test = extent.createTest(result.getTestClass().getName()); // Fails if extent is null
	        test.assignCategory(result.getMethod().getMethodName()); // Fails if extent is null
	        test.fail(result.getThrowable().getMessage());
	        test.fail(result.getName()+"got failed");
	        
	        try
	        {
	        	
	        	Thread.sleep(2000);
	        	String imagepath = new BaseClass().capturescreenshot(result.getName());
	        	test.addScreenCaptureFromPath(imagepath);
	        }
	        catch(Exception e1)
	        {
	        e1.printStackTrace();
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
			 test.assignCategory( result.getName());
			   test.log(Status.SKIP, "Test is skiped is:" + result.getName());
			   
			  }
		
		
	@Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	
	}

