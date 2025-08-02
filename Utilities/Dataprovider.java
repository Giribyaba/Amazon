package Utilities;

import org.testng.annotations.DataProvider;

public class Dataprovider
{
	
	@DataProvider(name="logindata")
	 public Object[][] getsheetdata()
	 {
		String path=".\\Testdata\\Logintestdata.xlsx";
		String sheetname="Sheet1";
		 try {
			 ExcellUtility exceutil = new ExcellUtility(path, sheetname);
				return exceutil.getsheetdata();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return new Object[0][0];
	 }

	//DATAPROVER 2
	//data provider 3
}
