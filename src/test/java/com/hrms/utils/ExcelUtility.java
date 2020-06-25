package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;

	public static void openExcel(String filepath) {
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

		// Object[][] data=new Object[row(rowCount()-1)][colsCount(0)];
		Object[][] data = new Object[rows - 1][cols];

		// iterating rows
		for (int i = 1; i < rows; i++) {
			// iterating cols
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] = cellData(i, j);
			}
		}
		return data;
	}

	public static List<Map<String, String>> excelIntoListOfMaps(String filepath, String sheetName) {
		openExcel(filepath);
		loadSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> excelMap;

		for (int r = 1; r < rowCount(); r++) {
			excelMap = new LinkedHashMap<>();
			for (int c = 0; c < colsCount(r); c++) {
				// excelMap.put(cellData(0, c).toString(),cellData(r,c).toString());
				excelMap.put(cellData(0, c), cellData(r, c));
			}
			list.add(excelMap);
		}
		return list;
	}
	// hw return a method that will return a list of Maps
	// why we go with list of maps? cuz we have multiple rows and cols
	// each row is a map
	/*
	 * public static List<Map<String,String>> excelReader(String filePath, String
	 * sheetName){ List<Map<String,String>> mapList=new LinkedList<>(); Workbook
	 * workbook = null; try { FileInputStream fis=new FileInputStream(filePath);
	 * workbook=new XSSFWorkbook(fis); } catch (Exception e) { e.printStackTrace();
	 * } Sheet sheet=workbook.getSheet(sheetName); int
	 * row=sheet.getPhysicalNumberOfRows(); int
	 * col=sheet.getRow(0).getLastCellNum(); for(int r=1;r<row;r++) {
	 * Map<String,String> map=new LinkedHashMap<>(); for(int c=0;c<col;c++) { String
	 * key=sheet.getRow(0).getCell(c).getStringCellValue(); String
	 * value=sheet.getRow(r).getCell(c).toString(); map.put(key,value); }
	 * mapList.add(map); } return mapList; }
	 */
}