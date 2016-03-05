package com.paytm.bus;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PageTest {
public static void main(String[] args){
	
	WebDriver driver= new FirefoxDriver();
	driver.navigate().to("https://beta1.paytm.com");
	}
}
