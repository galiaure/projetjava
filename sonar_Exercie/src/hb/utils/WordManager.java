package hb.utils;

public class WordManager {
	
	public String reverseString(String args) {
		String reverseString = args;
		
		for (int i = args.length() -1 ; i >=0; i-- ){
			 reverseString = reverseString.concat(String.valueOf(args.charAt(i)));
		}
		return reverseString;
	}
	
	public String encodeStringStart0(String arg , int num ) {
		// Methode avec n+
		String encodeString0 = arg;
		if (num <=5 && num >=0){
			for (int i=num; i< arg.length()+num; i++) {
				encodeString0 = encodeString0 + i;
		}
			
			StringBuilder bld = new StringBuilder(arg);
			  for (int i = 0; i < arg.length(); ++i) {
			    bld.append(arrayOfStrings[i]);
			  }
			  String str = bld.toString();

		
		}else {
			System.out.println("vous n'avez pas utiliser les bon num�ros");
		}
		
		return encodeString0;
	}
	
	public String encodeStringStart1(String arg , int num ) {
		// Methode avec n+1
		String encodeString1 = "";
		
		if (num <=5 && num >=0){
			for (int i=num+1; i< arg.length()+num+1; i++) {
				encodeString1 = encodeString1 + i;
		}
		
		}else {
			System.out.println("vous n'avez pas utiliser les bon num�ros");
		}
		
		return encodeString1;
	}
	
	

}
