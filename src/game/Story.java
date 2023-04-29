package game;

public class Story {
	
	UIMethods ui = new UIMethods();
	
	public Story() {
		
	}
	
	public void printIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("Story");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printFirstActIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("1 act intro");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printFirstActOutro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("1 act end");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printSecondActIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("2 act intro");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printSecondActOutro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("2 act end");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printThirdActIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("3 act intro");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printThirdActOutro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("3 act end");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printFourthActIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("4 act intro");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}
	
	public void printEnd(Player player) {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("Congratulations " + player.name);
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
	}
}
