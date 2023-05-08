package storytelling;

public interface Story {
	
	public abstract void chapterIntro();
	public abstract void chapterEnd();
}
	
	/*public void printIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("Story");
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
		System.out.println("Text test 3");
		GameLogic.anythingToContinue();
	}*/

	/*public void printEnd(Player player) {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("Congratulations " + player.name);
		ui.printSeparator(30);
		System.out.println("Text test 1");
		System.out.println("Text test 2");
	}*/