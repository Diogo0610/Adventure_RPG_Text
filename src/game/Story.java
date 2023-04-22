package game;

public class Story {
	public static void printIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printFirstActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("1 act intro");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printFirstActOutro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("1 act end");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printSecondActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("2 act intro");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printSecondActOutro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("2 act end");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printThirdActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("3 act intro");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printThirdActOutro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("3 act end");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printFourthActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("4 act intro");
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public static void printEnd(Player player) {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Congratulations " + player.name);
		GameLogic.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
	}
}
