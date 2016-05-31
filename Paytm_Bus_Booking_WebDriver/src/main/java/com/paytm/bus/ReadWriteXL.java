package com.paytm.bus;

//EXCEL_UTIL CLASS FOR COMMON UTILS


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteXL {


	public static String readXLData(String fileName,String sheetName,int rowNo, int colNo) throws IOException,InvalidFormatException{

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
			col.setCellType(XSSFCell.CELL_TYPE_STRING);
			cellData=col.getStringCellValue();
			//System.out.println("CellType: "+col.getCellType());
			break;
		case XSSFCell.CELL_TYPE_NUMERIC:
			col.setCellType(XSSFCell.CELL_TYPE_STRING);
			cellData=col.getStringCellValue();
			//System.out.println("CellType: "+col.getCellType());
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			cellData=String.valueOf(col.getBooleanCellValue());
			//System.out.println("CellType: "+col.getCellType());
			break;
		case XSSFCell.CELL_TYPE_BLANK:
			cellData="null";
			//System.out.println("CellType: "+col.getCellType());
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
		XSSFRow row;
		XSSFCell col;
		if(sh1.getRow(rowNo)==null){
			row=sh1.createRow(rowNo);
			col=row.createCell(colNo);
			col.setCellType(XSSFCell.CELL_TYPE_STRING);
			col.setCellValue(bzTxt);

			fin1.close();

			FileOutputStream fout2=new FileOutputStream(dataFile1);
			wb1.write(fout2);
			//fout2.close();
		}else

		row=sh1.getRow(rowNo);
		col=row.createCell(colNo);
		col.setCellType(XSSFCell.CELL_TYPE_STRING);
		col.setCellValue(bzTxt);

		fin1.close();

		FileOutputStream fout2=new FileOutputStream(dataFile1);
		wb1.write(fout2);
		//fout2.close();

	} 
	
	public static  String createFileName(String filePath,String fileName){
		DateFormat df= new SimpleDateFormat("yyyy-MMM-dd_hh:mm:ss:a");
		df.setTimeZone(TimeZone.getTimeZone("IST"));
		String dt=df.format(new Date());
		String dt1=dt.replace("-", "").replace(":", ".");
		//System.out.println("Date =  "+dt1);
		String fileName1=filePath+fileName+dt1+".xlsx";
		return fileName1;
	}
	
	 
	public static void writeNewXLFile( String filePath,String fileName,int noOfCols,String[] colNames) throws Exception{
		
		String fileName1=createFileName(filePath,fileName);
		File dataFile1= new File(fileName1);		
		
		XSSFWorkbook wb1=new XSSFWorkbook();
		
		XSSFCellStyle style1=wb1.createCellStyle();
		style1.setWrapText(true);
		
		XSSFSheet sh1=wb1.createSheet("MismatchDetail");
		sh1.setColumnWidth(1,10000);
		sh1.setColumnWidth(2,20000);
		
		XSSFRow row=sh1.createRow(0);
		
		XSSFFont font1=wb1.createFont();
		font1.setFontName("Calibri");
		font1.setFontHeight(12);
		font1.setBold(true);
		style1.setFont(font1);
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		style1.setFillBackgroundColor(new XSSFColor(new java.awt.Color(255,255,0)));
		style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(0,0,255)));
		style1.setFillPattern(XSSFCellStyle.LEAST_DOTS);
		style1.setBorderBottom((short)1);
		row.setRowStyle(style1);
				
		XSSFCell col;
		
		for(int i=0;i<noOfCols;i++){
			col=row.createCell(i);
			col.setCellStyle(style1);
			String colName=colNames[i];
			col.setCellType(XSSFCell.CELL_TYPE_STRING);
			col.setCellValue(colName);
		}
		
		FileOutputStream fout2=new FileOutputStream(dataFile1);
		wb1.write(fout2);
		
	} 


	public static int getRowCount(String fileName,String sheetName) throws Exception{
		File dataFile=new File(fileName);
		FileInputStream fin=new FileInputStream(dataFile);
		XSSFWorkbook wb= new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum()+1;
		fin.close();
		return rowCount;
	}

	public static int getLastRowNum(String fileName,String sheetName)throws Exception{
		File dataFile=new File(fileName);
		FileInputStream fin=new FileInputStream(dataFile);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheet(sheetName);
		int lastRowNum=sh.getLastRowNum();
		fin.close();
		return lastRowNum;
	}


}
