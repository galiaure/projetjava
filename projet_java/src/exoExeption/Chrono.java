package exoExeption;

public class Chrono {
	private int counter = 0;

	
	public void play() throws NoMoreTimeAvailable {
		this.counter++;
		if(counter > 5){
			throw new NoMoreTimeAvailable ("plus de temps!");
		}
	}
	
	public static void main(String[] args) {
		Chrono chrono = new Chrono();
		try {
			chrono.play();
			chrono.play();
			chrono.play();
			chrono.play();
			chrono.play();
			chrono.play();
		}catch (NoMoreTimeAvailable e) {
			e.printStackTrace();
		}
	}

}
