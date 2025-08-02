package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellUtility 
{
public FileInputStream file;
public XSSFWorkbook workbook ;
public XSSFSheet sheet;
public DataFormatter formatter;

	 public ExcellUtility(String excelpath, String sheetname) throws IOException
	 {
		 
		 try {
		 
		  file = new FileInputStream(excelpath);
		  workbook = new XSSFWorkbook(file);
		  sheet = workbook.getSheet(sheetname);
	 }
		 catch( Exception e)
		 {
			 e.printStackTrace();
		 }
}
	 
	 public int getrowcount()
	 {
		return  sheet.getPhysicalNumberOfRows();
	 }
	 
	 public int getcolumncount()
	 {
		 return sheet.getRow(0).getPhysicalNumberOfCells();
	 }
	 
	 
	// Get cell data
	 public String getcelldate(int colnum,int rownum)
	 {
		 XSSFCell cell = sheet.getRow(rownum).getCell(colnum);
		 formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	 }
	 
	 
	 public Object[][] getsheetdata()
	 {
		 int rowcount = getrowcount();
		 int colcount=getcolumncount();
		 
		 Object [][] data=new Object[rowcount-1][colcount];
				 
				 for(int i=1;i<rowcount;i++)
				 {
					 for(int j=0;j<colcount;j++)
					 {
						 data[i-1][j]=getcelldate(j,i);
					 }
				 }
				return data;
	 }
}
