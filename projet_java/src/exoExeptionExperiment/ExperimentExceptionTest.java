package exoExeptionExperiment;

public class ExperimentExceptionTest {
	
	public static void main(String[] args)  {
		
		ExperimentException experimentexception = new ExperimentException(4,8);
		
		try {
			System.out.println("Le résult de 5 + 8 est "+experimentexception.getResult('+'));
			System.out.println("Le résult de 5 - 8 est "+experimentexception.getResult('-'));
			System.out.println("Le résult de 5 * 8 est "+experimentexception.getResult('*'));
			System.out.println("Le résult de 5 x 8 est: x est un String  "+experimentexception.getResult('x'));
		} catch (NotValidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	
	
		

		
		

	

}
