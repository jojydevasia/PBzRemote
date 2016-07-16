package com.paytm.bus;

//DUMMY INTERMEDIATE CLASS. DO NOT FINALIZE


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PageTest {
	static WebDriver driver= new FirefoxDriver();
	
	public static void selectTravelDate(String day,String monthYear) throws InterruptedException{
				
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

	
public static void main(String[] args)throws IOException, InterruptedException {
	try{
		
	String uid=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Login", 1,0);
	String pwd=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Login", 1,1);
	driver.manage().window().maximize();
	/*//The following block is just for staging environment
	//driver.get("https://paytmbeta:*********@beta1-assets.paytm.com");
	//Runtime.getRuntime().exec("D:\\JojyDevasiaFolder\\AutoIT scripts\\HandleAuth.exe");
	//driver.get("https://beta1.paytm.com");   */
	
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	driver.get("http://paytm.com");
	driver.findElement(By.xpath("//a[@href='/bus-tickets']")).click();
	//System.out.println(driver.findElement(By.xpath("//label[text()='From (Origin)']")).getText());
	//WebElement we=driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input"));
	//System.out.println(we);
	driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input")).sendKeys("Bangalore");
	//clicking on the container to confirm destination
	driver.findElement(By.xpath("//ul/li[1]/md-input-container")).click();
	driver.findElement(By.xpath("//label[text()='To (Destination)']/following-sibling::input")).sendKeys("Goa");
	//clicking on the container to confirm destination
	driver.findElement(By.xpath("//ul/li[2]/md-input-container")).click();
	//boolean enStatus=driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).isEnabled();
	//System.out.println("EnStatus: "+enStatus);
	//String curDate1=driver.findElement(By.xpath("//button[@value='Tomorrow']")).getText();
	Thread.sleep(5000);
	/*
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
	driver.findElement(By.xpath("//div[@class='picker__month']"));
	driver.findElement(By.xpath("//div[@class='picker__year']"));
	driver.findElement(By.xpath("//div[@class='picker__nav--next' and @data-nav='1']")); */
	///clicking on calendar obj
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
	//calling date selection method
	selectTravelDate("4","May2016");
	///use the following in order too select today or tomorrow.
	//driver.findElement(By.xpath("//button[@value='Today']")).click();
	//driver.findElement(By.xpath("//button[@value='Tomorrow']")).click();
	//to select no of seats
	driver.findElement(By.cssSelector(".md-select-icon")).click();
	WebElement selPaxNo=driver.findElement(By.xpath("//md-option[1]"));//[1] here, denotes the no of passengers
	selPaxNo.click();
	driver.findElement(By.xpath("//span[text()='Search Buses']")).click();  
	
	//Next Page>******************************
	//driver.get("https://paytm.com/bus-tickets/search/bangalore/goa/2016-04-27/1");
	
	String busListMsg=driver.findElement(By.className("detaShow")).getText(); //Result header
	
	/*System.out.println(busListMsg+"\n");
	if(busListMsg.toLowerCase().contains("bangalore to goa")){
		System.out.println("++++++++ List is for Bangalore to Goa. Go Ahead+++++++++");
	}else{
		System.out.println("----------Incorrect list. Test Failed-----------");
	}
	//Assert.assertTrue(busListMsg.contains("Bangalore to goa"), "Wrong route in response. Test Failed");
	String busDetails=driver.findElement(By.xpath("//div[@class='bus-ticket-container'][2]")).getText();
	System.out.println(busDetails); */
	List<WebElement> busRecord=driver.findElements(By.xpath("//div[@ng-show='bus.isBusShown'  and @aria-hidden='false']"));
	
	for(int j=1;j<=busRecord.size();j++){
		String seatMsg=(busRecord.get(j).findElement(By.className("seatsAvailable"))).getText();
		String msgSplit[]=seatMsg.split(":");
		int numSeatAvl=Integer.parseInt(msgSplit[1].trim());
		if(numSeatAvl>0){
			driver.findElement(By.xpath("//button/span[text()='Select Seats'][1]")).click();
		//  in seat selection panel
			List<WebElement> avlSeats=driver.findElements(By.xpath("//div[@class='square2 available' or @class='square available']"));
			if(avlSeats.size()>=1){
				avlSeats.get(1).click();
				//printing the selected seat
				String selSeats=driver.findElement(By.xpath("//div[contains(text(),'Selected Seats')]/following-sibling::span")).getText();
				System.out.println("Seats Selected:  "+selSeats);
				//To select the boarding point open the list
				driver.findElement(By.xpath("//md-select[@ng-model='boardingPoint']")).click();
				//print content in boarding-point list
				System.out.println(driver.findElement(By.className("md-text")).getText()); 
				//getContents of list
				List<WebElement> bordPoint=driver.findElements(By.className("md-text"));
				int noBrdPoint=bordPoint.size();
				bordPoint.get(2).click();
				driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to pay')]	")).click();
				break;
			}else{
				
				driver.findElement(By.xpath("//button[@ng-click='cancel()']")).click();
				
				System.err.println("No Seats Available");
			 }
		}
	}
	
	
	Thread.sleep(10000);
	driver.switchTo().frame(1);
	String fTitl=driver.getTitle();
	System.out.println("FrameTitle : "+fTitl);
	System.out.println("Text 4 Frame: ");
	System.out.println(driver.findElement(By.xpath("//*[@id='wallet-container-new']/ul")).getText());
	driver.findElement(By.xpath("//input[@id='input_0']")).sendKeys(uid);
	driver.findElement(By.cssSelector("#input_1")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	
	Thread.sleep(60000);
	
	
	
	
	
	
	//JavascriptExecutor  jse=(JavascriptExecutor) driver;
	//jse.executeScript("arguments[0].click();",selPaxNo);
		 
    Thread.sleep(6000);
	driver.quit();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	}
}
