package cgi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static DateFormat df;
	
	static{
		df = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public static LocalDate transformStringToLocalDate(String date){
		Calendar c = Calendar.getInstance();
		try {
			Date utilDate = df.parse(date);
			c.setTime(utilDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));
	}
	
	public static String transformLocalDateToString(LocalDate ld){
		Calendar c = Calendar.getInstance();
		c.set(ld.getYear(), ld.getMonthValue()-1,ld.getDayOfMonth());
		return df.format(c.getTime());
	}

}
