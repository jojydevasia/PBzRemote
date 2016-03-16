package com.paytm.bus;


import java.io.IOException;
import java.util.ArrayList;
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

public class PageTest {
public static void main(String[] args)throws IOException, InterruptedException {
	
	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	
	//driver.get("https://paytmbeta:P@ytW8eTA@beta1-assets.paytm.com");
	Runtime.getRuntime().exec("D:\\JojyDevasiaFolder\\AutoIT scripts\\HandleAuth.exe");
	driver.get("https://beta1.paytm.com");
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
	//String curDate=driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).getText();
	//String curDate=driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]/div")).getText();
	String curDate1=driver.findElement(By.xpath("//button[@value='Tomorrow']")).getText();
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
	driver.findElement(By.xpath("//table//div[text()='24']")).click();
	//Thread.sleep(10000);
	//driver.findElement(By.xpath("//button[@value='Tomorrow']")).click();
	//driver.findElement(By.xpath(".//*[@id='rechargeServices']/div/div[2]/ul/li[3]/div[2]/button[2]")).click();
	//driver.findElement(By.xpath("//md-select[@id='select_19']")).click();
	driver.findElement(By.cssSelector(".md-select-icon")).click();

	System.out.println("CurDate  :"+curDate1);
	WebElement selPaxNo=driver.findElement(By.xpath("//md-option[2]"));
	selPaxNo.click();driver.findElement(By.xpath("//span[text()='Search Buses']/following::button")).click();
	
	
	//JavascriptExecutor  jse=(JavascriptExecutor) driver;
	//jse.executeScript("arguments[0].click();",selPaxNo);
	
	
	//driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).clear();
	//driver.findElement(By.xpath("//input[@id='P1303769456_submit']")).sendKeys("17 Mar 2016");
     /*
	System.out.println("hello");
	  */
	//ArrayList al=new ArrayList();
	 
	//System.out.println(driver.getWindowHandles());
	//Alert alrt=driver.switchTo().alert();
	//alrt.sendKeys("paytmbeta");
	//Credentials ccr=new Credentials()
	//alrt.authenticateUsing("paytmbeta");
	//driver.switchTo().
	 
	
	 
    Thread.sleep(6000);
	driver.quit();
	
	}
}
