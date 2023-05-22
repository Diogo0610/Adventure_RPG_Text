package game;
import storytelling.*;

public class GameFlow {
	
	static Story story;
	GameLogic gameLogic = new GameLogic();
	private static boolean chapterOneIntroShown = false;
	private static boolean chapterOneEndShown = false;
	private static boolean chapterTwoIntroShown = false;
	private static boolean chapterTwoEndShown = false;
	private static boolean chapterThreeIntroShown = false;
	private static boolean chapterThreeEndShown = false;
	private static boolean chapterFourIntroShown = false;
	private static boolean chapterFourEndShown = false;
	
	public void sequence() {
		//Capítulo 1
		if (!chapterOneIntroShown) {
	        story = new ChapterOne();
	        story.chapterIntro();
	        chapterOneIntroShown = true;
	    } 
		if (!chapterOneEndShown && GameLogic.player.getXp() >= 15) {
	        story.chapterEnd();
	        chapterOneEndShown = true;
	        gameLogic.setAct(2);
	        gameLogic.setPlace(1);
	    } 
		//Capítulo 2
		if (!chapterTwoIntroShown && gameLogic.getAct() == 2) {
	    	story = new ChapterTwo();
	    	story.chapterIntro();
	        chapterTwoIntroShown = true;
	    }
		if (!chapterTwoEndShown && GameLogic.player.getXp() >= 30) {
	        story.chapterEnd();
	        chapterTwoEndShown = true;
	        gameLogic.setAct(3);
	        gameLogic.setPlace(2);
	    }
		//Capítulo 3
		if (!chapterThreeIntroShown && gameLogic.getAct() == 3) {
	    	story = new ChapterThree();
	    	story.chapterIntro();
	        chapterThreeIntroShown = true;
	    }
		if (!chapterThreeEndShown && GameLogic.player.getXp() >= 50) {
	        story.chapterEnd();
	        chapterThreeEndShown = true;
	        gameLogic.setAct(4);
	        gameLogic.setPlace(3);
	    }
		//Capítulo 4
		if (!chapterFourIntroShown && gameLogic.getAct() == 4) {
			story = new ChapterFour();
		    story.chapterIntro();
			chapterFourIntroShown = true;
		}
		if (!chapterFourEndShown && GameLogic.player.getXp() >= 85) {
		    GameLogic.finalBattle();
			story.chapterEnd();
		    gameLogic.setIsRunning(false);
		}
	}
}
