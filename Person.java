import java.util.Random;

public class Person{
	

	public int num;
	public Weapon weapon;
	public int health;
	public boolean alive;
	public Random rand = new Random();

	public Person(int number, Weapon weapon, int health){
		this.num = number;
		this.weapon = weapon;
		this.health = health;
		this.alive = true;
	}

	public void attack(Monster monster){
		//The dagger's ability makes it able to hit multiple times.
		int hits = weapon.getHits();
		boolean countTotal = false;
		int totalDamage = 0;

		//see if special weapon ability will happe
		effectMonster(weapon, monster);
		// Hit multiple times if applicable
		if (hits > 1){
			System.out.println("Person " + getName() + " got to hit " + Integer.toString(hits) + " times!");
			countTotal = true;
		}

		// attack the monster!
		for (int i = 0; i < hits; i++){
			int damage = weapon.getDamage();
			System.out.println("Person " + getName() + " dealt " + Integer.toString(damage) + " to the " + monster.getName() + " with his " + weapon.getName());
			monster.getHit(damage);
			System.out.println(monster.getName() + " has " + Integer.toString(monster.getHealth()) + " health left.\n");
			if (countTotal){
				totalDamage += damage;
			}

		}
		if (countTotal){
			System.out.println("Person " + getName() + " dealt a total of " + Integer.toString(totalDamage) + " to the Monster.\n");
		}
	}

	public String getWeapon(){
		return weapon.getName();
	}

	public int getHealth(){
		return health;
	}


	public static void effectMonster(Weapon weapon, Monster monster){
		double chance = Math.random();
		if (weapon.getName() == "Mace"){
			if (chance > .7){
				Monster.setStatus("DIZZY");
			}
		}
		else if (weapon.getName() == "Dagger") {
			if (chance > .85){
				Monster.setStatus("BLEEDING");
			}
		}
	}


	public String getName(){
		return Integer.toString(num);
	}

	public void getHit(int damage){
		System.out.println("Person " + getName() + " has " + Integer.toString(health) + " health left.\n");
		health -= damage;
		if (health <= 0){
			alive = false;
		}
	}
}		
