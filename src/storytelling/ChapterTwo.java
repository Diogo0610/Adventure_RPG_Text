package storytelling;

import game.Input;
import game.GameLogic;
import game.UIMethods;

public class ChapterTwo implements Story {
	String name = GameLogic.player.getName();
	
	@Override
	public void chapterIntro() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo II: Beirágua");
		UIMethods.printSeparator(30);
		System.out.println("Enquanto " + name + " prosseguia em sua jornada pelo Condado, suas preocupações e tristezas só "
				+ "aumentavam. Ao chegar a Beirágua, uma região outrora repleta de vida e esplendor, o jovem Hobbit se "
				+ "deparou com uma visão desoladora. A floresta majestosa que envolvia o lago havia sido impiedosamente "
				+ "queimada e desmatada, transformada em cinzas e clareiras áridas.");
		System.out.println("O verde exuberante de outrora fora substituído pela destruição desenfreada, onde apenas "
				+ "troncos carbonizados e o eco silencioso do vento permaneciam. Era um testemunho sombrio da "
				+ "ganância e do desrespeito pela natureza.");
		System.out.println();
		System.out.println("E não foi apenas o desmatamento que assolou Beirágua. O lago, outrora um refúgio de vida e "
				+ "beleza, estava agora poluído e maculado. Suas águas, antes límpidas e cristalinas, haviam se "
				+ "transformado em uma massa turva e tóxica. A vida aquática, outrora abundante e diversificada, "
				+ "estava ameaçada e em declínio. ");
		System.out.println("Peixes agonizantes lutavam por sobrevivência, e aves que costumavam dançar graciosamente "
				+ "sobre suas ondas haviam desaparecido. A tristeza e a indignação preencheram o coração de " + name
				+ " diante dessa triste realidade. Ele sabia que a batalha pela preservação do meio ambiente se "
				+ "intensificava a cada passo que dava.");
		Input.anythingToContinue();
	}

	@Override
	public void chapterEnd() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo II: Beirágua");
		UIMethods.printSeparator(30);
		System.out.println("Enquanto " + name +" explorava as margens do lago contaminado de Beirágua, suas esperanças eram "
				+ "renovadas pela descoberta de uma carta. Um fragmento de informação crucial que revelava uma "
				+ "conexão perturbadora. A carta, encontrada entre os escombros de um inimigo, mencionava ordens "
				+ "vindas diretamente de Hobbiton, sua amada cidade natal. ");
		System.out.println("Aquelas palavras revelavam que a fonte de tanta destruição e corrupção que se espalhava pelo "
				+ "Condado estava sendo dirigida por mãos traiçoeiras que conheciam bem seus caminhos.");
		System.out.println();
		System.out.println("A revelação fez com que a chama da curiosidade se acendesse no coração de " + name +". "
				+ "Ele sentia um chamado para retornar à sua terra natal e desvendar o mistério que se escondia "
				+ "entre as colinas outroras verdejantes de Hobbiton. ");
		System.out.println("O destino do Condado e de toda a Terra Média estava entrelaçado com essa jornada que se "
				+ "delineava. Com determinação renovada e a coragem dos antigos heróis, " + name + " partiu de Beirágua com "
				+ "um objetivo claro em mente: proteger sua terra natal e descobrir a verdade que se ocultava "
				+ "nas sombras.");
		Input.anythingToContinue();
	}

}
