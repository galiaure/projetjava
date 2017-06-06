package hb.utils;

public enum FlowerName {
	//nom, type
	Rose("Rose"),
	Tulipe("Tulipe"),
	Orchidée("Orchidée"),
	Jacinthe("Jacinthe"),
	Lilas("Lilas"),
	Violette("Violette"),
	Marguerite("Marguerite");
	
	private String name;
	
	FlowerName(String name){
		this.name = name;
	}
	
	public int lengthOfName(){
		return this.name().length();
	}

	public String getName() {
		return name;
	}
}
