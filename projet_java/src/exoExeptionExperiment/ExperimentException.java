package exoExeptionExperiment;

public class ExperimentException {
	private int number1;
	private int number2;

	public ExperimentException(int number1, int number2){
		this.number1 = number1;
		this.number2 = number2;
	}

	public double getResult(char op)throws NotValidNumberException {
		int result = 0;

		if (number2 == 0){
			throw new NotValidNumberException ("Tu ne peux pas mettre de zéro");
		}else switch (op) {
		case '+' : 
			result =  number1 + number2;
			break;
		case '-' : if (number1 < number2){
			throw new NotValidNumberException ("Tu ne peux pas un nombre inférieur a son calcul");}else{
				result =  number1 - number2;}
		break;
		case '*' : 
			result = number1 * number2;
			break;
		case '/' : 
			result = number1 / number2;
			break;
		default: 
			result = number1;
		}
		return result;
	}



	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "ExperimentException [number1=" + number1 + ", number2=" + number2 + "]";
	}




}
