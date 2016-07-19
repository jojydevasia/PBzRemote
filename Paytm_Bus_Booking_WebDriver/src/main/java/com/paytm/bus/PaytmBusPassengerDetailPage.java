package com.paytm.bus;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class PaytmBusPassengerDetailPage {
	
	WebDriver driver;
	String passengerPageTitle=null;
	int i=0;
	public String k;
	By passengerDetailHeaderText=By.cssSelector(".passengerDetails>h1:contains('Passenger')");
	By seatNumHeaderText=By.cssSelector(".seatName");
	By titleListBox=By.xpath("//md-select[@role='combobox' and @aria-label='Title'][("+i+1+")]");  //cssSelector("[aria-label='Title']"/*:nth('"+k+"')*/); 
	By titleMrOption=By.xpath("//md-option/div[text()='Mr']");   //cssSelector("md-option>div:contains(Mr)");
	By titleMsOption=By.xpath("//md-option/div[text()='Ms']");   //cssSelector("md-option>div:contains(Ms)"); 
	By passengerName=By.xpath("//input[@ng-model='seat.name'][("+i+1+")]");  //cssSelector("input[ng-model='seat.name']"/*:nth(0)"*/)
	By passengerAgeListBox=By.xpath("//md-select[@aria-label='Age'][("+i+1+")]");   //cssSelector("md-select[aria-label='Age']"/*:nth(0)"*/)
	By ageOption=By.xpath("//md-option/div[text()='37']"); //cssSelector("md-option>div:contains('37')");
	By contactMobileInputBox=By.cssSelector("input[ng-model='phoneNumber']"); //xpath ( //input[@ng-model='phoneNumber']  )
	By contactEmailInputBox=By.cssSelector("input[ng-model='emailAddress']"); //xpath (//input[@ng-model='emailAddress'] 
	By agreeCheckBox=By.cssSelector("div.md-container"); //xpath( //div[@class='md-container']
	
	By bookingDetailsHeader=By.cssSelector("h1:contains('Booking Details')"); //xpath( //h1[text()='Booking Details'])
	By departureCityName=By.cssSelector("h5:contains('Departure')+p");  //xpath( //li/h5[contains(text(),'Departure')]/following-sibling::p )
	By arrivalCityName=By.cssSelector("h5:contains('Arrival')+p");  //xpath( //li/h5[contains(text(),'Arrival')]/following-sibling::p )
	By operatorName=By.cssSelector("li>div:contains('Bus Operator')+div"); //xpath( //div[text()='Bus Operator']/following-sibling::div )
	By busTypeText=By.cssSelector("li>div:contains('Bus Type')+div"); //xpath( //li/div[text()='Bus Type']/following-sibling::div )
	By boardingTimeText=By.cssSelector("li>div:contains('Boarding Time')+div"); //xpath ( //li/div[text()='Boarding Time']/following-sibling::div )
	By seatNumberText=By.cssSelector("li>div:contains('Seats Number')+div"); // xpath ( //li/div[contains(text(),'Seat')]/following-sibling::div )
	By boardingPointText=By.cssSelector("li>div:contains('Boarding Point')+div");  //xpath ( //li/div[text()='Boarding Point']/following-sibling::div )
	By totalFareText=By.cssSelector("div.left+div"); //xpath( //div[contains(text(),'Total Fare')]/following-sibling::div	 )
	By proceedToPayButton=By.cssSelector("button>span:contains('Proceed to Pay')");  //xpath ( //button/span[contains(text(),'Proceed to Pay')] )
	By cancellationPolicyLink=By.cssSelector("a:contains('Cancellation Policy')");  //xpath ( //a[contains(text(),'Cancellation Policy')] )
	By TnCLink=	By.cssSelector("a:contains('Terms and Conditions')"); //  xpath( //a[contains(text(),'Terms and Conditions')] )
	By promoCodeLink=By.cssSelector("div.'promo'>a:contains('Promo Code')");  //xpath ( //div[@class='promo']/a[contains(text(),'Promo Code')] )
	By promoCodeInputBox=By.cssSelector("input[ng-model='promoCode']"); //xpath ( //input[@ng-model='promoCode'] )
	
	
	
	public PaytmBusPassengerDetailPage(WebDriver driver){
		this.driver=driver;
		passengerPageTitle=getPageTitle();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	
	public String getPassengerDetailHeader(){
		return driver.findElement(passengerDetailHeaderText).getText();
	}
	
	public void setPassengerDetails(int reqSeats){
		for(int i=0;i<reqSeats;i++){
			int k=i+1;
			try{
				String psngrTitle=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Passengers", k,0);
				String psngrName=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Passengers", k,1);
				String psngrAge=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Passengers", k,2);
			driver.findElement(By.xpath("(//md-select[@role='combobox' and @aria-label='Title'])["+k+"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//md-option/div[text()='"+psngrTitle+"']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@ng-model='seat.name'])["+k+"]")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@ng-model='seat.name'])["+k+"]")).sendKeys(psngrName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//md-select[@aria-label='Age'])["+k+"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//md-option/div[text()='"+psngrAge+"']")).click();
			
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,20)","");
			
			Thread.sleep(5000);
			}catch(IOException e1){
				System.out.println("Issue with reading data from source");
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
}