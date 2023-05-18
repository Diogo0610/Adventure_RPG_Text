package storytelling;

import game.Input;
import game.GameLogic;
import game.UIMethods;

public class ChapterThree implements Story{
	String name = GameLogic.player.getName();
	
	@Override
	public void chapterIntro() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo III: Sapântano");
		UIMethods.printSeparator(30);
		System.out.println("Enquanto " + name + " adentrava a 2ª maior cidade do Condado, Sapântano, seus olhos "
				+ "testemunhavam uma cena que partia seu coração hobbit. O lugar que antes era um refúgio de "
				+ "tranquilidade e prosperidade havia sido transformado em um campo de desolação. As casas bem "
				+ "construídas dos hobbits haviam sido reduzidas a escombros, suas paredes quebradas e telhados "
				+ "arrancados.");
		System.out.println("Os jardins uma vez exuberantes agora eram terrenos baldios, pisoteados e devastados pela "
				+ "ganância desmedida. O aroma doce das flores e o verdejante das folhagens haviam sido substituídos "
				+ "pela fumaça sufocante das chamas e pela sombra da opressão.");
		System.out.println();
		System.out.println("A cruel realidade se impunha diante de " + name + ". Seus companheiros hobbits, aldeões inocentes, "
				+ "estavam agora sendo escravizados e subjugados. Orcs e outras criaturas malignas ocupavam cada canto, "
				+ "construindo quarteis e bases de comando para suas perversas empreitadas.");
		System.out.println("A liberdade e a alegria foram roubadas das almas do Condado, substituídas pela opressão e "
				+ "pelo medo. Em seu coração, " + name + " sentiu uma determinação ardente surgir, um desejo de libertar "
				+ "seu povo e restaurar a paz que lhes fora tirada.");
		Input.anythingToContinue();
	}

	@Override
	public void chapterEnd() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo III: Sapântano");
		UIMethods.printSeparator(30);
		System.out.println("Após enfrentar inúmeras adversidades e desafios, " + name + " emergiu vitorioso do Sapântano, "
				+ "tendo libertado os aldeões e expulsado os Orcs e seus asseclas. A cidade, antes dominada pela "
				+ "escuridão e pela tristeza, estava agora livre novamente.");
		System.out.println("Os hobbits puderam finalmente respirar aliviados, vendo as fundações da opressão "
				+ "desmoronarem diante de seus olhos.");
		System.out.println();
		System.out.println("Com o coração cheio de coragem e determinação, " + name + " sabia que sua missão não estava completa."
				+ " A batalha final o aguardava em Hobbiton, sua cidade natal, onde as forças do mal haviam se reunido "
				+ "em um último esforço para espalhar a sombra da ganância e opressão pelo Condado.");
		System.out.println("Com seus companheiros ao seu lado e a chama da esperança acesa, " + name + " partiu de Sapântano "
				+ "rumo a Hobbiton, pronto para enfrentar o derradeiro confronto que selaria o destino do Condado e de "
				+ "todo o mundo que amava.");
		Input.anythingToContinue();
	}
}
