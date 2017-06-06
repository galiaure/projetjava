package cgi.java;

import java.util.Comparator;

public class userCollec implements Comparator<userCollec> {
	private int idUser;
	private String name;
	private String firstname;
	public userCollec() {}
	public userCollec(int id, String name, String firstname) {
		this.idUser = id;
		this.name = name;
		this.firstname = firstname;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName()  {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "userCollec [idUser=" + idUser + ", name=" + name + ", firstname=" + firstname + "]";
	}
	public int compare(userCollec user1,userCollec user2) {
		int idUser1 = user1.getIdUser();
		int idUser2 = user2.getIdUser();
		if(idUser1 < idUser2) {
			return -1;
		}else if(idUser1 == idUser2){
			return 0;
		}else if(idUser1 > idUser2){
			return 1;
		}else{
			return 2;
		}
	}
}
