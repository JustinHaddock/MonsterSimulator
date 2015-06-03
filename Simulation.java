import java.util.Random;
import java.util.ArrayList;

public class Simulation{
	public static ArrayList<Person> warriors = new ArrayList<>();
	public static Monster monster;
	public static ArrayList<Weapon>  weapons = new ArrayList<>();
	public static int warriorNum = 50;
	public static Random rand = new Random();


	public static void initializeWarriors(int warriorNum){
		for (int i = 1; i <= warriorNum; i++){
			warriors.add(new Person(i, getWeapon(), 20));
		}

	}
	public static void initializeMonster(){
		monster = new Monster("Nessie",1000, 10, 20); 
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

	public static boolean fight(Person warr, Monster mon){
		while(warr.alive && mon.alive){
			warr.attack(mon);
			mon.attack(warr);
			System.out.println("--------------------------------------");
		}
		if (mon.alive == false){
			win(warr);
			return false;
		}
		return true;
	}

	public static void win(Person winrar){
		System.out.println("\n\nHumans win!");
		System.out.println("It only took " + winrar.getName() + " People!\n");
	}

	public static void main(String args[]){
		initializeMonster();
		initializeWeapons();
		initializeWarriors(warriorNum);
		
		for (Person warr : warriors){
			boolean cont = fight(warr, monster);
			if (cont){}
			else{
				break;
			}
		}
	}


}
