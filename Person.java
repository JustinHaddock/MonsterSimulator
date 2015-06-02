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
		for (int i = 0; i < hits; i++){
			int damage = weapon.getDamage();
			System.out.println("Person " + getName() +" dealt " + Integer.toString(damage) + " to the " + monster.getName() + " with his " + weapon.getName() + "\n");
			monster.getHit(damage);
			System.out.println(monster.getName() + " has " + Integer.toString(monster.getHealth()) + " health left.\n");
		}
	}

	public int getHealth(){
		return health;
	}

	public String getName(){
		return Integer.toString(num);
	}

	public void getHit(int damage){
		health -= damage;
		if (health <= 0){
			alive = false;
		}
	}
}		
