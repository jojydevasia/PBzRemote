package com.paytm.bus;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


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
	
	By bookingDetailsHeader=By.cssSelector("div.bookingDetails>div.Detailscart>h1");    //xpath( //h1[text()='Booking Details'])
	By departureCityName=By.xpath("//li/h5[contains(text(),'Departure')]/following-sibling::p");     // cssSelector("h5:contains('Departure')+p");  
	By arrivalCityName=By.xpath("//li/h5[contains(text(),'Arrival')]/following-sibling::p");      // cssSelector("h5:contains('Arrival')+p");  
	By operatorName=By.xpath("//div[text()='Bus Operator']/following-sibling::div");     //cssSelector("li>div:contains('Bus Operator')+div");
	By busTypeText=By.xpath("//li/div[text()='Bus Type']/following-sibling::div");     //cssSelector("li>div:contains('Bus Type')+div"); 
	By boardingTimeText=By.xpath("//li/div[text()='Boarding Time']/following-sibling::div");   //cssSelector("li>div:contains('Boarding Time')+div");
	By seatNumberText=By.xpath("//li/div[contains(text(),'Seat')]/following-sibling::div");   //cssSelector("li>div:contains('Seats Number')+div");
	By boardingPointText=By.xpath ("//li/div[text()='Boarding Point']/following-sibling::div");   //cssSelector("li>div:contains('Boarding Point')+div");
	By totalFareText=By.xpath("//div[contains(text(),'Total Fare')]/following-sibling::div");   //cssSelector("div.left+div"); 
	By proceedToPayButton=By.xpath("//button/span[contains(text(),'Proceed to Pay')]");   //cssSelector("button>span:contains('Proceed to Pay')");
	By cancellationPolicyLink=By.xpath("//a[contains(text(),'Cancellation Policy')]");   //cssSelector("a:contains('Cancellation Policy')");  
	By termsLink=	By.xpath("//a[contains(text(),'Terms and Conditions')]");    //cssSelector("a:contains('Terms and Conditions')"); //  
	By promoCodeLink=By.xpath("//div[@class='promo']/a[contains(text(),'Promo Code')]");   //cssSelector("div.'promo'>a:contains('Promo Code')");  
	By promoCodeInputBox=By.xpath("//input[@ng-model='promoCode']");   //cssSelector("input[ng-model='promoCode']"); 
	
	
	
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
				
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,20)","");
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//md-select[@role='combobox' and @aria-label='Title'])["+k+"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//md-option/div[text()='"+psngrTitle+"']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//input[@ng-model='seat.name'])["+k+"]")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//input[@ng-model='seat.name'])["+k+"]")).sendKeys(psngrName);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//md-select[@aria-label='Age'])["+k+"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//md-option/div[text()='"+psngrAge+"']")).click();
				
				Thread.sleep(3000);
			
			}catch(IOException e1){
				System.out.println("Issue with reading data from source");
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	
	public String getContactMobileNum(){
		return driver.findElement(contactMobileInputBox).getText();
	}
	
	public void setContactMobileNum(String mobileNum){
		driver.findElement(contactMobileInputBox).clear();
		driver.findElement(contactMobileInputBox).sendKeys(mobileNum);
	}
	
	public String getContactEmail(){
		return driver.findElement(contactEmailInputBox).getText();
	}
	
	public void setContactEmail(String emailId){
		driver.findElement(contactEmailInputBox).clear();
		driver.findElement(contactEmailInputBox).sendKeys(emailId);
	}
	
	public void clickAgreeCheckBox(){
		driver.findElement(agreeCheckBox).click();
	}
	
	public String getBookingDetailsHeader(){
		return driver.findElement(bookingDetailsHeader).getText();
	}
	
	public String getDepartureCityName(){
		return driver.findElement(departureCityName).getText();
	}
	
	public String getArrivalCityName(){
		return driver.findElement(arrivalCityName).getText();
	}
	
	public String getOperatorName(){
		return driver.findElement(operatorName).getText();
	}
	
	public String getBusType(){
		return driver.findElement(busTypeText).getText();
	}
	
	public String getBoardingTime(){
		return driver.findElement(boardingTimeText).getText();
	}
	
	public String[] getSeatNumbers(){
		String seatText=driver.findElement(seatNumberText).getText();
		return seatText.split(",");
	}
	
	public String getBoardingPoint(){
		return driver.findElement(boardingPointText).getText();
	}
	
	public int getTotalFare(){
		String fareText=driver.findElement(totalFareText).getText();
		String[] temp=fareText.split("Rs ");
		String temp1=(temp[1].trim()).replace(",","");
		return Integer.parseInt(temp1);
	}
	
	public int getFareOnPayButton(){
		String fareText=driver.findElement(proceedToPayButton).getText();
		String[] temp=fareText.split("Rs ");
		String temp1=(temp[1].trim()).replace(",","");
		return Integer.parseInt(temp1);
	}
	
	public void clickProceedToPayButton(){
		driver.findElement(proceedToPayButton);
	}
	
	public void readCancellationPolicy(){
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(cancellationPolicyLink)).build().perform();
	}
	
	public void clickTnCLink(){
		driver.findElement(termsLink).click();
	}
	
	public void enterPromoCode(String promoCode) throws InterruptedException{
		driver.findElement(promoCodeLink).click();
		Thread.sleep(2000);
		driver.findElement(promoCodeInputBox).sendKeys(promoCode);
	}
	
}