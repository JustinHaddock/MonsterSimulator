import java.util.Random;
import java.util.ArrayList;

public class Simulation{
	public static ArrayList<Person> warriors = new ArrayList<>();
	public static Monster monster;
	public static ArrayList<Weapon>  weapons = new ArrayList<>();
	public static int warriorNum = 50;
	public static Random rand = new Random();


	public static void initializeWarriors(int warriorNum){
		for (int i = 0; i < warriorNum; i++){
			warriors.add(new Person(i, getWeapon(), 50));
		}

	}
	public static void initializeMonster(){
		monster = new Monster("Nessie",100, 10, 50); 
	}

	public static void initializeWeapons(){
		Dagger d = new Dagger();
		Mace m = new Mace();
		weapons.add(d);
		weapons.add(m);
	}

	public static Weapon getWeapon(){
		int low = 0;
		int high = weapons.size() - 1;
		return weapons.get(getRandomNum(low, high));
	}

	public static int getRandomNum(int low, int high){
		return rand.nextInt((high - low) +1) +low;
	}

	public static void main(String args[]){
		initializeMonster();
		initializeWeapons();
		initializeWarriors(warriorNum);
		
		for (Person warr : warriors){
			fight(warr, monster);
		}
	}

	pubic void fight(Person warr, Monster mon){
		
	}


}
