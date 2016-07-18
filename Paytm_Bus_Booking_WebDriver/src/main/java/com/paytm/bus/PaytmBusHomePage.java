package com.paytm.bus;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
	
public class PaytmBusHomePage {
	
	WebDriver driver;
	
	String busHomeTitle=null;
	By bookTicketsHeader=By.xpath("//h1[text()='Book Bus Tickets']");
	By originField=By.xpath("//label[text()='From (Origin)']/following-sibling::input");
	By originContainer=By.xpath("//ul/li[2]/md-input-container");
	By clearOriginButton= By.xpath("//div[contains(@ng-click,'clearOriginSearch')]//i");
	By destinationField= By.xpath("//label[text()='To (Destination)']/following-sibling::input");
	By destinationContainer=By.xpath("//ul/li[1]/md-input-container");
	By clearDestinationButton=By.xpath("//div[contains(@ng-click,'clearDestinationSearch')]//i");
	By travelDateCalendar=By.xpath("//label[text()='Select Date']/following-sibling::input[1]");
	By routeSwapButton=By.xpath("//i[contains(@ng-click,'swapStartDestination')]");
	By todayButton=By.xpath("//button[@value='Today']");
	By tomorrowButton=By.xpath("//button[@value='Tomorrow']");
	By searchBusButton=By.xpath("//span[text()='Search Buses']");
	By topRoutesHeader=By.xpath("//h2[Contains(text(),'Top Route')]");
	By topRouteRecord=By.xpath("//ul/li[contains(@ng-repeat,'routeDetail in topRoute')]/a");
	By topRouteBookButton=By.xpath("//ul/li[contains(@ng-repeat,'routeDetail in topRoute')]/a/following-sibling::span/button");	
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public PaytmBusHomePage(WebDriver driver){
		this.driver=driver;
		busHomeTitle=getPageTitle();
	}
	
	public String getTicketsHeaderText(){
		return driver.findElement(bookTicketsHeader).getText();
	}
	
	public void enterOrigin(String origin){
		driver.findElement(originField).sendKeys(origin);
		driver.findElement(originContainer).click();
	}
	
	public void clearOrigin(){
		driver.findElement(clearOriginButton).click();
	}
	
	public void enterDestination(String destination){
		driver.findElement(destinationField).sendKeys(destination);
		driver.findElement(destinationContainer).click();
	}
	
	public void clearDestination(){
		driver.findElement(clearDestinationButton).click();
	}
	
	public void swapRoute(){
		driver.findElement(routeSwapButton).click();
	}
	
	public void openTravelCalendar(){
		driver.findElement(travelDateCalendar).click();
	}
	
	
	
	public void selectTravelDate(String day,String monthYear) throws Exception{
		
		String trvMonth_Year=driver.findElement(By.xpath("//div[@class='picker__header']")).getText();
		WebElement nxtButton=driver.findElement(By.xpath("//div[contains(@class,'picker__nav--next') and @data-nav='1']"));

		if(trvMonth_Year.contains(monthYear)){
			
			List<WebElement> availableDays=driver.findElements(By.xpath("//table//div[contains(normalize-space(@class),'infocus') and not(@aria-disabled='true')]"));
			for(WebElement i:availableDays){
				System.out.println(i.getText());
				if (i.getText().contains(day)){
					i.click();
					return;
				}
			}

		}else{
			nxtButton.click();
			Thread.sleep(1000);
			selectTravelDate(day,monthYear);
		}
	}
	
	
	
	
	public void selectTodaysDate(){
		driver.findElement(todayButton).click();
	}
	
	
	public void selectTomorrowsDate(){
		driver.findElement(tomorrowButton).click();
	}
	
	
	public void clickSearchButton(){
		driver.findElement(searchBusButton).click();
	}
	
	public String getTopRouteHeader(){
		return driver.findElement(topRoutesHeader).getText();
	}
	
	public void clickTopRouteRecord(String originToDest){
		List<WebElement> topRouteRecords=driver.findElements(topRouteRecord);
		for(int i=0;i<topRouteRecords.size();i++){
			WebElement topRec=topRouteRecords.get(i);
			String routeText=topRouteRecords.get(i).getText();
			if(routeText.contains(originToDest)){
				WebElement record=(topRouteRecords.get(i)).findElement(By.xpath("a"));
				record.click();
				break;
			}
		}
		
	}
	
	
	public List<String> getTopRouteRecordText(){
		List<WebElement> topRouteRecords=driver.findElements(topRouteRecord);
		List<String> topRouteText = new ArrayList<String>() ;
		for(WebElement w:topRouteRecords){
			topRouteText.add(w.getText());
		}
		return topRouteText;
	}
	
	
	public void clickTopRouteBookButton(String originToDest){
		String o2D=originToDest;
		String topRouteXpath="//ul/li[contains(@ng-repeat,'routeDetail in topRoute')]/a[text()='"+ o2D + "']/following-sibling::span/button";
		try{
		driver.findElement(By.xpath(topRouteXpath)).click();
		System.out.println("clicked");
		} catch(Exception e){
			System.out.println( "Element  not found");
		}
	}
	
	
	
	
	
	

}
