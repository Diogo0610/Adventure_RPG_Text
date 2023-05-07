package game;

public class UIMethods {
	
	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
	}
	
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
}
