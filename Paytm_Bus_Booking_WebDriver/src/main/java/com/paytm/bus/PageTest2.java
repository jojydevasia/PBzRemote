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

	public static void selectTravelDate(String day,String month,String year) throws InterruptedException{
		//WebElement trvDay=driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]"));
		WebElement trvMonth=driver.findElement(By.xpath("//div[@class='picker__month']"));
		WebElement trvYear=driver.findElement(By.xpath("//div[@class='picker__year']"));
		WebElement nxtButton=driver.findElement(By.xpath("//div[@class='picker__nav--next' and @data-nav='1']"));

		if(trvYear.getText().contains(year)){
			if(trvMonth.getText().contains(month)){

				List<WebElement> bookingDays=driver.findElements(By.xpath("//table//div[contains(normalize-space(@class),'infocus') and not(@aria-disabled='true')]"));

				
				for(WebElement i:bookingDays){
					System.out.println(i.getText());
					if (i.getText().contains(day)){
						i.click();
						
					}

				}
				
			} else {
				nxtButton.click();
				Thread.sleep(2000);
				selectTravelDate(day,month,year);
			}


		}

	}

	public static void main(String[] args) throws InterruptedException{
		driver.get("http://paytm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Date date= new Date();
		System.out.println(date);


		driver.findElement(By.xpath("//a[text()='Bus Tickets']")).click();
		
		Actions act= new Actions(driver);
		act.contextClick().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
		try {
			selectTravelDate("4","June","2016");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			//driver.quit();
		}
	}

}
