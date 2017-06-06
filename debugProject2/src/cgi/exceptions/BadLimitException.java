package cgi.exceptions;

public class BadLimitException extends Exception{

	private static final long serialVersionUID = -4079391381427184133L;
	
	public BadLimitException(String msg){
		super(msg);
	}

}
