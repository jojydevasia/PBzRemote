package com.paytm.bus;

//Use this program to do the filter test for A/C buses.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		

		try {
			int lastRow=ReadWriteXL.getRowCount("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes")-1;
			
			String[] colNames={"S.No","Route","Details"};
			ReadWriteXL.writeNewXLFile("D:\\TestDataFiles\\", "acDetailMismatch", 3, colNames);
			String fileName1=ReadWriteXL.createFileName("D:\\TestDataFiles\\","acDetailMismatch");
				

				for(int m=1;m<=lastRow;m++){
					String origin=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",m,0);
					String destination=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",m,1);
					String jrDate=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",m,2);

					if(origin.equalsIgnoreCase(destination)){
						continue;
					}else

					{
						driver=new FirefoxDriver();
						
						String url="https://paytm.com/bus-tickets/search/"+origin+"/"+destination+jrDate+"1";
						//Runtime.getRuntime().exec("D:\\JojyDevasiaFolder\\AutoIT scripts\\HandleAuth.exe");
						driver.get(url);
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
						
						if (driver.findElement(By.xpath("//div[@ng-controller='busTicketCheckoutCtrl']")).getText().contains("Seems like no bus journeys are available")){
							System.out.println(origin+" "+destination+"Has no trips");
							continue;
						}else
						{
							//Thread.sleep(2000);
							//driver.findElement(By.xpath("//div/span[contains(text(),'With Air Conditioner')]")).click();
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

									ReadWriteXL.writeXLData(fileName1,"MismatchDetail",count,0,""+count+"");
									ReadWriteXL.writeXLData(fileName1,"MismatchDetail",count,1,routeInfo);
									ReadWriteXL.writeXLData(fileName1,"MismatchDetail",count,2,(bTxt+"\n"+tTxt));
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
					driver.quit();

				}
			//} 
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
