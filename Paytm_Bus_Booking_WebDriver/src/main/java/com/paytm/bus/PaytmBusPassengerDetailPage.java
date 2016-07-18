package com.paytm.bus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaytmBusPassengerDetailPage {
	
	WebDriver driver;
	String passengerPageTitle;
	
	By passengerDetailHeaderText=By.cssSelector(".passengerDetails>h1:contains('Passenger')");
	By seatNumHeaderText=By.cssSelector(".seatName");
	By titleListBox=By.cssSelector("[aria-label='Title']:nth(0)"); //xpath( (//md-select[@role='combobox' and @aria-label='Title'])[1] )
	By titleMrOption=By.cssSelector("md-option>div:contains(Mr)"); //xpath(  //md-option/div[text()='Mr'] )  
	By titleMsOption=By.cssSelector("md-option>div:contains(Ms)"); //xpath( //md-option/div[text()='Ms'])
	By passengerName=By.cssSelector("input[ng-model='seat.name']:nth(0)");//xpath((//input[@ng-model='seat.name'])[1])
	By passengerAgeListBox=By.cssSelector("md-select[aria-label='Age']:nth(0)");//xpath ( (//md-select[@aria-label='Age'])[1] )
	By ageOption=By.cssSelector("md-option>div:contains('37')"); //xpath ( //md-option/div[text()='37']  )
	By contactMobileInputBox=By.cssSelector("input[ng-model='phoneNumber']"); //xpath ( //input[@ng-model='phoneNumber']  )
	By contactEmailInputBox=By.cssSelector("input[ng-model='emailAddress']"); //xpath (//input[@ng-model='emailAddress'] 
	By agreeCheckBox=By.cssSelector("div.md-container"); //xpath( //div[@class='md-container']
	
	By bookingDetailsHeader=By.cssSelector("h1:contains('Booking Details')"); //xpath( //h1[text()='Booking Details'])
	By departureCityName=By.cssSelector("h5:contains('Departure')+p");  //xpath( //li/h5[contains(text(),'Departure')]/following-sibling::p )
	By arrivalCityName=By.cssSelector("h5:contains('Arrival')+p");  //xpath( //li/h5[contains(text(),'Arrival')]/following-sibling::p )
	By operatorName=By.cssSelector("li>div:contains('Bus Operator')+div"); //xpath( //div[text()='Bus Operator']/following-sibling::div )
	By busTypeText=By.cssSelector("li>div:contains('Bus Type')+div"); //xpath( //li/div[text()='Bus Type']/following-sibling::div )
		
	
}
