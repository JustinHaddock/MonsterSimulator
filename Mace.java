public class Mace extends Weapon{

	public Mace(){
		super(5, 10);
	}

	public int getHits(){
		return 1;
	}

	public String getName(){
		return "Mace";
	}

	public String getEffect(){
		return "Blunt";
	}
}
