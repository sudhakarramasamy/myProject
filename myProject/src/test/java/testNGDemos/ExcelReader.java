package testNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	public static XSSFWorkbook dataBook;

	public static String fromValue;
	
	@Test(priority = 0)	
	public static void ReaderMethog() throws IOException
	{
		
		FileInputStream file = new FileInputStream(new File("C:\\Users\\sudhakar.a.ramasamy\\eclipse-workspace\\myProject\\src\\test\\java\\com\\testData\\testData.xlsx"));
	
		dataBook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = (XSSFSheet)dataBook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		
		int colCont = sheet.getRow(1).getLastCellNum();
		
		for(int i = 1; i <= rowCount; i++)			
		{
			
			String data[] = new String[colCont];
			
			for(int j=0; j< colCont; j++)
				
			{
			
				XSSFCell cell = (XSSFCell)sheet.getRow(i).getCell(j);
				
				  if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				  
				  data[j] = cell.getRawValue();
				  System.out.println(data[j]);
				  
				  }
				  
				  if(cell.getCellType() == Cell.CELL_TYPE_STRING)
				  
				  {
						data[j] = cell.getStringCellValue();
				  
				  }
			
				  ClearTripDataPOJO.setFrom(data[0]);
					ClearTripDataPOJO.setFromEquals(data[1]);
					ClearTripDataPOJO.setTo(data[2]);
					ClearTripDataPOJO.setToEquals(data[3]);
					ClearTripDataPOJO.setSelectDate(data[4]);
					ClearTripDataPOJO.setEmail(data[5]);
					ClearTripDataPOJO.setAdultTitle1(data[6]);
					ClearTripDataPOJO.setAdultFname1(data[7]);
					ClearTripDataPOJO.setAdultLname1(data[8]);
					ClearTripDataPOJO.setAdultDobDay1(data[9]);
					ClearTripDataPOJO.setAdultDobMonth1(data[10]);
					ClearTripDataPOJO.setAdultDobYear1(data[11]);
					ClearTripDataPOJO.setAdultNationality1(data[12]);
					ClearTripDataPOJO.setChildTitle1(data[13]);
					ClearTripDataPOJO.setChildFname1(data[14]);
					ClearTripDataPOJO.setChildLname1(data[15]);
					ClearTripDataPOJO.setChildDobDay1(data[16]);
					ClearTripDataPOJO.setChildDobMonth1(data[17]);
					ClearTripDataPOJO.setChildDobYear1(data[18]);
					ClearTripDataPOJO.setChildNationality1(data[19]);
					ClearTripDataPOJO.setInfantTitle1(data[20]);
					ClearTripDataPOJO.setInfantFname1(data[21]);
					ClearTripDataPOJO.setInfantLname1(data[22]);
					ClearTripDataPOJO.setInfantDobDay1(data[23]);
					ClearTripDataPOJO.setInfantDobMonth1(data[24]);
					ClearTripDataPOJO.setInfantDobYear1(data[25]);
					ClearTripDataPOJO.setInfantNationality1(data[26]);
					ClearTripDataPOJO.setMobileNumber(data[27]);
			
			}
			
			fromValue = ClearTripDataPOJO.getFrom();
			
		}

}
	
	@Test(priority = 1)
	
	public void display()
	{
		System.out.println(fromValue);
	}

}
