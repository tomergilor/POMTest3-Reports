package dp;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import dp.excel;


public class Data {

	@DataProvider(name = "dataFromExcel")
	public static String[][]dataFromExcel() throws IOException{
		String[][]myDataObject = excel.getDataFromExcelToObject("C:\\Users\\tomer\\Documents\\usersForAutomation\\Book1.xlsx", "sheet1");
		return myDataObject;
	}
	   
	
	// Method that provide data to test
	@DataProvider(name = "Details")
	public static Object[][] details() {
		return new Object[][] { { "Name1", "name1@test.com", "password1" }, { "name2", "name2@test.com", "password2" },
				{ "name3", "name3@test.com", "password3" } };
	}

	// Method that provide data to test
	@DataProvider(name = "Details Int")
	public static Object[][] details_int() {
		return new Object[][] { { 1, 2, 3 }, { 10, 20, 30 }, { 100, 200, 300 } };
	}

}
