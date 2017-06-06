package cgi.services;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import cgi.exceptions.BadLimitException;
import cgi.pojos.DoubleKey;
import cgi.pojos.WeightRoom;

public interface WeightRoomService {
	public Set<DoubleKey> getKeys(); //ok
	public Collection<WeightRoom<?>> getValues(); //ok
	public Vector<String> getSomeWeightRoomAddresses(int limit) throws BadLimitException; //ok
	public String getOpeningDatesByYear(Year y);
	public String getRoomNames(); //ok
	public List<String> getRoomWithArea(); //ok
	public int getNbRoomsWithDesc(); //ok
}
