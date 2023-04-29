package game;

public class Progression {
	UIMethods ui = new UIMethods();
	Battle battle;
	public int place = 0, act = 1;
	public String[] places = {"Everlasting Moutains", "Haunted LandLines", "Castle", "Throne Room"};
	public String[] encounters = {"Battle", "Battle", "Rest", "Rest", "Shop"};
	public String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};
	
	public void checkAct() {
		if(GameLogic.player.xp >= 10 && act == 1) {
			act = 2;
			place = 1;
			GameLogic.player.chooseTrait();
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Rest";
			encounters[4] = "Shop";
			enemies[0] = "Evil Mercenary";
			enemies[1] = "Goblin";
			enemies[2] = "Wolve Pack";
			enemies[3] = "Evil Emperor";
			enemies[4] = "Scary Stranger";
			GameLogic.player.hp = GameLogic.player.maxHp;
		}
		else if(GameLogic.player.xp >= 50 && act == 2) {
			act = 3;
			place = 2;
			GameLogic.player.chooseTrait();
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Rest";
			encounters[4] = "Shop";
			enemies[0] = "Evil Mercenary";
			enemies[1] = "Goblin";
			enemies[2] = "Wolve Pack";
			enemies[3] = "Evil Emperor";
			enemies[4] = "Scary Stranger";
			GameLogic.player.hp = GameLogic.player.maxHp;
		}
		else if(GameLogic.player.xp >= 100 && act == 3) {
			act = 4;
			place = 3;
			GameLogic.player.chooseTrait();
			GameLogic.player.hp = GameLogic.player.maxHp;
			finalBattle();
		}
	}
	
	public void randomEncounter() {
		int encounter = (int)(Math.random() * encounters.length);
		
		if(encounters[encounter].equals("Battle")) {
			randomBattle();
		}
		else if(encounters[encounter].equals("Rest")) {
			takeRest();
		}
		else {
			//shop();
		}
	}
	
	public void takeRest() {
		ui.clearConsole();
		if(GameLogic.player.restsLefts >= 1) {
			ui.printHeading("Do you want to take a rest?(" + GameLogic.player.restsLefts + " rests lefts).");
			System.out.println("(1) Yes\n(2) No");
			int input = GameLogic.readInt("->", 2);
			if(input == 1) {
				ui.clearConsole();
				if(GameLogic.player.hp < GameLogic.player.maxHp) {
					int hpRestored = (int) (Math.random() * (GameLogic.player.xp / 4 + 1) + 10);
					GameLogic.player.hp += hpRestored;
					if(GameLogic.player.hp > GameLogic.player.maxHp) {
						GameLogic.player.hp = GameLogic.player.maxHp;
					}
					System.out.println("You took a rest and restored " + hpRestored + " hp!");
					System.out.println("You're now at " + GameLogic.player.hp + "/" + GameLogic.player.maxHp + " health.");
					GameLogic.player.restsLefts--;
				}
			}
			else {
				System.out.println("You don't rest.");
			}
			GameLogic.anythingToContinue();
		}
	}
	
	public void randomBattle() {
		ui.clearConsole();
		ui.printHeading("Battle Time!");
		GameLogic.anythingToContinue();
		new Battle(new Enemy(enemies[(int)Math.random()*enemies.length], GameLogic.player.xp));
	}
	
	public void continueJourney() {
		checkAct();
		if(act != 4) {
			randomEncounter();
		}
	}
	
	public void finalBattle() {
		new Battle(new Enemy("Evil Emperor", 300));
		GameLogic.isRunning = false;
	}
	
	public void journeyOptions() {
		ui.clearConsole();
		ui.printHeading(places[place]);
		System.out.println("Select a action: ");
		ui.printSeparator(20);
		System.out.println("(1) Continue Journey");
		System.out.println("(2) Character Info");
		System.out.println("(3) Exit Game");
	}
	
	public void playerDied() {
		ui.clearConsole();
		System.out.println("YOU DIED! TRY AGAIN!");
		System.out.println("You earned " + GameLogic.player.xp + " XP!");
		GameLogic.isRunning = false;
	}
}


