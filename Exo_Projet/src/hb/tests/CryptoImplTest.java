package hb.tests;

import hb.crypto.CryptoImpl;

public class CryptoImplTest {

	public static void main(String[] args) {
		CryptoImpl cry1 = new CryptoImpl();
		System.out.println(cry1.encodeMessage("janine"));

	}

}
