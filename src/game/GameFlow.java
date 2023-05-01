package game;
import History.*;

public class GameFlow {
	static Story story;
	static Progression progression = new Progression();
	private static boolean chapterOneIntroShown = false;
	private static boolean chapterOneEndShown = false;
	private static boolean chapterTwoIntroShown = false;
	
	public GameFlow() {
	}
	
	public void sequence() {
		if (!chapterOneIntroShown) {
	        story = new ChapterOne();
	        story.chapterIntro();
	        chapterOneIntroShown = true;
	    } 
		if (!chapterOneEndShown && GameLogic.player.getXp() >= 5) {
	        story.chapterEnd();
	        chapterOneEndShown = true;
	        progression.setAct(2);
	        progression.setPlace(1);
	        System.out.println("lugar: " + progression.getPlace());
	    } 
		if (progression.getAct() == 2) {
	    	story = new ChapterTwo();
	    	story.chapterIntro();
	        chapterTwoIntroShown = true;
	    }
	}
}
