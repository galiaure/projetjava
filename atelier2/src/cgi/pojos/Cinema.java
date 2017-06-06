package cgi.pojos;

import java.util.List;

public class Cinema {
	
	private String genre;
	private String pays;
	private int id;
	private List<Film> films;
	
	
	public Cinema(String genre, String pays, int id){
		this.genre = genre;
		this.pays= pays;
		this.id= id;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Cinema [genre=" + genre + ", pays=" + pays + ", id=" + id + ", films=" + films + "]";
	}


}


