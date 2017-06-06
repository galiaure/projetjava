package cgi.pojos;

public class DoubleKey implements Comparable<DoubleKey> {
	
	private float key1;
	private float key2;
	
	public DoubleKey(float key1, float key2){
		this.key1 = key1;
		this.key2 = key2;
	}

	public float getKey1() {
		return key1;
	}

	public void setKey1(float key1) {
		this.key1 = key1;
	}

	public float getKey2() {
		return key2;
	}

	public void setKey2(float key2) {
		this.key2 = key2;
	}
	
	@Override
	public String toString(){
		return "["+key1+","+key2+"]";
	}

	@Override
	public int compareTo(DoubleKey dk) {
		return new Float(this.getKey1()).compareTo(new Float(this.getKey2()));
	}

}
