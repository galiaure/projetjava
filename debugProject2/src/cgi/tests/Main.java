package cgi.tests;

import java.time.Year;

import cgi.exceptions.BadLimitException;
import cgi.pojos.DoubleKey;
import cgi.pojos.WeightRoom;
import cgi.services.WeightRoomService;
import cgi.services.impl.WeightRoomServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		WeightRoom<Integer> wr1 = new WeightRoom<Integer>("Basic Fit","3 rue pasteur 69000 Lyon","18/09/2013",80);
		WeightRoom<String> wr2 = new WeightRoom<String>("Appart Fitness","35 rue de la république 69000 Lyon",
				"19/10/2014","salle canon");
		WeightRoom<String> wr3 = new WeightRoom<String>("Elixia","10 rue toto 59000 Lille",
				"12/05/2012","salle extraordinaire");
		WeightRoom<Integer> wr4 = new WeightRoom<Integer>("Océa","3 rue de la république 69000 Lyon",
				"22/03/2012",70);
		WeightRoom<String> wr5 = new WeightRoom<String>("Lady fitness","90 rue de la république 69000 Lyon",
				"11/01/2014","salle magique");
		WeightRoom[] data = new WeightRoom[5];
		data[0] = wr1;
		data[1] = wr2;
		data[2] = wr3;
		data[3] = wr4;
		data[4] = wr5;
		WeightRoomService wrs = new WeightRoomServiceImpl(data);
		System.out.println("Liste des clés : ");
		for(DoubleKey dk:wrs.getKeys()){
			System.out.println(dk);
		}
		System.out.println("Liste des valeurs : ");
		for(WeightRoom<?> wr: wrs.getValues()){
			System.out.println(wr);
		}
		
		System.out.println("Récupération des 3 premières adresses : ");
		try {
			for(String address: wrs.getSomeWeightRoomAddresses(3)){
				System.out.println(address);
			}
			wrs.getSomeWeightRoomAddresses(6);
		} catch (BadLimitException e) {
			e.printStackTrace();
		}
		
		try {
			wrs.getSomeWeightRoomAddresses(0);
		} catch (BadLimitException e) {
			e.printStackTrace();
		}
		
		System.out.println("Liste des dates d'ouverture dont l'année est 2012 : "+wrs.getOpeningDatesByYear(Year.of(2012)));
		System.out.println("noms des salles : \n"+wrs.getRoomNames());
		System.out.println("Liste des salles dont on a la superficie : ");
		for(String name : wrs.getRoomWithArea()){
			System.out.println(name);
		}
		System.out.println("Nombre de salles dont on a la description : "+wrs.getNbRoomsWithDesc());
	}

}
