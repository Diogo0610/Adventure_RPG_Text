package game;

public class Player extends Character{
	
	//store number of upgrades/skill in each path
	public int numAtkUpgrades, numDefUpgrades;
	
	int gold, restsLefts, pots;
	
	//Arrays to store skill names
	public String[] atkUpgrades = {"Strengh", "Power", "Might", "Godlike Strenght"};
	public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

	public Player(String name) {
		// calling constructor of superclass
		super(name, 100, 0);
		
		//Setting # of Upgrades
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		this.gold = 5;
		this.restsLefts = 1;
		this.pots = 0;
		chooseTrait();
	}

	@Override
	public int attack() {

		return (int)(Math.random() * (getXp() / 4 + numAtkUpgrades * 3 + 3) + getXp() / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
	}

	@Override
	public int defend() {

		return (int)(Math.random() * (getXp() / 4 + numAtkUpgrades * 3 + 3) + getXp() / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
	}

	public void chooseTrait() {
		UIMethods.clearConsole();
		UIMethods.printHeading("Choose a trait:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		
		//getting player input
		int input = Input.read(2);
		UIMethods.clearConsole();
		
		//deal with cases
		if(input == 1) {
			UIMethods.printHeading("You choose: " + atkUpgrades[numAtkUpgrades]);
			numAtkUpgrades++;
		} else {
			UIMethods.printHeading("You choose: " + defUpgrades[numDefUpgrades]);
			numDefUpgrades++;
		}
		Input.anythingToContinue();
		
	}
}
