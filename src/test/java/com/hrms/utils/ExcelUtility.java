package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;

	public static void openExcel(String filepath)  {// filename=filepath same thing
		try {
			FileInputStream fis = new FileInputStream(filepath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadSheet(String sheetname) {
		sheet = book.getSheet(sheetname);
	}

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}

	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// return a 2d obj array of data
	public static Object[][] excelIntoArray(String filepath, String sheetname) {
			openExcel(filepath);
			loadSheet(sheetname);
			
			int rows = rowCount();
			int cols = colsCount(0);
			
			//Object[][] data=new Object[row(rowCount()-1)][colsCount(0)];
			Object[][] data = new Object[rows - 1][cols];

			//iterating
			for(int i = 1; i < rows; i++) {
				//iterating cols
				for(int j = 0; j < cols; j++) {
					data[i-1][j] = cellData(i, j);
				}
			}
			return data;
	}
	
	//hw return a method that will return a list of Maps

}