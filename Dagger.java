public class Dagger extends Weapon{

	public Dagger(){
		super(1, 6);
	}

	public int getHits(){
		return super.getRandomNum(1, 4);
	}

	public String getName(){
		return "Dagger";
	}
	
	public String getEffect(){
		return "Bleeding";
	}
}
