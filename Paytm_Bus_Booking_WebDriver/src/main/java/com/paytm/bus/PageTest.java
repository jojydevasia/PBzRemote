package com.paytm.bus;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PageTest {
public static void main(String[] args)throws IOException, InterruptedException {
	/*URL: beta1.paytm.com
	username: paytmbeta
	password: P@ytW8eTA
	Open Hangout*/
	WebDriver driver= new FirefoxDriver();
	driver.get("http://paytm.com");
	driver.manage().window().maximize();
	
	//driver.get("https://paytmbeta:P@ytW8etA@beta1-assets.paytm.com");
	//Runtime.getRuntime().exec("D:\\JojyDevasiaFolder\\AutoIT scripts\\HandleAuth.exe");

	//driver.get("http://beta1-assets.paytm.com");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//a[@href='/bus-tickets']")).click();
	System.out.println(driver.findElement(By.xpath("//div[@class='box1']")).getText());
	System.out.println("*****************************************************");
	System.out.println(driver.findElement(By.xpath("//label[text()='From (Origin)']")).getText());
	WebElement we=driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input"));
	System.out.println(we);

	
	driver.findElement(By.xpath("//label[text()='From (Origin)']/following-sibling::input")).sendKeys("Bangalore");
	driver.findElement(By.xpath("//label[text()='To (Destination)']/following-sibling::input")).sendKeys("Calicut");
	driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).sendKeys("15 Mar 2016");

	System.out.println("hello");
	  
	//ArrayList al=new ArrayList();
	 
	//System.out.println(driver.getWindowHandles());
	//Alert alrt=driver.switchTo().alert();
	//alrt.sendKeys("paytmbeta");
	//Credentials ccr=new Credentials()
	//alrt.authenticateUsing("paytmbeta");
	//driver.switchTo().
	Thread.sleep(10000);
	driver.quit();
	
	}
}
