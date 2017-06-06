package exoDate;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class DateManager {
	/*
	 **/
	
	
	public String[] getDateInShortFormat(List<Date>dates){
		String[] tab = new String[dates.size()];
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int count = 0;
		for (Date d:dates){
			String dString = df.format(d);
			tab[count] = dString;
			count++;
		}
		return tab;
		
	}
	
	public int getMaxYear(List<Date>dates){
		//Retourne l'année la plus élevé des dates de la liste
	}
	
	public getMinYear(Date[]dates){
		//Retourne l'année la moin élevé des dates du tableau
	}

}

