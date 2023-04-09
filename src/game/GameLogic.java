package game;
import java.util.Scanner;

public class GameLogic {
	static Scanner scanner = new Scanner(System.in);
	static Player player;
	
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
		player = new Player(name);
	}
}
