package exoExeption;

import java.util.Stack;

public class exoExeption {
	
	public void method (int num) throws ClassNotFoundException {
		if(num == 1){
			System.out.println("nombre trop petit");
			Class.forName("toto");
		}else{
			Class<?> object = Class.forName("Java.lang.Object");
			System.out.println(object.getCanonicalName());
		}
	}
	
	public int method(int num1, int num2){
		if(num1<num2){
			throw new ArithmeticException();
		}else{
			return num1 - num2;
		}
	}
	

	public static void main(String[] args) {
		
		//NUll pointer exeption
		/*
		String string = null;
		System.out.println(string.contains("safia"));
		*/
		
		//Arithmetic Exception
		/*
		int number1 = 5;
		int number2 = 0;
		int number3 = number1/number2;
		System.out.println(number3*2);
		*/
		
		//Array out of bounds exception
		/*
		int[] tab = new int[2];
		tab[3]=5;
		*/
		
		// no such element exception
		/*
		Stack<String> stack = new Stack<String>();
		stack.firstElement();
		*/
		
		//empty stack exception
		/*
		Stack<String> stack = new Stack<String>();
		stack.pop();
		*/
		
		//illegal argument exception
		/*
		List<String> names = new ArrayList<String> (-5);
		*/
		
		//La gestion des exceptions
		/*
		try {
			Class.forName("Toto");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			System.out.println("Classe inexistante");
		}
		*/
		
		// Test de la méthode throwExemple
		
		/*
		exoExeption throwExemple = new exoExeption();
		try {
			throwExemple.method(2);
			throwExemple.method(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		//Test de la méthode throwExample
		/*
		System.out.println(throwExemple.method(8,5));
		System.out.println(throwExemple.method(3,5));
		*/
		
		
	}
}
