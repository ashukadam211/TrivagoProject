package com.qa.Utility;

import java.io.FileInputStream;


import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fileLoc;
	public static XSSFWorkbook wBook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//get row count
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		
		fileLoc = new FileInputStream(xlFile);
		wBook = new XSSFWorkbook(fileLoc);
		wSheet = wBook.getSheet(xlSheet);
		
		int rowCount = wSheet.getLastRowNum();
		wBook.close();
		fileLoc.close();
		
		return rowCount;
		
	}
	
	//get the cell count of each row
	public static int getCellCount(String xlFile, String xlSheet, int rowNum)throws IOException {
		fileLoc = new FileInputStream(xlFile);
		wBook = new XSSFWorkbook(fileLoc);
		wSheet = wBook.getSheet(xlSheet);
		
		row = wSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		
		wBook.close();
		fileLoc.close();
		
		return cellCount;
	}
	
	//get the value in each cell
	public static String getCellData(String xlFile,String xlSheet,int rowNum, int column)throws IOException{
		
		fileLoc = new FileInputStream(xlFile);
		wBook = new XSSFWorkbook(fileLoc);
		wSheet = wBook.getSheet(xlSheet);
		
		row = wSheet.getRow(rowNum);
		cell = row.getCell(column);
		
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		
		wBook.close();
		fileLoc.close();
		
		return cellData;
		
		
	}
	
	
	

}