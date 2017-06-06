package cgi.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cgi.pojos.Cinema;
import cgi.pojos.Film;

public class JavaExperiment {
	
	private Map<Integer,Cinema> cinemas;
	private Set<Integer> keys;
	
	public JavaExperiment(){
		cinemas = new HashMap<Integer,Cinema>();
		Cinema c1 = new Cinema("science-fiction","Français",54);
		Cinema c2 = new Cinema("comédie","Français",55);
		Cinema c3 = new Cinema("action","Français",56);
		
		cinemas.put(c1.getId(), c1);
		cinemas.put(c2.getId(), c2);
		cinemas.put(c3.getId(), c3);
		
		keys = cinemas.keySet();
	}
	
	public String getDateInShortFormat(Date d){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(d);
	}
	
	public int getKeySum(){
		Iterator<Integer> ikeys = keys.iterator();
		int sum = 0;
		while(ikeys.hasNext()){
			Integer icurrent = ikeys.next();
			sum = sum +icurrent;
		}
		return sum;
		
	}
	
	public int getMaxDateInFilm(List<Film> films){
		int yearMax = 0;
		for(int i=0;i<films.size();i++){
			Film f = films.get(i);
			Date dfilm = f.getDateSortie();
			Calendar c = Calendar.getInstance();
			c.setTime(dfilm);
			int year = c.get(Calendar.YEAR);
			if(year>yearMax){
				yearMax = year;
			}
		}
		
		return yearMax;
	}
	
	

}
