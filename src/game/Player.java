package game;

public class Player extends Character{
	
	//store number of upgrades/skill in each path
	public int numAtkUpgrades, numDefUpgrades;
	
	//Arrays to store skill names
	public String[] atkUpgrades = {"Strengh", "Power", "Might", "Godlike Strenght"};
	public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

	public Player(String name) {
		// calling constructor of superclass
		super(name, 100, 0);
		
		//Setting # of Upgrades
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		chooseTrait();
	}

	@Override
	public int attack() {

		return 0;
	}

	@Override
	public int defend() {

		return 0;
	}

	public void chooseTrait() {
		GameLogic.clearConsole();
		GameLogic.printHeading("Choose a trait:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		
		//getting player input
		int input = GameLogic.readInt("-> ", 2);
		GameLogic.clearConsole();
		
		//deal with cases
		if(input == 1) {
			GameLogic.printHeading("You choose: " + atkUpgrades[numAtkUpgrades]);
			numAtkUpgrades++;
		} else {
			GameLogic.printHeading("You choose: " + defUpgrades[numDefUpgrades]);
			numDefUpgrades++;
		}
		GameLogic.anythingToContinue();
		
	}
}
