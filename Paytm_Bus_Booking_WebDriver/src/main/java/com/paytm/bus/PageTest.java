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
	static WebDriver driver= new FirefoxDriver();
	
public static void selectTravelDate(String day,String month,String year) throws InterruptedException{
	WebElement trvDay=driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]"));
	WebElement trvMonth=driver.findElement(By.xpath("//div[@class='picker__month']"));
	WebElement trvYear=driver.findElement(By.xpath("//div[@class='picker__year']"));
	WebElement nxtButton=driver.findElement(By.xpath("//div[@class='picker__nav--next' and @data-nav='1']"));
	
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
	if(trvYear.getText().contains(year)){
		if(trvMonth.getText().contains(month)){
			
			driver.findElement(By.xpath("//table//div[text()='"+day+"' and contains((@class),'infocus')]")).click();
		} else {
			nxtButton.click();
			Thread.sleep(2000);
			
		}
		
	}

}
	
public static void main(String[] args)throws IOException, InterruptedException {
	
	
	driver.manage().window().maximize();
	

	//driver.get("https://paytmbeta:P@ytW8eTA@beta1-assets.paytm.com");
	//Runtime.getRuntime().exec("D:\\JojyDevasiaFolder\\AutoIT scripts\\HandleAuth.exe");
	//driver.get("https://beta1.paytm.com");
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	
	//Thread.sleep(5000);
		
		 
   	driver.get("http://paytm.com");

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
	
	/*Thread.sleep(3000);
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
	driver.findElement(By.xpath("//div[@class='picker__month']"));
	driver.findElement(By.xpath("//div[@class='picker__year']"));
	driver.findElement(By.xpath("//div[@class='picker__nav--next' and @data-nav='1']")); */

	
	selectTravelDate("12","April","2016");
	//driver.findElement(By.xpath("//table//div[text()='30' and contains((@class),'infocus')]")).click();
	
	
	
	//driver.findElement(By.xpath("//button[@value='Tomorrow']")).click();
	
	driver.findElement(By.cssSelector(".md-select-icon")).click();

	System.out.println("CurDate  :"+curDate1);
	WebElement selPaxNo=driver.findElement(By.xpath("//md-option[1]"));
	selPaxNo.click();driver.findElement(By.xpath("//span[text()='Search Buses']")).click();  
	
	//Next Page>******************************
	//driver.get("https://paytm.com/bus-tickets/search/bangalore/goa/2016-03-27/1");
	
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
	int noBrdPoint=bordPoint.size();
	bordPoint.get(2).click();
	driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to pay')]	")).click();
	Thread.sleep(10000);
	driver.switchTo().frame(1);
	String fTitl=driver.getTitle();
	System.out.println("FrameTitle : "+fTitl);
	System.out.println("Text 4 Frame: ");
	System.out.println(driver.findElement(By.xpath("//*[@id='wallet-container-new']/ul")).getText());
	driver.findElement(By.xpath("//input[@id='input_0']")).sendKeys("9448879224");
	driver.findElement(By.cssSelector("#input_1")).sendKeys("$$@P0lleH");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	
	Thread.sleep(60000);
	
	
	
	
	
	
	//JavascriptExecutor  jse=(JavascriptExecutor) driver;
	//jse.executeScript("arguments[0].click();",selPaxNo);
		 
    Thread.sleep(6000);
	driver.quit();
	
	}
}
