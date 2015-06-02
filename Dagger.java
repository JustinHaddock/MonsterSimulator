public class Dagger extends Weapon{

	public Dagger(int dmgHigh, int dmgLow){
		super(5, 10);
	}

	public int getHits(){
		return super.getRandomNum(3, 6);
	}

	public String getName(){
		return "Dagger";
	}
	
	public String getEffect(){
		return "Bleeding";
	}
}
