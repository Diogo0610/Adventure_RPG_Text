package game;

import java.util.Scanner;

public class Input {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int read(int userChoices) {
		int input;
		String s = "->";
		
		do{
			System.out.print(s + " ");
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
		Input.scanner.next();
	}
}