import java.util.Random;

public class Monster{
	
	public String name;
	public String effect;
	public int health;
	public int dmgLow;
	public int dmgHigh;
	public boolean alive;
	public Random rand = new Random();

	public Monster(String name, int health, int dmgLow, int dmbHigh){
		this.name = name;
		this.effect = "NONE";
		this.health = health;
		this.dmgLow = dmgLow;
		this.dmgHigh = dmgHigh;
		this.alive = true;
	}

	public void attack(Person p){
		int damage = getRandomNum(dmgLow, dmgHigh);
		System.out.println("Monster " + name + " dealt " + Integer.toString(damage) + " to " + p.getName());
		p.getHit(damage);
	}

	public int getRandomNum(int low, int high){
		return rand.nextInt((high - low) +1) +low;
	}

	public void getHit(int damage){
		health -= damage;
		if (health <= 0){
			alive = false;
		}
	}

	public String getName(){
		return name;
	}

	public int getHealth(){
		return health;
	}
}
