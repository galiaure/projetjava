package cgi.pojos;

import java.util.Comparator;
import java.util.Date;

import cgi.classes.JavaExperiment;

public class Film implements Comparator<Film> {
	
	private String titre;
	private Date dateSortie;
	private int duree;
	private JavaExperiment je;
	
	public Film(){
		
	}
	
	public Film(String titre,Date dateSortie, int duree){
		this.dateSortie = dateSortie;
		this.duree = duree;
		this.titre = titre;
		je = new JavaExperiment();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Film [titre=" + titre + ", dateSortie=" + je.getDateInShortFormat(dateSortie) + ", duree=" + duree + "]";
	}

	@Override
	public int compare(Film f1, Film f2) {
		//return f1.getTitre().compareTo(f2.getTitre());
		return f1.getDateSortie().compareTo(f2.getDateSortie());
	}

}
