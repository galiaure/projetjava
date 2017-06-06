package hb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {
	
	public static String transformDateToString(Date d){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(d);
	}

}
