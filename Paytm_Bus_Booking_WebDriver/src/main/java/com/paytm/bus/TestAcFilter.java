package com.paytm.bus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class TestAcFilter {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException{
		driver=new FirefoxDriver();

		try {
			int lastRow=ReadWriteXL.getRowCount("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes")-1;
			for(int k=1; k<=lastRow; k++){
				String origin=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,0);

				for(int m=k;m<=lastRow;m++){

					String destination=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,1);
					String jrDate=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,2);
					if(origin==destination){
						continue;
					}

					String url="https://paytm.com/bus-tickets/search/"+origin+"/"+destination+jrDate+"1";
					driver.get(url);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

					String noTrip=driver.findElement(By.xpath("//div[@class='red' and contains(@ng-show,'errorFromApi')]")).getText();
					if (noTrip=="Seems like no bus journeys are available between Bangalore and Jammu"){
						continue;
					}
						driver.findElement(By.xpath("//div/span[contains(text(),'With Air Conditioner')]")).click();
					Thread.sleep(2000);
					String dispOrigin=driver.findElement(By.xpath("//div[@class='detaShow']/span[1]")).getText();
					String dispDestination=driver.findElement(By.xpath("//div[@class='detaShow']/span[2]")).getText();
					String routeInfo=dispOrigin+ " to "+dispDestination;
					System.out.println(routeInfo+"\n=====================================");
					List<WebElement>  tripRecord=driver.findElements(By.xpath("//div[@class='bus-ticket-container']"));
					System.out.println("[[Total # of records: " + (tripRecord.size()-1)+"]]\n-------------------\n\n");
					List<String> tripText=new ArrayList<String>();
					for(WebElement we1:tripRecord){
						tripText.add(we1.getText()+"-");
					}

					List<WebElement> busDetails=(driver.findElements(By.xpath("//div[@aria-hidden='false']/div/div[@class='headTop']/span")));
					List<String> busText=new ArrayList<String>();
					for(WebElement we2:busDetails){
						busText.add(we2.getText()+"-");
					}
					int lastRowNum=ReadWriteXL.getLastRowNum("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail");
					int count=lastRowNum+1;
					for(int i=0;i<busText.size();i++){
						String bTxt= (busText.get(i)).toLowerCase();

						String tTxt=tripText.get(i+1);



						if(bTxt.contains("non-ac")||bTxt.contains("non -ac")||bTxt.contains("non ac")||bTxt.contains("non-a/c")
								||bTxt.contains("non a/c")||bTxt.contains("non-a-c")||bTxt.contains("non a-c")||bTxt.contains("non.a/c")
								||bTxt.contains("non.a-c")||bTxt.contains("non.ac")||bTxt.contains("non a.c")||bTxt.contains("non-a.c")
								||bTxt.contains("non_a/c")||bTxt.contains("non_ac")||bTxt.contains("non_a.c")||bTxt.contains("non_a-c")){

							System.out.println("This trip has a detail mismatch\n ");
							System.out.println("Count is : "+count);

							ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,0,""+ count+"");
							ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,1,routeInfo);
							ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,2,(bTxt+"\n"+tTxt));
							count++;

							System.out.println("\nRecord # : "+(i+1));
							System.out.println(bTxt+"\n===================\n");
							System.out.println(tTxt);
							System.out.println("\n______________________________________\n");

						}

					}
					System.out.println("\n\n________________\n Iteration completed");

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
