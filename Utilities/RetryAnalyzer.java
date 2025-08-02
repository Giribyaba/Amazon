package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.TestNG; 
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryAnalyzer  implements IRetryAnalyzer
{
	int count=0;
	  int max_count= 2;

@Override
public boolean retry(ITestResult result) {
	
	  
	  if(count<max_count)
	  {
		  count++;
		  return true;
	  }
	return false;
}
}
