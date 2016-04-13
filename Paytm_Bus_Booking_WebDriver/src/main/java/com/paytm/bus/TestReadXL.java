package com.paytm.bus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReadXL {

	
	/*public static String getTestData() throws IOException{
		FileInputStream fis;
		fis = new FileInputStream("D:\\TestDataFiles\\PTMBz Test Data.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Login");
		XSSFRow row;
		XSSFCell col;
		String cellData;
		System.out.println("Row : " + sh.getLastRowNum());
		for(int i=1;i<sh.getLastRowNum();i++){
			row=sh.getRow(i);
			System.out.println("Col : " + row.getLastCellNum() );
			for(int j=0;j<row.getLastCellNum();j++){
				col=row.getCell(j);
				cellData=col.getRawValue();
				System.out.println(cellData);
				return cellData;
			}
			
		}
		
		
	}*/
	
	public static void main(String[] args) throws IOException{
		
			FileInputStream fis;
			try {
				fis = new FileInputStream("D:\\TestDataFiles\\PTMBz Test Data.xlsx");
			
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("Login");
			XSSFRow row;
			XSSFCell col;
			String cellData;
			System.out.println("Rows : " + sh.getLastRowNum());
			
			for(int i=1;i<sh.getLastRowNum()+1;i++){
				
				row=sh.getRow(i);
				System.out.println("Cols : " + (row.getLastCellNum()) );
				for(int j=0;j<row.getLastCellNum();j++){
					//System.out.println("Cols : " + (row.getLastCellNum()+1) );
					col=row.getCell(j);
					//cellData=col.getRawValue();
					//System.out.println("CellData : "+cellData);
					switch(col.getCellType()){
					case XSSFCell.CELL_TYPE_STRING:
						cellData=col.getStringCellValue();
						System.out.println("CellData : "+cellData);
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						cellData=String.valueOf(new Double(col.getNumericCellValue()));
						System.out.println("CellData : "+cellData);
					    break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						cellData=String.valueOf(col.getBooleanCellValue());
						System.out.println("CellData : "+cellData);
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						cellData="  ";
						System.out.println("CellData : "+cellData);
						break;
					}
					
					
				
			}
		}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		

}
