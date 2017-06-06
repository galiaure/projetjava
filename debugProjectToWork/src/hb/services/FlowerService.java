package hb.services;

import java.util.Date;
import java.util.List;

import hb.pojos.Flower;

public interface FlowerService {
	
	public String[] getFlowersName();
	public List<Flower> getFlowersByExpiryDate(Date expiryDate);
	public Flower[] getSomeFlowersByNamePart(String namePart);
	public int getNumberOfFlowers();
	public String getDistinctColorsOfFlowers();
	public String[] getNameFlowersByColor(String color);
	public int[] getSizeOfFlowersName();

}
