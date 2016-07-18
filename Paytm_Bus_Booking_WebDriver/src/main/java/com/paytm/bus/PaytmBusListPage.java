package com.paytm.bus;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PaytmBusListPage {
	 
	WebDriver driver;
	String PtmBusListPgTitle=null;
	
	
	By busListHeader=By.cssSelector(".detaShow");
	By busRecord=By.xpath("//div[@ng-show='bus.isBusShown'  and @aria-hidden='false']");
	By busTripNameTxt=By.xpath("//div[@class='headTop']");
	By departureTimeTxt=By.xpath("//div[text()='Departure']/following-sibling::div");
	By arrivalTimeTxt=By.xpath("//div[text()='Arrival']/following-sibling::div");
	By durationTxt=By.xpath("//div[text()='Duration']/following-sibling::div");
	By priceTxt=By.xpath("//div[text()='Price per person']/following-sibling::div/span[3]");
	By seatsAvailableTxt=By.xpath("//div[@class='seatsAvailable']");
	By mTicketIcon=By.xpath("//i[@class='icon-icn_m_ticket']");
	
	By selectSeatButton=By.xpath("//div[@aria-hidden='false']//button/span[text()='Select Seats']");
	By priceSortLink=By.xpath("//a[text()='Price']");
	By durationSortLink=By.xpath("//a[text()='Duration']");
	By arrivalSortLink=By.xpath("//a[text()='Arrival']");
	By departureSortLink=By.xpath("//a[text()='Departure']");
	private String s="Volvo";
	By refineFilterChkBox=By.xpath("//div[@class='md-label']/span[text()='"+s+"']");
	By clearOneFilterLink= By.xpath("//i[@class='fa fa-times']/preceding-sibling::a[text()='"+s+"']");
	By clearAllFilterButton=By.xpath("//li/a[text()='Clear All']");
	
	By modifySearchButton=By.xpath("//form//span[contains(text(),'Search')]/parent::button");
	By newOrigin=By.xpath("//label[contains(text(),'From')]/following-sibling::input");
	By newDestination=By.xpath("//label[contains(text(),'To')]/following-sibling::input");
	By newTravelDate=By.xpath("//input[@ng-model='dateTravel']");
	By modifySearchCloseBtn=By.xpath("//a/i[@class='icon-Delete']");
	
	By minPriceSlider=By.xpath("//div[text()='Price']/ancestor::div[@class='product-page-slider']//span[@ng-style='minPointerStyle']");
	By maxPriceSlider=By.xpath("//div[text()='Price']/ancestor::div[@class='product-page-slider']//span[@ng-style='maxPointerStyle']");
	By minPriceText=By.xpath("//div[text()='Price']/ancestor::div[@class='product-page-slider']//span[@class='rz-bubble'][1]");
	By maxPriceText=By.xpath("//div[text()='Price']/ancestor::div[@class='product-page-slider']//span[@class='rz-bubble'][2]");
	
	By minTimeSlider=By.xpath("//div[text()='Departure Time']/ancestor::div[@class='product-page-slider']//span[@ng-style='minPointerStyle']");
	By maxTimeSlider=By.xpath("//div[text()='Departure Time']/ancestor::div[@class='product-page-slider']//span[@ng-style='maxPointerStyle']");
	By minTimeText=By.xpath("//div[text()='Departure Time']/ancestor::div[@class='product-page-slider']//span[@class='rz-bubble'][1]");
	By maxTimeText=By.xpath("//div[text()='Departure Time']/ancestor::div[@class='product-page-slider']//span[@class='rz-bubble'][2]");
	
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
	
	By boardingPointList=By.xpath("//md-select[@ng-model='boardingPoint']");
	By bordingPointItem=By.xpath("//div[@class='md-text'  and contains(text(),*)]");
	By proceedToPayBtn=By.xpath("//button/span[contains(text(),'Proceed to pay')]");
	By closeSeatLayoutBtn=By.xpath("//button[@ng-click='cancel()']");
	
	
	public PaytmBusListPage(WebDriver driver){
		this.driver=driver;
		PtmBusListPgTitle=getPageTitle();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	
	public String getTripDetails(){
		return driver.findElement(busListHeader).getText();
	}
	
	
	public int getTotalBusCount(){
		String tempBusHeader=this.getTripDetails();
		String tempBusHeader1=tempBusHeader.split("Showing ")[1];
		int dispBusCount=Integer.parseInt((tempBusHeader1.split("of ")[0]).trim());
		String  tempBusHeader2=(tempBusHeader1.split("of ")[1]);
		int totalBusCount=Integer.parseInt(tempBusHeader2.split("buses")[0].trim());
		return totalBusCount;
	}
	
	public int getDispBusCount(){
		String tempBusHeader=this.getTripDetails();
		String tempBusHeader1=tempBusHeader.split("Showing ")[1];
		int dispBusCount=Integer.parseInt((tempBusHeader1.split("of ")[0]).trim());
		String  tempBusHeader2=(tempBusHeader1.split("of ")[1]);
		int totalBusCount=Integer.parseInt(tempBusHeader2.split("buses")[0].trim());
		return dispBusCount;
	}
	
	public String getOriginText(){
		String tempBusHeader=this.getTripDetails();
		String originText=(tempBusHeader.split("from ")[1]).split("to")[0].trim();
		return originText;
	}
	
	public String getDestinationText(){
		String tempBusHeader=this.getTripDetails();
		String destText=(tempBusHeader.split("from ")[1]).split("to")[1].trim();
		return destText;
	}
	
	public String getBusTripDetails(){
		return driver.findElement(busTripNameTxt).getText();
	}
	
	public String getDepartureTime(){
		return driver.findElement(departureTimeTxt).getText();
	}
	
	public String getArrivalTimeText(){
		return driver.findElement(arrivalTimeTxt).getText();
	}
	
	public String getTripDuration(){
		return driver.findElement(durationTxt).getText();
	}
	
	
	public int getTicketPrice(){
		String tempPrice=(driver.findElement(priceTxt).getText()).split("Rs.")[1];
		return Integer.parseInt(tempPrice.trim());
	}
	
	public int getNumSeatsAvailable(){
		String seatMsg=(driver.findElement(seatsAvailableTxt)).getText();
		String[] msgSplit=seatMsg.split(":");
		return Integer.parseInt(msgSplit[1].trim());
	}
	
	public boolean isMTicketAvailable(){
		List<WebElement> busRecordList=driver.findElements(busRecord);
		for(int j=0;j<=busRecordList.size();j++){
			try{
			 if((busRecordList.get(j).findElement(mTicketIcon)).isDisplayed()){
				 return true;
			 }
			}
			catch(Exception e){	
				return false;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	public void selectBordingPointByIndex(int index) throws InterruptedException{
		driver.findElement(boardingPointList).click();
		Thread.sleep(2000);
		List<WebElement> bordPoints=driver.findElements(bordingPointItem);
		int numBrdPoints=bordPoints.size();
		if(numBrdPoints>1 && index<numBrdPoints){
			bordPoints.get(index).click();
		}else
		bordPoints.get(0).click();
	}
	
	public void selectBordingPointByName(String bpName) throws InterruptedException{
		driver.findElement(boardingPointList).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='md-text'  and contains(text(),'"+bpName+"')]"));
	}
	
	
	public void clickCloseSeatLayoutBtn(){
		driver.findElement(closeSeatLayoutBtn).click();
	}
	
	
	public void clickProceedToPayBtn(){
		driver.findElement(proceedToPayBtn).click();
	}
	
	public String getTxtOfPayBtn(){
		return driver.findElement(proceedToPayBtn).getText();
	}
	
	
	
	public void selectSeats(int reqSeats) throws InterruptedException{
		if(reqSeats>5 || reqSeats<1){
			System.out.println("Invalid # seats. Please enter a value from 0-5");
			return;
		}
		List<WebElement> busRecordList=driver.findElements(busRecord);
		for(int j=0;j<=busRecordList.size();j++){
			String seatMsg=(busRecordList.get(j).findElement(seatsAvailableTxt)).getText();
			String[] msgSplit=seatMsg.split(":");
			int numSeatAvl=Integer.parseInt(msgSplit[1].trim());
			if(numSeatAvl>0){
				driver.findElement(selectSeatButton).click();
			//  in seat selection panel
				Thread.sleep(6000);
				List<WebElement> avlSeats=driver.findElements(By.xpath("//a/div[@class='square2 available' or @class='square available']"));
				System.out.println("AvlSeat List Size: "+avlSeats.size());
				if(avlSeats.size()>=reqSeats){
					for(int i=0;i<reqSeats;i++){
						avlSeats.get(i).click();
					}
			
					break;
				}else{
					System.out.println("Required number of seats not available");
					driver.findElement(By.xpath("//button[@ng-click='cancel()']")).click();
					
				 }
			}else{ 
				System.out.println("No Seats are Available");
			}
		}
	}
	
	
	
	public void scrolMinPriceSlider(){
		Actions act=new Actions(driver);
		act.dragAndDropBy(driver.findElement(minPriceSlider), 50, 0).build().perform();
	}
	
	
	public int getMinPrice(){
		String[] tempMinPrice=(driver.findElement(minPriceText).getText()).split("Rs.");
		String minPrice=tempMinPrice[1];
		return Integer.parseInt(minPrice);
	}
	
	
	public void scrolMaxPriceSlider(){
		Actions act=new Actions(driver);
		act.dragAndDropBy(driver.findElement(maxPriceSlider), -70, 0).build().perform();
	}
	
	
	public int getMaxprice(){
		String[] tempMaxPrice=(driver.findElement(maxPriceText).getText()).split("Rs.");
		String maxPrice=tempMaxPrice[1];
		return Integer.parseInt(maxPrice);
	}
	
	
	public void scrolMinTimeSlider(){
		Actions act=new Actions(driver);
		act.dragAndDropBy(driver.findElement(minTimeSlider),60,0).build().perform();
	}
	
	
	public String getMinTime(){
		return driver.findElement(minTimeText).getText();
	}
	
	
	public void scrolMaxTimeSlider(){
		Actions act=new Actions(driver);
		act.dragAndDropBy(driver.findElement(maxTimeSlider), -60, 0).build().perform();
	}
	
	
	public String getMaxTime(){
		return driver.findElement(maxTimeText).getText();
	}

}
