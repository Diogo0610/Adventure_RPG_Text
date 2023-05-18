package storytelling;

import game.Input;
import game.GameLogic;
import game.UIMethods;

public class ChapterOne implements Story {
	String name = GameLogic.player.getName();
	
	@Override
	public void chapterIntro() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo I: Ponte do Brandevin");
		UIMethods.printSeparator(30);
		System.out.println("Era uma vez, em um lugar chamado o Condado, um jovem Hobbit chamado " + name + ". "
				+ name + " era um grande amante da natureza e tinha saído da vila de Hobbiton em busca de plantas raras "
				+ "para cultivar em seu jardim no Condado, onde tudo cresce e floresce.");
		System.out.println("A jornada foi longa, mas " + name + " estava determinado a trazer de volta as plantas "
				+ "mais exóticas que pudesse encontrar.");
		System.out.println();
		System.out.println("No entanto, ao retornar ao Condado, " + name + " se deparou com um cenário aterrador. "
				+ "O rio do Brandevin, que costumava ser um local de beleza serena, estava completamente poluído. "
				+ "Os peixes mortos flutuavam na superfície e o cheiro era insuportável.");
		System.out.println("O jovem Hobbit sabia que algo precisava ser feito para salvar o rio e proteger o meio ambiente.");
		Input.anythingToContinue();

	}

	@Override
	public void chapterEnd() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo I: Ponte do Brandevin");
		UIMethods.printSeparator(30);
		System.out.println("Após uma jornada perigosa e cheia de obstáculos, " + name + " finalmente chegou a Beirágua, um lago "
				+ "muito grande e bonito que era o lar de diversas espécies de animais e plantas. Mas ao se aproximar, "
				+ "ele percebeu que a biodiversidade do lago estava ameaçada.");
		System.out.println("A água estava escura e poluída, e muitas das espécies nativas estavam desaparecendo.");
		System.out.println();
		System.out.println(name + " sabia que precisava agir rapidamente para salvar Beirágua e todas as criaturas que "
				+ "dependiam dela. Ele se comprometeu a lutar pela proteção do meio ambiente, não importa o quão "
				+ "difícil a jornada fosse.");
		System.out.println("O jovem Hobbit prometeu que faria tudo o que pudesse para devolver a beleza natural do "
				+ "Condado, e assim começou sua grande aventura em defesa da natureza.");
		Input.anythingToContinue();
		
	}

}
