package cgi.services.impl;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import cgi.exceptions.BadLimitException;
import cgi.pojos.DoubleKey;
import cgi.pojos.WeightRoom;
import cgi.services.WeightRoomService;

public class WeightRoomServiceImpl implements WeightRoomService {
	
	private Map<DoubleKey,WeightRoom<?>> weightRooms;
	
	public WeightRoomServiceImpl(WeightRoom<?>[] data){
		weightRooms = new TreeMap<DoubleKey, WeightRoom<?>>();
		for(WeightRoom<?> wr:data){
			weightRooms.put(wr.getDk(), wr);
		}
	}
	
	@Override
	public Set<DoubleKey> getKeys(){
		return weightRooms.keySet();
	}
	
	@Override
	public Collection<WeightRoom<?>> getValues(){
		return weightRooms.values();
	}

	@Override
	public Vector<String> getSomeWeightRoomAddresses(int limit) throws BadLimitException{
		if(limit>weightRooms.size()){
			throw new BadLimitException("vous souhaitez récupérer + d'adresses qu'il n'y en a ("+weightRooms.size()+")");
		}else if(limit<1){
			throw new BadLimitException("Vous devez récupérer au moins une adresse");
		}else{
			Vector<String> adresses = new Vector<String>();
			int count = 0;
			Iterator<WeightRoom<?>> ivalues = this.getValues().iterator();
			while(ivalues.hasNext()&&count<limit){
				adresses.add(ivalues.next().getAddress());
				count++;
			}
			return adresses;
		}
	}

	@Override
	public String getOpeningDatesByYear(Year y) {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRoom<?>> ivalues = this.getValues().iterator();
		while(ivalues.hasNext()){
			WeightRoom<?> wr = ivalues.next();
			if(wr.getOpeningDate().getYear() == y.getValue()){
				sb.append(wr.getOpeningDate());
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	@Override
	public String getRoomNames() {
		StringBuilder sb = new StringBuilder();
		Iterator<WeightRoom<?>> ivalues = this.getValues().iterator();
		while(ivalues.hasNext()){
				sb.append(ivalues.next().getName());
				sb.append(",");
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}

	@Override
	public List<String> getRoomWithArea() {
		List<String> roomsArea = new ArrayList<String>();
		Iterator<WeightRoom<?>> ivalues = this.getValues().iterator();
		while(ivalues.hasNext()){
			WeightRoom<?> wr = ivalues.next();
			if(wr.getAreaOrDesc() instanceof Integer){
				roomsArea.add("|"+wr.getName()+"|");
			}
		}
		return roomsArea;
	}

	@Override
	public int getNbRoomsWithDesc() {
		int count = 0;
		Iterator<WeightRoom<?>> ivalues = this.getValues().iterator();
		while(ivalues.hasNext()){
			WeightRoom<?> wr = ivalues.next();
			if(wr.getAreaOrDesc() instanceof String){
				count++;
			}
		}
		return count;
	}

}
