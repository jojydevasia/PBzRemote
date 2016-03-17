package com.paytm.bus;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.Credentials;
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
public static void main(String[] args)throws IOException, InterruptedException {
	
	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://paytm.com");
	

	//driver.get("https://paytmbeta:P@ytW8eTA@beta1-assets.paytm.com");
	//Runtime.getRuntime().exec("D:\\JojyDevasiaFolder\\AutoIT scripts\\HandleAuth.exe");
	//driver.get("https://beta1.paytm.com");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	//Thread.sleep(5000);
		
	driver.findElement(By.xpath("//a[@href='/bus-tickets']")).click();
	System.out.println(driver.findElement(By.xpath("//div[@class='box1']")).getText());
	System.out.println("*****************************************************");
	System.out.println(driver.findElement(By.xpath("//label[text()='From (Origin)']")).getText());
	WebElement we=driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input"));
	System.out.println(we);

	
	driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input")).sendKeys("Bangalore");
	//clicking on the container to confirm destination
	driver.findElement(By.xpath("//ul/li[1]/md-input-container")).click();

	driver.findElement(By.xpath("//label[text()='To (Destination)']/following-sibling::input")).sendKeys("Goa");
	//clicking on the container to confirm destination
	driver.findElement(By.xpath("//ul/li[2]/md-input-container")).click();
	boolean enStatus=driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).isEnabled();
	System.out.println("EnStatus: "+enStatus);
	
	String curDate1=driver.findElement(By.xpath("//button[@value='Tomorrow']")).getText();
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
	driver.findElement(By.xpath("//table//div[text()='22']")).click();
	
	//driver.findElement(By.xpath("//button[@value='Tomorrow']")).click();
	
	driver.findElement(By.cssSelector(".md-select-icon")).click();

	System.out.println("CurDate  :"+curDate1);
	WebElement selPaxNo=driver.findElement(By.xpath("//md-option[1]"));
	selPaxNo.click();driver.findElement(By.xpath("//span[text()='Search Buses']")).click();
	
	//Next Page>******************************
	
	System.out.println("Bus List UI\n*******************");
	String busListMsg=driver.findElement(By.className("detaShow")).getText();
	System.out.println(busListMsg+"\n");
	if(busListMsg.toLowerCase().contains("bangalore to goa")){
		System.out.println("++++++++ List is for Bangalore to Goa. Go Ahead+++++++++");
	}else{
		System.out.println("----------Incorrect list. Test Failed-----------");
	}
	//Assert.assertTrue(busListMsg.contains("Bangalore to goa"), "Wrong route in response. Test Failed");
	String busDetails=driver.findElement(By.xpath("//div[@class='bus-ticket-container'][2]")).getText();
	System.out.println(busDetails);
	driver.findElement(By.xpath("//button/span[text()='Select Seats'][1]")).click();
	//  in seat selection panel
	List<WebElement> avlSeats=driver.findElements(By.cssSelector(".square.available"));
	if(avlSeats.size()>=1){
		avlSeats.get(1).click();
	}else{
		driver.findElement(By.xpath("//button[@ng-click='cancel()']")).click();
		System.err.println("No Seats Available");
	 }
	
	String selSeats=driver.findElement(By.xpath("//div[contains(text(),'Selected Seats')]/following-sibling::span")).getText();
	System.out.println("Seats Selected"+selSeats);
	
	driver.findElement(By.xpath("//md-select[@ng-model='boardingPoint']")).click();
	
	//System.out.println(driver.getPageSource());
	
	
	//driver.findElement(By.cssSelector("//div[contains(text(),'PM') OR contains(text(),'AM')]")).click();	
	System.out.println(driver.findElement(By.className("md-text")).getText()); 
	List<WebElement> bordPoint=driver.findElements(By.className("md-text"));
	bordPoint.get(2).click();
	driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to pay')]	")).click();

	
	Thread.sleep(10000);
	
	
	
	
	
	
	//JavascriptExecutor  jse=(JavascriptExecutor) driver;
	//jse.executeScript("arguments[0].click();",selPaxNo);
		 
    Thread.sleep(6000);
	driver.quit();
	
	}
}
