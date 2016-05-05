package com.paytm.bus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteXL {


	public static String getXLData(String fileName,String sheetName,int rowNo, int colNo) throws IOException,InvalidFormatException{

		File dataFile=new File(fileName);
		FileInputStream fin= new FileInputStream(dataFile);

		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheet(sheetName);
		XSSFRow row;
		XSSFCell col;
		String cellData = null;

		row=sh.getRow(rowNo);
		col=row.getCell(colNo);
		switch(col.getCellType()){
		case XSSFCell.CELL_TYPE_STRING:
			cellData=col.getStringCellValue();
			System.out.println(col.getCellType());
			break;
		case XSSFCell.CELL_TYPE_NUMERIC:
			col.setCellType(XSSFCell.CELL_TYPE_STRING);
			cellData=col.getStringCellValue();
			System.out.println(col.getCellType());
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			cellData=String.valueOf(col.getBooleanCellValue());
			System.out.println(col.getCellType());
			break;
		case XSSFCell.CELL_TYPE_BLANK:
			cellData="null";
			System.out.println(col.getCellType());
			break;
		
		}
		fin.close();
		return cellData;
		
	}
	
	
	
	
	public static void writeXLData(String fileName,String sheetName, int rowNo,int colNo, String bzTxt) throws Exception{
		File dataFile1= new File(fileName);
		FileInputStream fin1=new FileInputStream(dataFile1);
		XSSFWorkbook wb1=new XSSFWorkbook(fin1);
		XSSFSheet sh1=wb1.getSheet(sheetName);
		System.out.println(sh1.getFirstRowNum());
		System.out.println(sh1.getSheetName());
		XSSFRow row;
		XSSFCell col;
		row=sh1.createRow(rowNo);
		//System.out.println(row1);
		
		System.out.println("Hello test1 ");
		//System.out.println(row1.toString());
		col=row.createCell(colNo);
		System.out.println("Hello test2 ");
		col.setCellType(XSSFCell.CELL_TYPE_STRING);
		col.setCellValue(bzTxt);
		
		fin1.close();
		
		
		FileOutputStream fout2=new FileOutputStream(dataFile1);
		wb1.write(fout2);
		//fout.close();
		
	}

}
