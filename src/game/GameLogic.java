package game;
import java.util.Scanner;

public class GameLogic {
	static Scanner scanner = new Scanner(System.in);
	static UIMethods ui = new UIMethods();
	static Progression progression = new Progression();
	Story story = new Story();
	static Player player;
	public static boolean isRunning;
	
	public static int readInt(String prompt, int userChoices) {
		int input;
		
		do{
			System.out.print(prompt + " ");
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
	
	public static void anythingToContinue() {
		System.out.println("\nEnter anything to continue...");
		scanner.next();
	}
	
	public void startGame() {
		boolean nameSet = false;
		String name;
		//print title screen
		ui.clearConsole();
		ui.printSeparator(40);
		ui.printSeparator(30);
		System.out.println("Title");
		ui.printSeparator(40);
		ui.printSeparator(30);
		anythingToContinue();
		
		
		do {
			ui.clearConsole();
			ui.printHeading("Whats your name?");
			name = scanner.next();
			//correct name
			ui.clearConsole();
			ui.printHeading("Your name is: " + name + ".\nIs that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No! I want to change my name!");
			int input = GameLogic.readInt("->", 2);
			if (input == 1) {
				nameSet = true;
			}
		} while(!nameSet);
		
		story.printIntro();
		
		//cria o jogador
		player = new Player(name);
		
		story.printFirstActIntro();
		
		isRunning = true;
		
		//começa o jogo
		gameLoop();
	}
	
	public void characterInfo() {
		ui.clearConsole();
		ui.printHeading("Character Info");
		System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
		ui.printSeparator(20);
		System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
		ui.printSeparator(20);
		System.out.println("Potions: " + player.pots);
		ui.printSeparator(20);
		
		//printing traits
		if(player.numAtkUpgrades > 0) {
			System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
			ui.printSeparator(20);
		}
		if(player.numDefUpgrades > 0) {
			System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
			ui.printSeparator(20);
		}
		
		anythingToContinue();
	}
	
	public void shop() {
		ui.clearConsole();
		ui.printHeading("You meet a mysterious Stranger.\nHe offers you something:");
		int price = (int)(Math.random() * (10 + player.pots * 3) + 10 + player.pots);
		System.out.println("- Magic Potion: " + price + " gold.");
		ui.printSeparator(20);
		System.out.println("Do you want to buy one?\n(1) Yes\n(2) No, thank you");
		int input = readInt("->", 2);
		
		if(input ==1) {
			ui.clearConsole();
			if(player.gold > price) {
				ui.printHeading("You bought a magical potion for " + price + " gold");
				player.pots++;
				player.gold -= price;
			}
			else {
				ui.printHeading("You don't have money to buy this!");
				anythingToContinue();
			}
		}
	}
	
	public void gameLoop() {
		while(isRunning) {
			progression.journeyOptions();
			int input = readInt("->", 3);
			if(input == 1) {
				progression.continueJourney();
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
