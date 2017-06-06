package hb.utils;

import java.util.HashMap;
import java.util.Map;

public class DictionnaryColor {
	
	private Map <String, String> colorDicoFrenchToEnglish = new HashMap<String,String>();
	private Map <String, String> colorDicoEnglishToFrench = new HashMap<String,String>();
	
	public DictionnaryColor() {
	
	colorDicoFrenchToEnglish.put("rouge","red");
	colorDicoFrenchToEnglish.put("bleu","blue");
	colorDicoFrenchToEnglish.put("jaune","yelow");
	colorDicoFrenchToEnglish.put("blanc","white");
	colorDicoFrenchToEnglish.put("noir","black");
	colorDicoFrenchToEnglish.put("violet","purple");
	colorDicoFrenchToEnglish.put("rose","pink");
	colorDicoFrenchToEnglish.put("vert","green");
	colorDicoFrenchToEnglish.put("marron","brown");
	
	colorDicoEnglishToFrench.put("red","rouge");
	colorDicoEnglishToFrench.put("blue","bleu");
	colorDicoEnglishToFrench.put("yelow","jaune");
	colorDicoEnglishToFrench.put("white","blanc");
	colorDicoEnglishToFrench.put("black","noir");
	colorDicoEnglishToFrench.put("purple","violet");
	colorDicoEnglishToFrench.put("pink","rose");
	colorDicoEnglishToFrench.put("green","vert");
	colorDicoEnglishToFrench.put("brown","marron");
	
	}
	
	
	public String getColorInEnglish(String frenchColor){
		return this.colorDicoFrenchToEnglish.get(frenchColor);
	}
	
	public String getColorInFrench(String englishColor){
		return this.colorDicoEnglishToFrench.get(englishColor);
	}
	
	public DoubleColor getColorsInEnglish(DoubleColor frenchColors){
		DoubleColor englishColors = new DoubleColor(
				this.colorDicoFrenchToEnglish.get(frenchColors.getColor1()),
				this.colorDicoFrenchToEnglish.get(frenchColors.getColor2()));
		return englishColors;
	}
	
	public DoubleColor getColorsInFrench(DoubleColor englishColors){
		DoubleColor frenchColors = new DoubleColor(
				this.colorDicoEnglishToFrench.get(englishColors.getColor1()),
				this.colorDicoEnglishToFrench.get(englishColors.getColor2()));
		return frenchColors;
	}
	
		

}
