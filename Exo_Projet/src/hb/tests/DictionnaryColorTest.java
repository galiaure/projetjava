package hb.tests;

import hb.utils.DictionnaryColor;
import hb.utils.DoubleColor;

public class DictionnaryColorTest {

	public static void main(String[] args) {
		
		DictionnaryColor dc = new DictionnaryColor();
		
		System.out.println("violet en anglais ça donne : "+dc.getColorInEnglish("violet"));
		System.out.println("Blue en français ça donne : "+dc.getColorInFrench("blue"));
		
		DoubleColor dcFrench = new DoubleColor("rose","vert");
		System.out.println("traduction dcFrench : "+dc.getColorsInEnglish(dcFrench));
		
		DoubleColor dcEnglish = new DoubleColor("pink","green");
		System.out.println("traduction dcEnglish : "+dc.getColorsInFrench(dcEnglish));
		
		System.out.println("Liste avant tri");
		
	}

}
