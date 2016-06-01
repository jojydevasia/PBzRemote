package com.paytm.bus;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	public static void main(String[] args) throws Exception{
		
		/*String[] colNames={"S.No","Route ","Details"};
		ReadWriteXL.writeNewXLFile( "D:\\TestDataFiles\\","acDetailMismatch",3,colNames);
		System.out.println("done: file created");  (This block creates a new file by calling t*he method in ReadWriteXL.java  */
		System.setProperty("webdriver.chrome.driver", "D:\\JojyDevasiaFolder\\Automation sw Lib\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://paytm.com/bus-tickets");
		System.out.println(driver.getTitle());
		//System.out.println(driver.findElement(By.xpath("//i[contains(@ng-click,'swapStartDestination')]")).getTagName());
		//System.out.println(driver.findElement(By.xpath("//div[contains(@ng-click,'clearOriginSearch')]//i")));
		//System.out.println(driver.findElement(By.xpath("//div[contains(@ng-click,'clearDestinationSearch')]//i")));
		//System.out.println(driver.findElement(By.xpath("//ul[1]/li[contains(@ng-repeat,'routeDetail in topRoute')]/a")).getText());
		//System.out.println(driver.findElement(By.xpath("//ul[1]/li[contains(@ng-repeat,'routeDetail in topRoute')]//button")).getText());
		//driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@class='picker__header']")).getText());		
		 PaytmBusHomePage pbhp=new PaytmBusHomePage(driver);
		 //pbhp.openTravelCalendar();
		 //pbhp.selectTravelDate("29", "July2016");
		 //System.out.println((driver.findElement(By.xpath("//div[@class='picker__box']"))).isDisplayed());
		 pbhp.clickTopRouteRecord("Bangalore to Chennai");
	}
	
	

}
