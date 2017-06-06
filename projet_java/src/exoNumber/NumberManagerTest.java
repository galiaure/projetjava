package exoNumber;
import static java.lang.Math.*;
public class NumberManagerTest {

	public static void main(String[] args) {
		NumberManager nm = new NumberManager(5,8);
		
		System.out.println("Le résult de 5 + 8 est "+nm.getResult('+'));
		System.out.println("Le résult de 5 - 8 est "+nm.getResult('-'));
		System.out.println("Le résult de 5 * 8 est "+nm.getResult('*'));
		System.out.println("Le résult de 5 x 8 est: x est un String  "+nm.getResult('x'));
		
		

	}

}
