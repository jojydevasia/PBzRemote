package com.paytm.bus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScroll {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver= new FirefoxDriver();
		
		driver.get("http://www.wikipedia.org");
		JavascriptExecutor je=(JavascriptExecutor)driver;
		for(int i=0;i<10;i++){
		je.executeScript("scrollBy(0,2500)");
		Thread.sleep(2000);
		je.executeScript("scrollBy(0,-2500)");
		Thread.sleep(2000);
		}
	}

}
