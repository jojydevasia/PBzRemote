package com.paytm.bus;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "D:\\JojyDevasiaFolder\\Automation sw Lib\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.myntra.com");
	}
	
	

}
