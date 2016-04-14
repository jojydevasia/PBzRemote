package com.paytm.bus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {


	public static String getTestData(String sheetName,int rowNo, int colNo) throws IOException,InvalidFormatException{

		File dataFile=new File("D:\\TestDataFiles\\PTMBz Test Data.xlsx");
		FileInputStream fis= new FileInputStream(dataFile);

		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheetName);
		XSSFRow row;
		XSSFCell col;
		String cellData = null;

		row=sh.getRow(rowNo);
		col=row.getCell(colNo);
		switch(col.getCellType()){
		case XSSFCell.CELL_TYPE_STRING:
			cellData=col.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_NUMERIC:
			col.setCellType(XSSFCell.CELL_TYPE_STRING);
			//cellData=String.valueOf(new Double(col.getNumericCellValue()));
			cellData=col.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			cellData=String.valueOf(col.getBooleanCellValue());
			break;
		case XSSFCell.CELL_TYPE_BLANK:
			cellData="null";
			break;
		}
		
		return cellData;
		}

	

/*	public static void main(String[] args){
		try {
			String data=getTestData("Login",2,1);
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvalidFormatException i){
			i.printStackTrace();
		}


	}*/



}
