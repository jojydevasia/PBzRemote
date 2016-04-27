package com.paytm.bus;


public class StringComTst {
	public static void main(String[] args){
		String tripTitle=("Manish Travels2+1, Sleeper, AC, Non-Video").toLowerCase();
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
