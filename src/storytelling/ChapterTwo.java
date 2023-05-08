package storytelling;

import game.Input;
import game.UIMethods;

public class ChapterTwo implements Story {
	
	@Override
	public void chapterIntro() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo II: Beirágua");
		UIMethods.printSeparator(30);
		System.out.println("chapter Intro 1");
		System.out.println("chapter Intro 2");
		System.out.println("chapter Intro 3");
		Input.anythingToContinue();
	}

	@Override
	public void chapterEnd() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo II: Beirágua");
		UIMethods.printSeparator(30);
		System.out.println("chapter End 1");
		System.out.println("chapter End 2");
		System.out.println("chapter End 3");
		Input.anythingToContinue();
	}

}
