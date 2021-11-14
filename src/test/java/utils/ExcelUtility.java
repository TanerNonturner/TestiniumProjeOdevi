package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void loadSheet(String sheetName) {

		sheet = book.getSheet(sheetName);

	}

	private static int rowCount() {

		return sheet.getPhysicalNumberOfRows();
	}

	public static int colsCount(int rowIndex) {

		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {

		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// return a 2D array

	public static Object[][] excelIntroArray(String filePath, String sheetName) {

		openExcel(filePath);

		loadSheet(sheetName);

		int rows = rowCount();

		int cols = colsCount(0);

		Object[][] data = new Object[rows - 1][cols];
		// not from headers because row starts 1
		for (int row = 1; row < rows; row++) {

			for (int col = 0; col < cols; col++) {
				// we must start from zero to store in row
				data[row - 1][col] = cellData(row, col);// we use cellData() method to get the data of cell
			}

		}

		return data;

	}

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {

		openExcel(filePath);

		loadSheet(sheetName);
		
		List<Map<String,String>> list = new ArrayList<>();
		
		Map<String, String> excelMap;
		
		
		for(int row=1 ; row<rowCount(); row++) {
			
			excelMap= new LinkedHashMap<>();
			for(int c=0; c<colsCount(row);c++) {
				excelMap.put(cellData(0,c), cellData(row,c));
			}
			
		 list.add(excelMap)	;
		 
		 
		}
		

		return list;

	}

	
	
	
}
