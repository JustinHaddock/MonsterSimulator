import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/*
 @Author: Justin Haddock
 Fight simulator
 */

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
	public static void initializeMonster(String data){
		String[] usableData  = data.split(" ");
		monster = new Monster(usableData[0], Integer.parseInt(usableData[1]), Integer.parseInt(usableData[2]), Integer.parseInt(usableData[3])); 
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
		}
		if (mon.alive == false){
			// The monster was defeated
			win(warr);
			return false;
		}
		// If the monster didn't die, the person must have
		System.out.println("Person " + warr.getName() + " died!\n------------------------------------------------------------");
		return true;
	}

	public static void win(Person winrar){
		System.out.println("\n\nHumans win!");
		System.out.println("Person " + winrar.getName() + " is a hero!\n");
	}

	public static void lose(Monster monster){
		System.out.println("The monster won! Earth lies in ruin as the human race gasps for it's final breaths...");
		System.out.println("The monster won with " + Integer.toString(monster.getHealth()) + " health left.\n");
	}

	public static String getUserInput(){
		Scanner in = new Scanner(System.in);
      	String s = in.nextLine();
     	System.out.println("Thanks! ");
     	in.close();
     	return s;
	}

	public static void main(String args[]){
      	System.out.println("Welcome to the Monster Battle simulator");
      	System.out.println("First you will decide on what monster to fight.");
      	System.out.println("First, I need some data for the monster. Enter a name, HP amount, minimum attack and maximum attack like so:");
      	System.out.println("\t Ogre 2000 10 20");
      	String monsterData = getUserInput();
      	System.out.println("For now we will just use 100 people");
      	//System.out.println("Alright! Now I need data for some warriors.");
      	//System.out.println("Now I need some data for some warriors. All I need is a quantity");
      	//String personData = getUserInput();


		initializeMonster(monsterData);
		initializeWeapons();
		initializeWarriors(100);
		
		for (Person warr : warriors){
			boolean cont = fight(warr, monster);
			if (cont){}
			else{
				System.exit(0);
			}
			try {
   				 Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
 				   Thread.currentThread().interrupt();
			}
		}
		lose(monster);
	}


}
