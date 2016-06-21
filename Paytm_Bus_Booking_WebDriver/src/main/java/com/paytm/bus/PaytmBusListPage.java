package com.paytm.bus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PaytmBusListPage {
	 
	WebDriver driver;
	String PtmBusListPgTitle=null;
	By busListHeader=By.cssSelector(".detaShow");
	By busRecord=By.xpath("//div[@ng-show='bus.isBusShown'  and @aria-hidden='false']");
	By selectSeatButton=By.xpath("//div[@ng-show='bus.isBusShown'  and @aria-hidden='false']//button/span[text()='Select Seats']");
	By priceSort=By.xpath("//a[text()='Price']");
	By durationSort=By.xpath("//a[text()='Duration']");
	By arrivalSort=By.xpath("//a[text()='Arrival']");
	By departureSort=By.xpath("//a[text()='Departure']");
	By clrAllFilterButton=By.xpath("//li/a[text()='Clear All']");
	private String s;
	By clrOneFilter= By.xpath("//i[@class='fa fa-times']/preceding-sibling::a[text()='"+s+"'");
	By newOrigin=By.id("input_1");
	By newDestination=By.id("input_2");
	By newTravelDate=By.id("P1599086016");
	By modifySearchButton=By.xpath("//span[contains(text(),'Search')]/parent::button");
	
	By refineFilterChkBox=By.xpath("//div[@class='md-label']/span[text()='"+s+"'");
	
	By minPriceSlider=By.xpath("//div[text()='Price']/ancestor::div[@class='product-page-slider']//span[@ng-style='minPointerStyle']");
	By maxPriceSlider=By.xpath("//div[text()='Price']/ancestor::div[@class='product-page-slider']//span[@ng-style='maxPointerStyle']");
	By minTimeSlider=By.xpath("//div[text()='Departure Time']/ancestor::div[@class='product-page-slider']//span[@ng-style='minPointerStyle']");
	By maxTimeSlider=By.xpath("//div[text()='Departure Time']/ancestor::div[@class='product-page-slider']//span[@ng-style='maxPointerStyle']");
	
	By priceClearLink=By.xpath("//div[text()='Price']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By depTimeClearLink=By.xpath("//div[text()='Departure Time']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By busTypeClearLink=By.xpath("//div[text()='Bus Type']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By busBrandClearLink=By.xpath("//div[text()='Bus Brands']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By boardPointClearLink=By.xpath("//div[text()='Boarding Points']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By dropPointClearLink=By.xpath("//div[text()='Dropping Points']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By operatorClearLink=By.xpath("//div[text()='Bus Operators']/following-sibling::span/a[@aria-hidden='false' and text()='Clear']");
	By boardPointSearchIcon=By.xpath("//div[text()='Boarding Points']/following-sibling::div/a/i");
	By boardPointSearchBox=By.xpath("//div[text()='Boarding Points']/following-sibling::div/a/div/input");
	By dropPointSearchIcon=By.xpath("//div[text()='Dropping Points']/following-sibling::div/a/i");
	By dropPointSearchBox=By.xpath("//div[text()='Dropping Points']/following-sibling::div/a/div/input");
	By operatorSearchIcon=By.xpath("//div[text()='Bus Operators']/following-sibling::div/a/i");
	By operatorSearchBox=By.xpath("//div[text()='Bus Operators']/following-sibling::div/a/div/input");

}
