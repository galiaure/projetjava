package hb.crypto;

public class CryptoImpl {

	public String encodeMessage(String args) {

		String encodeMessage = "";
		//Mon tableau alphabet
		char alphaB[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		

		//Transformation tableau numérique
		
		char[] tab = new char [args.length()];

		for(char i = 0; i < args.length() ; i++){
			
			tab[i] = args.charAt(i);
			System.out.println(tab[i]);
		}
		
		
		
		

		return encodeMessage ;
	}
}
