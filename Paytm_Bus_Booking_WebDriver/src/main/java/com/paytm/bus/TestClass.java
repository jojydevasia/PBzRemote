package com.paytm.bus;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	public static void main(String[] args) throws Exception{
		
		/*String[] colNames={"S.No","Route ","Details"};
		ReadWriteXL.writeNewXLFile( "D:\\TestDataFiles\\","acDetailMismatch",3,colNames);
		System.out.println("done: file created");  (This block creates a new file by calling t*he method in ReadWriteXL.java  */
		System.setProperty("webdriver.chrome.driver", "D:\\JojyDevasiaFolder\\Automation sw Lib\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		int reqSeats=2;
		
		driver.get("https://paytm.com/bus-tickets/search/Bangalore/Chennai/2016-08-07");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		//System.out.println(driver.findElement(By.xpath("//i[contains(@ng-click,'swapStartDestination')]")).getTagName());
		//System.out.println(driver.findElement(By.xpath("//div[contains(@ng-click,'clearOriginSearch')]//i")));
		//System.out.println(driver.findElement(By.xpath("//div[contains(@ng-click,'clearDestinationSearch')]//i")));
		//System.out.println(driver.findElement(By.xpath("//ul[1]/li[contains(@ng-repeat,'routeDetail in topRoute')]/a")).getText());
		//System.out.println(driver.findElement(By.xpath("//ul[1]/li[contains(@ng-repeat,'routeDetail in topRoute')]//button")).getText());
		//driver.findElement(By.xpath("//label[text()='Select Date']/following-sibling::input[1]")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@class='picker__header']")).getText());		
		 //PaytmBusHomePage pbhp=new PaytmBusHomePage(driver);
		//pbhp.openTravelCalendar();
		//pbhp.selectTravelDate("29", "July2016");
		//System.out.println((driver.findElement(By.xpath("//div[@class='picker__box']"))).isDisplayed());
		// pbhp.clickTopRouteRecord("Hyderabad to Guntur");
		 
		//pbhp.clickTopRouteBookButton("Chennai to Bangalore");
		//List< String> x=pbhp.getTopRouteRecordText();
		//for(String s:x){
		//System.out.println("\n"+s);
		//}
		 
		 PaytmBusListPage pbp=new PaytmBusListPage(driver);
		 
		 Thread.sleep(3000);
		 
		 //System.out.println(driver.findElement(pbp.refineFilterChkBox).getText()+"\n==============\n");
		// driver.findElement(pbp.refineFilterChkBox).click();
		 //System.out.println(driver.findElement(pbp.clrOneFilter).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.clrAllFilterButton).getText()+"\n==============\n");
		 //driver.findElement(pbp.clrOneFilter).click();
		 //Thread.sleep(2000);
		 //System.out.println(driver.findElement(pbp.modifySearchButton).getText()+"\n==============\n");
		 //driver.findElement(pbp.modifySearchButton).click();
		 //Thread.sleep(2000);
		 //System.out.println(driver.findElement(pbp.modifySearchButton).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.newOrigin).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.newDestination).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.newTravelDate).getText()+"\n==============\n");
		 //System.out.println(driver.findElement(pbp.modifySearchCloseBtn)+"\n===========\n");
		 //Thread.sleep(3000);
		// driver.findElement(pbp.modifySearchCloseBtn).click();
		// System.out.println(driver.findElement(pbp.minPriceSlider)+"\n===========\n");
		// System.out.println(driver.findElement(pbp.maxPriceSlider)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.minTimeSlider)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.maxTimeSlider)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.boardPointSearchIcon)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.dropPointSearchIcon)+"\n===========\n");
		 //System.out.println(driver.findElement(pbp.operatorSearchIcon)+"\n===========\n");
		 
		 //System.out.println("Min Price Before= "+pbp.getMinPrice() );
		 //pbp.scrolMinPriceSlider();
		 //System.out.println("Min Price After= "+pbp.getMinPrice() );
		 
		 
		 //pbp.scrolMaxPriceSlider();
		 
		 //pbp.scrolMinTimeSlider();
		 
		 //pbp.scrolMaxTimeSlider();
		 //System.out.println(pbp.getTotalBusCount());
		 //System.out.println(pbp.getDispBusCount());
		 //System.out.println(pbp.getOriginText());
		 //System.out.println(pbp.getDestinationText());
		 pbp.selectSeats(reqSeats);
		 pbp.selectBordingPointByIndex(2);
		 pbp.clickProceedToPayBtn();
		 //Login Process
		 String uid=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Login", 1,0);
			String pwd=ReadWriteXL.readXLData("D:\\TestDataFiles\\PTMBz Test Data.xlsx","Login", 1,1);
		 
			Thread.sleep(10000);
			WebElement fr=driver.findElement(By.xpath("//*[@ng-hide='showVerificationScreen']")); 
			driver.switchTo().frame(fr);
			String fTitl=driver.getTitle();
			System.out.println("FrameTitle : "+fTitl);
			System.out.println("Text 4 Frame: ");
			System.out.println(driver.findElement(By.xpath("//*[@id='wallet-container-new']/ul")).getText());
			driver.findElement(By.xpath("//input[@id='input_0']")).sendKeys(uid);
			driver.findElement(By.cssSelector("#input_1")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(80000);
			PaytmBusPassengerDetailPage pdp=new PaytmBusPassengerDetailPage(driver);
			
			System.out.println("******"+pdp.passengerPageTitle+"******");
			pdp.setPassengerDetails(reqSeats);
			System.out.println("Mob No : "+pdp.getContactMobileNum());
			pdp.setContactMobileNum("9911991199");
			System.out.println("Email : "+pdp.getContactEmail());
			pdp.setContactEmail("Hello@example.com");
			pdp.clickAgreeCheckBox();
			System.out.println("Boooking Head : "+pdp.getBookingDetailsHeader());
			
			String[]x=pdp.getSeatNumbers();
			
			System.out.println("Total seats : "+x.length);
			System.out.print("SeatNumbers: [ ");
			for(int g=0;g<x.length;g++){
				System.out.print(x[g]+ " , ");
			}
			
			System.out.println(" ]");
			
			System.out.println("Seat Print Style2 : "+x.toString());
			
			System.out.println("Boarding point : "+pdp.getBoardingPoint());
			System.out.println("Boarding time : "+pdp.getBoardingTime());
			System.out.println("BusType : "+pdp.getBusType());
			System.out.println("Departure city : "+pdp.getDepartureCityName());
			System.out.println("Arrival  city : "+pdp.getArrivalCityName());
			System.out.println("Operator Name : " + pdp.getOperatorName());
			System.out.println("Total Fare on page : "+pdp.getTotalFare());
			System.out.println("Read Cancellation  Policy : ");
			pdp.readCancellationPolicy();Thread.sleep(5000);
			System.out.println("Fare on button : "+ pdp.getFareOnPayButton());
			String parentWindowHandle=driver.getWindowHandle();
			System.out.println("Main Window Handle: "+driver.getWindowHandle());
			pdp.clickTnCLink();
			System.out.println("Click TErms link");
			
			for(String winHandle:driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
			System.out.println("Child window Handle: "+driver.getWindowHandle());
			String childWindowHandle=driver.getWindowHandle();
			System.out.println("Child Window title: "+driver.getTitle());
			//driver.close();
			/* Set<String> handles= driver.getWindowHandles();
			// System.out.println("Handle Set Size : "+handles.size());
			
			String[] tempHandl=new String[2];
			Iterator<String> itr=handles.iterator();
			for(int i=0;i<(handles.size()-1);i++){
				tempHandl[i]=itr.next();
			}
			System.out.println("[ "+tempHandl[0]+" , "+tempHandl[1]+" ]");
			
			driver.switchTo().window(tempHandl[0]);
			System.out.println("Terms Window Title" +driver.getTitle()); */
			Thread.sleep(3000);
			driver.switchTo().window(parentWindowHandle);
			Thread.sleep(2000);
			
		    pdp.enterPromoCode("Bus 150");
		    System.out.println("entered PromoCode");
			
			
		
		 
		 
	}
	
	

}
