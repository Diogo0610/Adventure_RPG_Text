package game;

public class UIMethods {
	
	public UIMethods() {
		
	}
	
	public void clearConsole() {
		System.out.print("\033[H\033[2J");
		//System.out.flush();
	}
	
	public void printSeparator(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}
}
