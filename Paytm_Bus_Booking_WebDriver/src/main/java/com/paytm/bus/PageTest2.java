package com.paytm.bus;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class PageTest2 {
	static WebDriver driver= new FirefoxDriver();

	
	public static void main(String[] args) throws InterruptedException{
		driver.get("http://paytm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
		Thread.sleep(3000);
		//driver.switchTo().frame
		driver.findElement(By.xpath("//md-input-container[1]/input")).sendKeys("9448879224");
		driver.findElement(By.xpath("//md-input-container[2]/input")).sendKeys("$$@P0lleH");
		driver.findElement(By.xpath("//button/span[normalize-space(text()='Secure Login')]")).click();

		//finally{
			//driver.quit();
		//}
	}

}
