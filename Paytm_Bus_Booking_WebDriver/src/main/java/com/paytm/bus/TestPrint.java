package com.paytm.bus;

public class TestPrint {
	public static void main(String[] args) throws Exception{
		/*int count=1;
		for(int i=0;i<10;i++){
			String bTxt= "Hello BusText";

			String tTxt="Hello TripText";

			if(bTxt.contains("Bus")||tTxt.contains("Trip")){

				System.out.println("Count is : " +count);

					ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,0,""+count+"");
					ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,1,"Test");
					ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,2,(bTxt+" & "+tTxt));
					count++;

		    }

		}

		int lastRow=ReadWriteXL.getRowCount("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes")-1;
		for(int k=1; k<=lastRow; k++){
			String u1=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,0);
			String u2=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,1);
			String u3=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,2);

			String url="https://paytm.com/bus-tickets/search/"+u1+"/"+u2+u3+"1";
			//https://beta1.paytm.com/bus-tickets/search/Bangalore/Coimbatore/2016-05-09/1
			System.out.println(url);
			}

		int rowCount=ReadWriteXL.getRowCount("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes");
		System.out.println("Number of Rows = "+rowCount);
		 */

		int lastRow=ReadWriteXL.getRowCount("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes")-1;
		for(int k=1; k<=lastRow; k++){
			String origin=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",k,0);

			for(int m=1;m<=lastRow;m++){

				String destination=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",m,1);
				String jrDate=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes",m,2);
				if(origin.equalsIgnoreCase(destination)){
					continue;
				}else{
					String url="https://paytm.com/bus-tickets/search/"+origin+"/"+destination+jrDate+"1";
					if (jrDate.equalsIgnoreCase("/2016-05-22/")){
						continue;
					}else{
						int lastRowNum=ReadWriteXL.getLastRowNum("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail");
						int count=lastRowNum+1;
						ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,0,""+count+"");
						ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,1,origin+"-"+destination);
						ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail",count,2,url);
						System.out.println("URL: "+url);
						count++;
					}
					
				}
				

				/*int r=ReadWriteXL.getLastRowNum("D:\\TestDataFiles\\PtmBzRouteDate.xlsx", "BusRoutes");
		System.out.println("Last Row Number = "+r);*/





			}

		}
	}
}
