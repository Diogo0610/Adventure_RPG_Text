package game;
import java.util.Scanner;

public class GameLogic {
	static Scanner scanner = new Scanner(System.in);
	static Player player;
	public static boolean isRunning;
	public static int place = 0, act = 1;
	public static String[] places = {"Everlasting Moutains", "Haunted LandLines", "Castle", "Throne Room"};
	public static String[] encounters = {"Battle", "Battle", "Rest", "Rest", "Shop"};
	public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};
	
	public static int readInt(String prompt, int userChoices) {
		int input;
		
		do{
			System.out.println(prompt);
			try{
				input = Integer.parseInt(scanner.next());
			}
			catch(Exception e){
				input = -1;
				System.out.println("Please enter an integer");
			}
		}while(input < 1 || input > userChoices);
		return input;
	}
	
	//simulate console cleaning
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	//print a separator with length n
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}
	
	public static void anythingToContinue() {
		System.out.println("\nEnter anything to continue...");
		scanner.next();
	}
	
	public static void startGame() {
		boolean nameSet = false;
		String name;
		//print title screen
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("Title");
		printSeparator(40);
		printSeparator(30);
		anythingToContinue();
		
		
		do {
			clearConsole();
			printHeading("Whats your name?");
			name = scanner.next();
			//correct name
			clearConsole();
			printHeading("Your name is: " + name + ".\nIs that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No! I want to change my name!");
			int input = GameLogic.readInt("->", 2);
			if (input == 1) {
				nameSet = true;
			}
		} while(!nameSet);
		
		Story.printIntro();
		
		//cria o jogador
		player = new Player(name);
		
		Story.printFirstActIntro();
		
		isRunning = true;
		
		//começa o jogo
		gameLoop();
	}
	
	public static void checkAct() {
		if(player.xp >= 10 && act == 1) {
			act = 2;
			place = 1;
			Story.printFirstActOutro();
			player.chooseTrait();
			Story.printSecondActIntro();
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
			player.hp = player.maxHp;
		}
		else if(player.xp >= 50 && act == 2) {
			act = 3;
			place = 2;
			Story.printSecondActOutro();
			player.chooseTrait();
			Story.printThirdActIntro();
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
			player.hp = player.maxHp;
		}
		else if(player.xp >= 100 && act == 3) {
			act = 4;
			place = 3;
			Story.printThirdActOutro();
			player.chooseTrait();
			Story.printFourthActIntro();
			player.hp = player.maxHp;
			finalBattle();
		}
	}
	
	public static void randomEncounter() {
		int encounter = (int)(Math.random() * encounters.length);
		
		if(encounters[encounter].equals("Battle")) {
			randomBattle();
		}
		else if(encounters[encounter].equals("Rest")) {
			takeRest();
		}
		else {
			shop();
		}
	}
	
	public static void continueJourney() {
		checkAct();
		if(act != 4) {
			randomEncounter();
		}
	}
	
	public static void characterInfo() {
		clearConsole();
		printHeading("Character Info");
		System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
		printSeparator(20);
		System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
		printSeparator(20);
		System.out.println("Potions: " + player.pots);
		printSeparator(20);
		
		//printing traits
		if(player.numAtkUpgrades > 0) {
			System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
			printSeparator(20);
		}
		if(player.numDefUpgrades > 0) {
			System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
			printSeparator(20);
		}
		
		anythingToContinue();
	}
	
	public static void shop() {
		clearConsole();
		printHeading("You meet a mysterious Stranger.\nHe offers you something:");
		int price = (int)(Math.random() * (10 + player.pots * 3) + 10 + player.pots);
		System.out.println("- Magic Potion: " + price + " gold.");
		printSeparator(20);
		System.out.println("Do you want to buy one?\n(1) Yes\n(2) No, thank you");
		int input = readInt("->", 2);
		
		if(input ==1) {
			clearConsole();
			if(player.gold > price) {
				printHeading("You bought a magical potion for " + price + " gold");
				player.pots++;
				player.gold -= price;
			}
			else {
				printHeading("You don't have money to buy this!");
				anythingToContinue();
			}
		}
	}
	
	public static void takeRest() {
		clearConsole();
		if(player.restsLefts >= 1) {
			printHeading("Do you want to take a rest?(" + player.restsLefts + " rests lefts).");
			System.out.println("(1) Yes\n(2) No");
			int input = readInt("->", 2);
			if(input == 1) {
				clearConsole();
				if(player.hp < player.maxHp) {
					int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
					player.hp += hpRestored;
					if(player.hp > player.maxHp) {
						player.hp = player.maxHp;
					}
					System.out.println("You took a rest and restored " + hpRestored + " hp!");
					System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
					player.restsLefts--;
				}
			}
			else {
				System.out.println("You don't rest.");
			}
			anythingToContinue();
		}
	}
	
	public static void randomBattle() {
		clearConsole();
		printHeading("Battle Time!");
		anythingToContinue();
		battle(new Enemy(enemies[(int)Math.random()*enemies.length], player.xp));
	}
	
	public static void battle(Enemy enemy) {
		while(true) {
			clearConsole();
			printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
			printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
			System.out.println("Choose a action");
			printSeparator(20);
			System.out.println("(1) Fight\n(2) Use Potion\n(3) Run!");
			int input = readInt("->", 3);
			
			if(input == 1) {
				int dmg = player.attack() - enemy.defend();
				int dmgTook = enemy.attack() - enemy.defend();
				
				if(dmgTook < 0) {
					dmg -= dmgTook/2;
					dmgTook = 0;
				}
				if(dmg < 0) {
					dmg = 0;
				}
				player.hp -= dmgTook;
				enemy.hp -= dmg;
				
				clearConsole();
				printHeading("BATTLE");
				System.out.println("You dealt " + dmg + " damage to " + enemy.name + ".");
				printSeparator(15);
				System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
				anythingToContinue();
				
				if(player.hp <= 0) {
					playerDied();
					break;
				}
				else if(enemy.hp <= 0) {
					clearConsole();
					System.out.println("You defeated the " + enemy.name + "!");
					player.xp += enemy.xp;
					System.out.println("You earned " + enemy.xp + "XP!");
					boolean addRest = (Math.random() * 5 + 1 <= 2.25);
					int goldEarned = (int) (Math.random() * enemy.xp);
					if(addRest) {
						player.restsLefts++;
						System.out.println("You have a chance to rest");
					}
					if(goldEarned > 0) {
						player.gold += goldEarned;
						System.out.println("You collect " + goldEarned + " gold from " + enemy.name + "'s corpse!");
					}
					anythingToContinue();
					break;
				}
			}
			else if(input ==2) {
				//Use potion
				clearConsole();
				if(player.pots > 0 && player.hp < player.maxHp) {
					//can take
					printHeading("Do you want to drink a potion? (" + player.pots + " left).");
					System.out.println("(1) Yes\n(2) No, maybe later");
					input = readInt("->", 2);
					if(input == 1) {
						player.hp = player.maxHp;
						clearConsole();
						printHeading("Your health is now: " + player.maxHp);
						anythingToContinue();
					}
				}
				else {
					printHeading("You don't have any potions or you're at full health");
					anythingToContinue();
				}
			}
			else {
				clearConsole();
				if(act != 4) {
					//35% para escapar
					if(Math.random() *10 + 1 >= 3.5) {
						System.out.println("You ran away");
						anythingToContinue();
						break;
					}
					else {
						printHeading("You didn't escape");
						int dmgTook = enemy.attack();
						System.out.println("You took" + dmgTook + "damage!");
						anythingToContinue();
						if(player.hp <= 0) {
							playerDied();
						}
					}
				}
				else {
					System.out.println("You cannot escape");
					anythingToContinue();
				}
			}
		}
	}
	
	public static void printMenu() {
		clearConsole();
		printHeading(places[place]);
		System.out.println("Select a action: ");
		printSeparator(20);
		System.out.println("(1) Continue Journey");
		System.out.println("(2) Character Info");
		System.out.println("(3) Exit Game");
	}
	
	public static void finalBattle() {
		battle(new Enemy("Evil Emperor", 300));
		Story.printEnd(player);
		isRunning = false;
	}
	
	public static void playerDied() {
		clearConsole();
		System.out.println("YOU DIED! TRY AGAIN!");
		System.out.println("You earned " + player.xp + " XP!");
		isRunning = false;
	}
	
	public static void gameLoop() {
		while(isRunning) {
			printMenu();
			int input = readInt("->", 3);
			if(input == 1) {
				continueJourney();
			}
			else if(input == 2) {
				characterInfo();
			}
			else {
				isRunning = false;
			}
		}
	}
}
