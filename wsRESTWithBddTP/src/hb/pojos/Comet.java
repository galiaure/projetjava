package hb.pojos;

import java.util.Date;

public class Comet {
	
private int id;
private String designation;
private String name;
private Date nextPeripherieDate;
private Double revolutionPeriod;

public Comet(){
	
}

public Comet(int id, String designation,String name,Date nextPeripherieDate, Double revolutionPeriod){
	this.id = id;
	this.designation = designation;
	this.name = name;
	this.nextPeripherieDate = nextPeripherieDate;
	this.revolutionPeriod = revolutionPeriod;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getNextPeripherieDate() {
	return nextPeripherieDate;
}

public void setNextPeripherieDate(Date nextPeripherieDate) {
	this.nextPeripherieDate = nextPeripherieDate;
}

public Double getRevolutionPeriod() {
	return revolutionPeriod;
}

public void setRevolutionPeriod(Double revolutionPeriod) {
	this.revolutionPeriod = revolutionPeriod;
}

@Override
public String toString() {
	return "Comet [id=" + id + ", designation=" + designation + ", name=" + name + ", nextPeripherieDate="
			+ nextPeripherieDate + ", revolutionPeriod=" + revolutionPeriod + "]";
}



}
