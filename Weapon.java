import java.util.Random;

public abstract class Weapon{
	
	public int dmgHigh;
	public int dmgLow;
	public Random rand;

	
	public Weapon(int dmgHigh, int dmgLow){
		this.dmgHigh = dmgHigh;
		this.dmgLow = dmgLow;
	}

	abstract int getHits();

	abstract String getEffect();

	abstract String getName();

	public int getDamage(){
		return getRandomNum(dmgLow, dmgHigh);
	}

	public int getRandomNum(int low, int high){
		return rand.nextInt((high - low) +1) +low;
	}

}
