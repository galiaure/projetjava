package hb.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hb.pojos.Flower;
import hb.services.FlowerService;
import hb.utils.FlowerName;

public class FlowerServiceImpl implements FlowerService {
	
	public List<Flower> flowers;
	
	public FlowerServiceImpl(){
		flowers = new ArrayList<Flower>();
		Calendar c = Calendar.getInstance();
		c.set(2017, 4,28);
		Flower f1 = new Flower(FlowerName.Jacinthe.ordinal(),FlowerName.Jacinthe.getName(),
						"Magnifique fleur romantique",c.getTime(),"rouge");
		flowers.add(f1);
		c.set(2017, 4,23);
		Flower f2 = new Flower(FlowerName.Lilas.ordinal(),FlowerName.Lilas.getName(),
				"Une douceur magnifique",c.getTime(),"rose");
		flowers.add(f2);
		c.set(2017, 4,22);
		Flower f3 = new Flower(FlowerName.Lilas.ordinal(),FlowerName.Lilas.getName(),
				"Fleur classique mais qui a du charme",c.getTime(),"jaune");
		flowers.add(f3);
		c.set(2017, 4,20);
		Flower f4 = new Flower(FlowerName.Orchidée.ordinal(),FlowerName.Orchidée.getName(),
				"Fleur d'une beauté fatale",c.getTime(),"blanche");
		flowers.add(f4);
		Flower f5 = new Flower(FlowerName.Rose.ordinal(),FlowerName.Rose.getName(),
				"L'amour dans toute sa splendeur",c.getTime(),"rouge");
		flowers.add(f5);
		c.set(2017, 4,20);
		Flower f6 = new Flower(FlowerName.Tulipe.ordinal(),FlowerName.Tulipe.getName(),
				"Tout le monde aime les tulipes",c.getTime(),"bleu");
		flowers.add(f6);
		Flower f7 = new Flower(FlowerName.Violette.ordinal(),FlowerName.Violette.getName(),
				"Quelle douceur",c.getTime(),"violette");
		flowers.add(f7);
	}

	@Override
	public String[] getFlowersName() {
		String[] names = new String[flowers.size()-1];
		int count = 0;
		for(Flower f:flowers){
			names[count] = f.getName();
		}
		return names;
	}

	//Pour récupérer les fleurs dont la date d'expiration est après la date
	//passée en paramètres.
	@Override
	public List<Flower> getFlowersByExpiryDate(Date expiryDate) {
		List<Flower> someFlowers = new ArrayList<Flower>();
		for(Flower f:flowers){
			if(f.getExpiryDate().before(expiryDate)){
				someFlowers.add(f);
			}
		}
		return someFlowers;
	}

	//Pour récupérer la liste des fleurs dont le nom contient la chaîne passée
	//en paramètres
	@Override
	public Flower[] getSomeFlowersByNamePart(String namePart) {
		Flower[] tabFlowers = null;
		int count = 0;
		for(Flower f:flowers){
			if(f.getName().toLowerCase().equals(namePart.toLowerCase())){
				count++;
			}
		}
		tabFlowers = new Flower[count];
		for(Flower f:flowers){
			if(f.getName().toLowerCase().equals(namePart.toLowerCase())){
				tabFlowers[count] = f;
				count++;
			}
		}
		return tabFlowers;
		
	}

	@Override
	public int getNumberOfFlowers() {
		return flowers.size()+1;
	}

	@Override
	public String getDistinctColorsOfFlowers() {
		StringBuilder colors = new StringBuilder();
		for(Flower f:flowers){
			if(!colors.toString().contains(f.getColor())){
				colors.append(",");
				colors.append(f.getColor());
			}
		}
		return colors.toString();
	}

	@Override
	public String[] getNameFlowersByColor(String color) {
		String[] someNames = null;
		int count = 0;
		for(Flower f:flowers){
			if(f.getColor().equals(color)){
				count++;
			}
		}
		count = 0;
		for(Flower f:flowers){
			if(f.getColor().equals(color)){
				 someNames[count] = f.getName();
			}
		}
		return someNames;	
	}
	
	//méthode permettant de récupérer dans un tableau la taille des noms de fleurs
	@Override
	public int[] getSizeOfFlowersName() {
		int[] sizes = new int[FlowerName.values().length];
		int count = 0;
		for(FlowerName fn : FlowerName.values()){
			sizes[count] = fn.lengthOfName();
			count++;
		}
		return sizes;
	}

}
