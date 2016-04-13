package com.paytm.bus;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;



public class PageTest2 {
	static WebDriver driver= new FirefoxDriver();
	
	public static String getTestData() throws IOException{
		FileInputStream fis=new FileInputStream("D:\\TestDataFiles\\PTMBz Test Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Login");
		XSSFRow row;
		for(int i=1;i<sh.getLastRowNum();i++){
			row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				XSSFCell col=row.getCell(j);
			}
			
		}
			
		    
		
		
	}

	
	public static void main(String[] args) throws InterruptedException{
		driver.get("http://paytm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Log In
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();//Log In link in home page.
		Thread.sleep(3000);
	    driver.switchTo().frame(2);
		driver.findElement(By.xpath("//md-input-container[1]/input")).sendKeys("..........");
		driver.findElement(By.xpath("//md-input-container[2]/input")).sendKeys(",....");
		driver.findElement(By.xpath("//button/span[normalize-space(text()='Secure Login')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//md-content//input[@id='input_2']")).sendKeys("OTP");///OTP input  box
		System.out.println(driver.findElement(By.xpath("//md-content/button/span[text()='VERIFY']")).getText());
		driver.findElement(By.xpath("//md-content/button/span[text()='VERIFY']")).click(); //button	
		driver.findElement(By.xpath("//a[starts-with(text(),'Forgot Password')]"));//forgot password link
		driver.findElement(By.xpath("//li/span[starts-with(text(),'We will send a link on your')]"));//forgot password UI message
		driver.findElement(By.xpath("//label[starts-with(text(),'Enter your Mobile')]//following-sibling::input"));//mobile number field for forgot password
		driver.findElement(By.xpath("//span[text()='CANCEL']/ancestor::a"));//cancel button in forgot pwd UI.
		driver.findElement(By.xpath("//span[text()='RESET PASSWORD']/ancestor::button"));//Reset pwd button
		driver.findElement(By.xpath("//md-dialog/button[@ng-click='closeModal()']"));// login frame close button
		//driver.findElement
		
		//finally{
			//driver.quit();
		//}
	}

}
