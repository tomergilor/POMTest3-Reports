package dp;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {

	public static void main(String[] args) throws IOException {
		Object[][] myDataObject = getDataFromExcelToObject("C:\\Users\\tomer\\Documents\\usersForAutomation\\Book1.xlsx", "sheet1");
		System.out.println("break");
	}

	// Method to work with excel
	public static String[][] getDataFromExcelToObject(String filePath, String sheetName) throws IOException {
		String[][] tableArray = null;
		
		try {
		// Get the excel
		FileInputStream excelFile = new FileInputStream(filePath);
		XSSFWorkbook ExcelwBook = new XSSFWorkbook(excelFile);
		XSSFSheet ExcelwSheet = ExcelwBook.getSheet(sheetName);
		
		// Range of data
		int totalRow = 4;
		int totalCol = 3;
		
		
			tableArray = new String [totalRow][totalCol];
			
			for(int i=0; i < totalRow; i++) {
				for(int j=0; j < totalCol ; j++) {
					 // create method that reading from excel
					tableArray[i][j] = ExcelwSheet.getRow(i+1).getCell(j+1).getStringCellValue();
					
					System.out.println("Insert: " + tableArray[i][j]);
				}
			} 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return tableArray;
		
	  }
	
	// method for reading excel cell data
	
		
}

