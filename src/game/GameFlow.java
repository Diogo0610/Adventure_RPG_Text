package game;
import storytelling.*;

public class GameFlow {
	
	/*
	 * "story": Uma instância da classe "Story" usada para mostrar a história e introdução de cada capítulo.
	 * "gameLogic": Uma instância da classe "GameLogic" usada para acessar e atualizar a lógica do jogo.
	 * Atributos booleanos (chapterOneIntroShown, chapterOneEndShown, chapterTwoIntroShown, etc.): São usados para 
	 * controlar se as introduções e finais de cada capítulo já foram mostrados.
	 */
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
	
	/*
	 * Método "sequence()": Este método controla a sequência do jogo e avança para os próximos capítulos à medida que 
	 * as condições são cumpridas. Ele realiza as seguintes ações:
	 * - Verifica se a introdução do Capítulo 1 ainda não foi mostrada. Se for o caso, cria uma instância da classe 
	 *   "ChapterOne" e chama o método "chapterIntro()" para mostrar a introdução do capítulo. 
	 *   Define "chapterOneIntroShown" como true.
	 * - Verifica se o final do Capítulo 1 ainda não foi mostrado e se a experiência do jogador é maior ou igual a 15. 
	 *   Se for o caso, chama o método "chapterEnd()" para mostrar o final do capítulo, define "chapterOneEndShown" como 
	 *   true, define o ato como 2, o local como 1 e imprime o valor do local.
	 * - Repete o mesmo padrão para os Capítulos 2, 3 e 4, verificando as condições necessárias para mostrar a 
	 *   introdução e o final de cada capítulo, e atualizando o ato e o local conforme necessário.
	 * - No final do Capítulo 4, chama o método "finalBattle()" da classe "GameLogic" para iniciar uma batalha final.
	 * - Mostra o final do Capítulo 4.
	 * - Define "isRunning" como false na classe "GameLogic" para encerrar o jogo.
	 */
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
