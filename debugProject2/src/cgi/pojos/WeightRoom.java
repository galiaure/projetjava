package cgi.pojos;

import java.time.LocalDate;
import java.util.Random;

import cgi.utils.DateUtils;

public class WeightRoom<T> {
	
	private DoubleKey dk;
	private String name;
	private String address;
	private LocalDate openingDate;
	T areaOrDesc;
	
	public WeightRoom(String name, String address, String date, T areaOrDesc){
		this.name = name;
		this.address = address;
		this.openingDate = DateUtils.transformStringToLocalDate(date);
		this.areaOrDesc = areaOrDesc;
		Random rd = new Random();
		dk = new DoubleKey(rd.nextFloat()*100,rd.nextFloat()*100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public T getAreaOrDesc() {
		return areaOrDesc;
	}

	public void setAreaOrDesc(T areaOrDesc) {
		this.areaOrDesc = areaOrDesc;
	}

	public DoubleKey getDk() {
		return dk;
	}

	public void setDk(DoubleKey dk) {
		this.dk = dk;
	}

	@Override
	public String toString() {
		return "WeightRoom [dk=" + dk + ", name=" + name + ", address=" + address + ",\nopeningDate=" + openingDate
				+ ", areaOrDesc=" + areaOrDesc + "]";
	}
}
