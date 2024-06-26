package api.utilities;

import org.testng.annotations.*;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws Exception{
		String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rowCount = xl.getRowCount("Sheet1");
		int colCount = xl.getCellCount("Sheet1",1);
		
		String apiData[][] = new String[rowCount][colCount];
		
		for(int i = 1;i <= rowCount; i++) {
			for(int j = 0; j< colCount; j++) {
				apiData[i-1][j] = xl.getCellData("Sheet1",i,j);
			}
		}
		return apiData;
	}
	
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws Exception{
		String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rowCount = xl.getRowCount("Sheet1");
		
		String[] apiData = new String[rowCount];
		
		for(int i = 1;i <= rowCount; i++) {
			apiData[i-1] = xl.getCellData("Sheet1",i, 1);
		}
		return apiData;
	}
}
