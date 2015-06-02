public class Simulation{
	public ArrayList<Person> Warriors;
	public Monster monster;
	public ArrayList<Weapons> = weapons;
	public int warriorNum = 50;



	public void initializeWarriors(int warriorNum){
		for (int i = 0; i < warriorNum; i++){
			Warriors.add(new Person(i, getWeapon(), getHealth()));
		}

	}
	public static void main(String args[]){
		initializeWarriors(warriorNum);
		initializeMonster();
		initializeWeapons();
	}


}