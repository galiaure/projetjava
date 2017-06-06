package cgi.java;

import java.util.Date;
import java.util.Locale;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Part32 {
	
	/**
	 * Méthode permettant respectivement de convertir un objet Calendar en java.util.Date 
	 * *et un objet java.util.Date en Calendar
	 * @param c
	 * @return
	 */
	public Date convertCalendarToDate(Calendar c) {
		return c.getTime();
	}
	public Calendar convertDateToCalendar(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}
	
	/**
	 * Méthodes qui permettent d'obtenir une java.sql.Date à partir d'une java.util.date et inversement
	 * @param args
	 */
	public java.sql.Date convertUtilDateToSqlDate(java.util.Date dateUtil) {
		return new java.sql.Date(dateUtil.getTime());
	}
	public java.util.Date convertSqlDateToUtilDate(java.sql.Date dateSql) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dateSql.getTime());
		return calendar.getTime();
	}
	
	/**
	 * Méthodes qui permettent de convertir une java.util.Date en String et inversement
	 * @param d
	 * @return
	 */
	public String formatDate(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss");
		return sdf.format(d);
	}
	public Date getDateFromString(String date) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
				Date parsedDate = new Date();
				try {
					parsedDate = df.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return parsedDate;
	}
	
	/**
	 * méthodes permettant respectivement d'avoir la différence en ms 
	 * entre 2 dates et de comparer 2 dates
	 */
	public long getDifferenceBetweenTwoDates(Date date1, Date date2){
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long diffInMs = time2 - time1;
		long diffInDay = diffInMs/(1000*60*60*24);
		return diffInDay;
	}
	public int compareTwoDates(Date date1, Date date2){
		int result = 2;
		if(date1.equals(date2)){
			result = 0;
		}else if(date1.before(date2)){
			result = -1;
		}else if(date1.after(date2)){
			result = 1;
		}
		return result;
	}
	

	
	public static void main(String[] args) {
		
		/**
		 * Test des méthodes convertCalendarToDate et convertDateToCalendar
		 */
		Part32 part32 = new Part32();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1984, 10, 5 );
		
		Date date = part32.convertCalendarToDate(calendar);
		System.out.println(date);
		
		Date nowDate = new Date();
		calendar = part32.convertDateToCalendar(nowDate);
		
		System.out.println(calendar);
		
		/**
		 * Test des méthodes convertUtilDateToSqlDate et convertSqlDateToUtilDate
		 */
		Date sqlDate = part32.convertUtilDateToSqlDate(nowDate);
		System.out.println(sqlDate);
		
		calendar.set(1999, 0,10);
		Date utilDate = part32.convertSqlDateToUtilDate(new java.sql.Date(calendar.getTimeInMillis()));
		System.out.println(utilDate);
		
		/**
		 * Test des methodes formatDate et getDateFromString
		 */
		String stringDate = part32.formatDate(utilDate);
		System.out.println(stringDate);
		utilDate = part32.getDateFromString("05/11/1984");
		System.out.println(utilDate);
		
		/**
		 * Test des méthodes getDifferenceBetweenTwoDates et compareTwoDates
		 */
		long diffInMs = part32.getDifferenceBetweenTwoDates(new Date(), nowDate);
		System.out.println(diffInMs);
		
		calendar.set(1985, 0, 1);
		Date date1ToCompare = calendar.getTime();
		
		calendar.set(1984, 11, 2);
		Date date2ToCompare = calendar.getTime();
		
		if(part32.compareTwoDates(date1ToCompare, date2ToCompare)==1) {
			System.out.println(date1ToCompare+" est après "+date2ToCompare);
		}
	}

}
