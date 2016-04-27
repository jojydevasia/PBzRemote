package com.paytm.bus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class TestAC {
	static WebDriver driver;
	//static String origCity;
	//static String destCity;
	
	/*public static void selectTravelDate(String day,String monthYear) throws InterruptedException{
		
		String trvMonth_Year=driver.findElement(By.xpath("//div[@class='picker__header']")).getText();
		WebElement nxtButton=driver.findElement(By.xpath("//div[contains(@class,'picker__nav--next') and @data-nav='1']"));

		if(trvMonth_Year.contains(monthYear)){
			
			List<WebElement> availableDays=driver.findElements(By.xpath("//table//div[contains(normalize-space(@class),'infocus') and not(@aria-disabled='true')]"));
			for(WebElement i:availableDays){
				System.out.println(i.getText());
				if (i.getText().contains(day)){
					i.click();
					return;
				}
			}

		}else{
			nxtButton.click();
			Thread.sleep(2000);
			selectTravelDate(day,monthYear);
		}
	}
	
	*/public static void main(String[] args) throws InterruptedException{
		driver=new FirefoxDriver();
		driver.get("https://paytm.com/bus-tickets/search/Bangalore/Chennai/2016-05-04/1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		/*driver.findElement(By.xpath("//a[@href='/bus-tickets']")).click();
		
		try {
			origCity=ReadXL.getTestData("Cities",1,0);
			destCity=ReadXL.getTestData("Cities",1,1);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Data Format Issue. Please check the data sheet");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Issue. Please check  the file and path");
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input")).sendKeys(origCity);
		driver.findElement(By.xpath("//ul/li[1]/md-input-container")).click();
		driver.findElement(By.xpath("//label[text()='To (Destination)']/following-sibling::input")).sendKeys(destCity);
		driver.findElement(By.xpath("//ul/li[2]/md-input-container")).click();
		driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
		Thread.sleep(8000);
		try {
			selectTravelDate("4","May2016");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector(".md-select-icon")).click();
		WebElement selPaxNo=driver.findElement(By.xpath("//md-option[1]"));//[1] here, denotes the no of passengers
		selPaxNo.click();
		driver.findElement(By.xpath("//span[text()='Search Buses']")).click();
		Thread.sleep(3000);
		System.out.println("Buslist UI");
		System.out.println(driver.getTitle());
		*/
		driver.findElement(By.xpath("//div/span[contains(text(),'With Air Conditioner')]")).click();
		Thread.sleep(2000);
		List<WebElement>  tripRecord=driver.findElements(By.xpath("//div[@class='bus-ticket-container']"));
		System.out.println("[[Total # of records: " + tripRecord.size()+"]]\n-------------------\n\n");
		
		for(int i=1;i<tripRecord.size();i++){
			WebElement tripHeader=driver.findElement(By.xpath("(//div[@class='headTop']/span)["+i+"]"));
			Thread.sleep(2000);
			String tripTitle=(tripHeader.getText()).toLowerCase();
			if(tripTitle.contains("non-ac")||tripTitle.contains("non -ac")||tripTitle.contains("non ac")||tripTitle.contains("non-a/c")
					||tripTitle.contains("non a/c")||tripTitle.contains("non-a-c")||tripTitle.contains("non a-c")||tripTitle.contains("non.a/c")
					||tripTitle.contains("non.a-c")||tripTitle.contains("non.ac")||tripTitle.contains("non a.c")||tripTitle.contains("non-a.c")
					||tripTitle.contains("non_a/c")||tripTitle.contains("non_ac")||tripTitle.contains("non_a.c")||tripTitle.contains("non_a-c")){
		    	System.out.println("Bus Record # : "+i);
		    	System.out.println("This trip has a detail mismatch\n ");
		    	//System.out.println(tripTitle+"\n===================");
		    	System.out.println((driver.findElement(By.xpath("(//div[@class='bus-ticket-container'])["+i+"]")).getText()));
		    	System.out.println("\n______________________________________\n");
		    }else{
		    	System.out.println("Bus Record# : "+ i);
		    	System.out.println("Details are correct\n___________________________________\n");
		    }
			
		} 
		System.out.println("\n\n________________\nIteration completed");
		
		//WebElement tripHeader=driver.findElement(By.xpath("(//div[@class='headTop']/span)[1]"));
		//String tripTitle=tripHeader.getText();
		//System.out.println(tripTitle);
		//System.out.println("TestEnd");
	}
	
}
