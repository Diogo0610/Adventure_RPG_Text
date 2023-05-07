package game;
import History.*;

public class GameFlow {
	static Story story;
	GameLogic gameLogic = new GameLogic();
	private static boolean chapterOneIntroShown = false;
	private static boolean chapterOneEndShown = false;
	@SuppressWarnings("unused")
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
	        gameLogic.setAct(2);
	        gameLogic.setPlace(1);
	        System.out.println("lugar: " + gameLogic.getPlace());
	    } 
		if (gameLogic.getAct() == 2) {
	    	story = new ChapterTwo();
	    	story.chapterIntro();
	        chapterTwoIntroShown = true;
	    }
	}
}
