package History;

import game.GameLogic;
import game.UIMethods;

public class ChapterThree implements Story{
UIMethods ui = new UIMethods();
	
	@Override
	public void chapterIntro() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("Capítulo III: Sapântano");
		ui.printSeparator(30);
		System.out.println("chapter Intro 1");
		System.out.println("chapter Intro 2");
		System.out.println("chapter Intro 3");
		GameLogic.anythingToContinue();
	}

	@Override
	public void chapterEnd() {
		ui.clearConsole();
		ui.printSeparator(30);
		System.out.println("Capítulo III: Sapântano");
		ui.printSeparator(30);
		System.out.println("chapter End 1");
		System.out.println("chapter End 2");
		System.out.println("chapter End 3");
		GameLogic.anythingToContinue();
	}
}
