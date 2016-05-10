package com.paytm.bus;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class StringComTst {
	static String date;
	public static void main(String[] args){
		try {
			date=ReadWriteXL.readXLData("D:\\TestDataFiles\\PtmBzRouteDate.xlsx","BusRoutes",1,2 );
			System.out.println(date);
			
				ReadWriteXL.writeXLData("D:\\TestDataFiles\\acDetailMismatch.xlsx","MismatchDetail", 3, 2, "2016-05-29");
			
			
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*String tripTitle=("Parveen Travels2+2 Single Tier Hi-Tech Semi Sleeper Multiaxle A/C Go Green Scania").toLowerCase();
		if(tripTitle.contains("non-ac")||tripTitle.contains("non -ac")||tripTitle.contains("non ac")||tripTitle.contains("non-a/c")
				||tripTitle.contains("non a/c")||tripTitle.contains("non-a-c")||tripTitle.contains("non a-c")||tripTitle.contains("non.a/c")
				||tripTitle.contains("non.a-c")||tripTitle.contains("non.ac")||tripTitle.contains("non a.c")||tripTitle.contains("non-a.c")
				||tripTitle.contains("non_a/c")||tripTitle.contains("non_ac")||tripTitle.contains("non_a.c")||tripTitle.contains("non_a-c")){
	    	System.out.println("String Mismatch Caught");
	    }else{
	    	System.out.println("String is OK");
	    }*/
		
	} 
	

}
