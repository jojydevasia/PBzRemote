package com.paytm.bus;


public class StringComTst {
	public static void main(String[] args){
		String tripTitle=("Parveen Travels2+2 Single Tier Hi-Tech Semi Sleeper Multiaxle A/C Go Green Scania").toLowerCase();
		if(tripTitle.contains("non-ac")||tripTitle.contains("non -ac")||tripTitle.contains("non ac")||tripTitle.contains("non-a/c")
				||tripTitle.contains("non a/c")||tripTitle.contains("non-a-c")||tripTitle.contains("non a-c")||tripTitle.contains("non.a/c")
				||tripTitle.contains("non.a-c")||tripTitle.contains("non.ac")||tripTitle.contains("non a.c")||tripTitle.contains("non-a.c")
				||tripTitle.contains("non_a/c")||tripTitle.contains("non_ac")||tripTitle.contains("non_a.c")||tripTitle.contains("non_a-c")){
	    	System.out.println("String Mismatch Caught");
	    }else{
	    	System.out.println("String is OK");
	    }
		
	} 
	

}
