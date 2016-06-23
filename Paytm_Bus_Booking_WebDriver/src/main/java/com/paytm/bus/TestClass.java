package com.paytm.bus;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
		
		
		driver.get("https://paytm.com/bus-tickets/search/Chennai/Kozhikode/2016-06-29");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		//System.out.println(driver.findElement(By.xpath("//i[contains(@ng-click,'swapStartDestination')]")).getTagName());
		//System.out.println(driver.findElement(By.xpath("//div[contains(@ng-click,'clearOriginSearch')]//i")));
		//System.out.println(driver.findElement(By.xpath("//div[contains(@ng-click,'clearDestinationSearch')]//i")));
		//System.out.println(driver.findElement(By.xpath("//ul[1]/li[contains(@ng-repeat,'routeDetail in topRoute')]/a")).getText());
		//System.out.println(driver.findElement(By.xpath("//ul[1]/li[contains(@ng-repeat,'routeDetail in topRoute')]//button")).getText());
		//driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@class='picker__header']")).getText());		
		 //PaytmBusHomePage pbhp=new PaytmBusHomePage(driver);
		//pbhp.openTravelCalendar();
		//pbhp.selectTravelDate("29", "July2016");
		//System.out.println((driver.findElement(By.xpath("//div[@class='picker__box']"))).isDisplayed());
		// pbhp.clickTopRouteRecord("Hyderabad to Guntur");
		 
		//pbhp.clickTopRouteBookButton("Chennai to Bangalore");
		//List< String> x=pbhp.getTopRouteRecordText();
		//for(String s:x){
		//System.out.println("\n"+s);
		//}
		 
		 PaytmBusListPage pbp=new PaytmBusListPage(driver);
		 
		 //System.out.println(driver.findElement(pbp.refineFilterChkBox).getText()+"\n==============\n");
		 //driver.findElement(pbp.refineFilterChkBox).click();
		 //System.out.println(driver.findElement(pbp.clrOneFilter).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.clrAllFilterButton).getText()+"\n==============\n");
		 //driver.findElement(pbp.clrOneFilter).click();
		 //Thread.sleep(2000);
		 //System.out.println(driver.findElement(pbp.modifySearchButton).getText()+"\n==============\n");
		 //driver.findElement(pbp.modifySearchButton).click();
		 //Thread.sleep(2000);
		 //System.out.println(driver.findElement(pbp.modifySearchButton).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.newOrigin).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.newDestination).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.newTravelDate).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.modifySearchCloseBtn)+"\n===========\n");
		 //Thread.sleep(3000);
		// driver.findElement(pbp.modifySearchCloseBtn).click();
		// System.out.println(driver.findElement(pbp.minPriceSlider)+"\n===========\n");
		// System.out.println(driver.findElement(pbp.maxPriceSlider)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.minTimeSlider)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.maxTimeSlider)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.boardPointSearchIcon)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.dropPointSearchIcon)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.operatorSearchIcon)+"\n===========\n");
		 
		 pbp.scrolMinPriceSlider();
		 
		 pbp.scrolMaxPriceSlider();
	}
	
	

}
