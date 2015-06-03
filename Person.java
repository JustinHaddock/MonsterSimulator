public class Person{
	

	public int num;
	public Weapon weapon;
	public int health;
	public boolean alive;

	public Person(int number, Weapon weapon, int health){
		this.num = number;
		this.weapon = weapon;
		this.health = health;
		this.alive = true;
	}

	public void attack(Monster monster){
		int hits = weapon.getHits();
		if (hits > 1){
			System.out.println("Person " + getName() + " got to hit " + Integer.toString(hits) + " times!");
		}
		for (int i = 0; i < hits; i++){
			int damage = weapon.getDamage();
			System.out.println("Person " + getName() + " dealt " + Integer.toString(damage) + " to the " + monster.getName() + " with his " + weapon.getName());
			monster.getHit(damage);
			System.out.println(monster.getName() + " has " + Integer.toString(monster.getHealth()) + " health left.\n");
		}
	}

	public String getWeapon(){
		return weapon.getName();
	}

	public int getHealth(){
		return health;
	}

	public String getName(){
		return Integer.toString(num);
	}

	public void getHit(int damage){
		System.out.println("Person " + getName() + " suffered a " + Integer.toString(damage) + " damage attack!");
		System.out.println("Person " + getName() + " has " + Integer.toString(health) + " health left.\n");
		health -= damage;
		if (health <= 0){
			alive = false;
		}
	}
}		
