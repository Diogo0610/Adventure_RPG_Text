package game;

public class Player extends Character{
	
	UIMethods ui = new UIMethods();
	
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

		return (int)(Math.random() * (xp / 4 + numAtkUpgrades * 3 + 3) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
	}

	@Override
	public int defend() {

		return (int)(Math.random() * (xp / 4 + numAtkUpgrades * 3 + 3) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
	}

	public void chooseTrait() {
		ui.clearConsole();
		ui.printHeading("Choose a trait:");
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		
		//getting player input
		int input = GameLogic.readInt("-> ", 2);
		ui.clearConsole();
		
		//deal with cases
		if(input == 1) {
			ui.printHeading("You choose: " + atkUpgrades[numAtkUpgrades]);
			numAtkUpgrades++;
		} else {
			ui.printHeading("You choose: " + defUpgrades[numDefUpgrades]);
			numDefUpgrades++;
		}
		GameLogic.anythingToContinue();
		
	}
}
