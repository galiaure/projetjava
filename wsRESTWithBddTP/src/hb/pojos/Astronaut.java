package hb.pojos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="astronaute")
public class Astronaut {
	
	private int id; 
	private int age;
	private String lastname; 
	private String firstname;
	
	public Astronaut(){
		
	}
	
	public Astronaut(int id, int age, String firstname, String lastname){
		this.id = id;
		this.age = age;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "Astronaut [id=" + id + ", age=" + age + ", lastname=" + lastname + ", firstname=" + firstname + "]";
	}
}
