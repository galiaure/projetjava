package cgi.pojos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class PojosTest {

	public static void main(String[] args) {
		Cinema c = new Cinema("science-fiction","Français",54);
		
		System.out.println("c : "+c);
		Calendar cal = Calendar.getInstance();
		cal.set(1994, 05, 10);
		
		Film f = new Film("Le cinquieme élément",cal.getTime(),135);
		System.out.println(f);
		
		
		cal.set(2017, 05, 3);
		Film f1 = new Film("Les gardiens de la galaxie",cal.getTime(),154);
		System.out.println(f1);
		
		cal.set(2015, 8, 3);
		Film f2 = new Film("30 ans d'amours dans les bras d'un manchot",cal.getTime(),125);
		System.out.println(f2);
		
		cal.set(2012, 1, 11);
		Film f3 = new Film("Star wars",cal.getTime(),115);
		System.out.println(f3);
		
		List<Film> films = new ArrayList<Film>();
		
		films.add(f);
		films.add(f3);
		films.add(f1);
		films.add(f2);
		
		
		c.setFilms(films);
		
		System.out.println("c : "+c);
		
		System.out.println("Liste des films sans tri");
		for(Film fi: films){
			System.out.println(fi);
		}
		
		Collections.sort(films, new Film());
		
		System.out.println("Liste des films après tri");
		for(Film fi: films){
			System.out.println(fi);
		}
		

	}

}
