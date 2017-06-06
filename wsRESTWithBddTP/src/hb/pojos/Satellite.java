package hb.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "satellite")
public class Satellite {
	private int id;
	private String name;
	private int idplanet;
	
	public Satellite(){
		
	}
	
	public Satellite(int id, String name, int idplanet){
		this.id = id;
		this.name = name;
		this.idplanet = idplanet;
		
	}
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getIdplanet() {
		return idplanet;
	}

	public void setIdplanet(int idplanet) {
		this.idplanet = idplanet;
	}

	@Override
	public String toString() {
		return "Satellite [id=" + id + ", name=" + name + ", idplanet=" + idplanet + "]";
	}
	
	
}
