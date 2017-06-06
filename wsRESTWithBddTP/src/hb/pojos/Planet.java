package hb.pojos;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "planet")
public class Planet {
	private int id;
	private String name;
	private String description;
	private String type;
	
	public Planet(){}
	
	public Planet(int id, String name, String description, String type){
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
	}

	@XmlElement
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	@XmlElement
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + "]";
	}
}
