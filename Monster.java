import java.util.Random;

public class Monster{
	
	public String name;
	public static String effect;
	public int health;
	public int dmgLow;
	public int dmgHigh;
	public boolean alive;
	public Random rand = new Random();

	public Monster(String name, int health, int dmgLow, int dmgHigh){
		this.name = name;
		this.health = health;
		this.dmgLow = dmgLow;
		this.dmgHigh = dmgHigh;
		this.effect = "NONE";
		this.alive = true;
	}

	public void attack(Person p){
		int damage = getRandomNum(dmgLow, dmgHigh);
		damage = modifierAct(damage);
		System.out.println("Monster " + name + " dealt " + Integer.toString(damage) + " to Warrior " + p.getName());
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

	public static void setStatus(String status){
		effect = status;
	}

	public int modifierAct(int damage){
		/*
		the monster could be bleeding or dizzy.
		Bleeding does DOT, and dizziness makes it do less damage.
		*/
		if (effect == "BLEEDING"){
			//This happens with daggers
			int bloodLoss = getRandomNum(1, 3);
			System.out.println("The monster is bleeding! Monster " + getName() + " lost " + Integer.toString(bloodLoss) + " health!");
			health -=bloodLoss;
			return damage;
		}
		else if (effect == "DIZZY") {
			//This happens with maces
			System.out.println(getName() + " is dizzy! " + getName() + " isn't nearly as strong.");
			double dubDamage = (double)damage;
			return (int)Math.ceil((dubDamage*.75));
		}
		return damage;
	}
}
