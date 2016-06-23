package com.paytm.bus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PaytmBusListPage {
	 
	WebDriver driver;
	String PtmBusListPgTitle=null;
	
	
	By busListHeader=By.cssSelector(".detaShow");
	By busRecord=By.xpath("//div[@ng-show='bus.isBusShown'  and @aria-hidden='false']");
	By selectSeatButton=By.xpath("//div[@aria-hidden='false']//button/span[text()='Select Seats']");
	By priceSort=By.xpath("//a[text()='Price']");
	By durationSort=By.xpath("//a[text()='Duration']");
	By arrivalSort=By.xpath("//a[text()='Arrival']");
	By departureSort=By.xpath("//a[text()='Departure']");
	private String s="Volvo";
	By refineFilterChkBox=By.xpath("//div[@class='md-label']/span[text()='"+s+"']");
	By clrOneFilter= By.xpath("//i[@class='fa fa-times']/preceding-sibling::a[text()='"+s+"']");
	By clrAllFilterButton=By.xpath("//li/a[text()='Clear All']");
	
	By modifySearchButton=By.xpath("//form//span[contains(text(),'Search')]/parent::button");
	By newOrigin=By.xpath("//label[contains(text(),'From')]/following-sibling::input");
	By newDestination=By.xpath("//label[contains(text(),'To')]/following-sibling::input");
	By newTravelDate=By.xpath("//input[@ng-model='dateTravel']");
	By modifySearchCloseBtn=By.xpath("//a/i[@class='icon-Delete']");
	
	
	
	
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
	
	
	public PaytmBusListPage(WebDriver driver){
		this.driver=driver;
		PtmBusListPgTitle=getPageTitle();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	
	
	
	
	
	public void scrolMinPriceSlider(){
		Actions act=new Actions(driver);
		act.dragAndDropBy(driver.findElement(minPriceSlider), 50, 0).build().perform();
		
	}
	
	public void scrolMaxPriceSlider(){
		Actions act=new Actions(driver);
		act.dragAndDropBy(driver.findElement(maxPriceSlider), -70, 0).build().perform();
		
	}

}
