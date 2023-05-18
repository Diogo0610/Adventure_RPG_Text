package storytelling;

import game.Input;
import game.GameLogic;
import game.UIMethods;

public class ChapterFour implements Story {
	String name = GameLogic.player.getName();
	
	@Override
	public void chapterIntro() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo IV: Hobbiton");
		UIMethods.printSeparator(30);
		System.out.println("Finalmente, após uma jornada repleta de perigos e desafios, " + name +" chegou à sua amada "
				+ "Hobbiton. No entanto, o que encontrou ali foi uma visão desoladora. A cidade que um dia fora o "
				+ "símbolo da harmonia entre os hobbits e a natureza estava agora mergulhada na escuridão e no caos. "
				+ "Era como se a própria vida tivesse sido sugada do Condado. As ruas estavam vazias e silenciosas, "
				+ "e o ar estava impregnado de um odor pútrido.");
		System.out.println(name + " percebeu a verdadeira extensão da ameaça que pairava sobre sua terra natal. "
				+ "O responsável por toda essa ruína era Saruman, o corrompido. Um antigo mago, Saruman havia "
				+ "perdido sua sabedoria e poder devido à sua busca insaciável por controle e domínio. Agora, "
				+ "ele se voltava para o Condado, utilizando todos os recursos naturais como matéria-prima para "
				+ "construir seu exército destrutivo, buscando recuperar seus poderes perdidos.");
		System.out.println();
		System.out.println("Nem mesmo a natureza foi poupada de sua ganância. As plantas foram arrancadas de suas "
				+ "raízes, as árvores foram derrubadas e nenhum animal que antes habitava a cidade restou. Hobbiton, "
				+ "outrora um lugar vivo e vibrante, estava agora morta, um reflexo sombrio do domínio de Saruman.");
		System.out.println(name + " sabia que o tempo estava se esgotando. Antes que pudesse reagir, a cidade foi "
				+ "cercada e o herói hobbit foi alvo das forças do mal. Seu destino parecia incerto, mas seu "
				+ "espírito perseverava, impulsionado pela esperança de libertar sua amada terra do jugo "
				+ "implacável de Saruman.");
		Input.anythingToContinue();
	}

	@Override
	public void chapterEnd() {
		UIMethods.clearConsole();
		UIMethods.printSeparator(30);
		System.out.println("Capítulo IV: Hobbiton");
		UIMethods.printSeparator(30);
		System.out.println("Em um confronto épico e cheio de sacrifícios, "+ name + " enfrentou Saruman, o corrompido. "
				+ "O antigo mago, sedento por poder, mostrou sua verdadeira natureza vil e traiçoeira. "
				+ "No entanto, o heroísmo e a determinação de " + name + " provaram ser mais fortes.");
		System.out.println("Com golpes precisos e coragem inabalável, " + name + " derrotou Saruman, pondo um fim à sua "
				+ "tirania sobre o Condado. A vitória foi celebrada, mas as marcas deixadas pela ganância e "
				+ "destruição eram profundas. A terra estava ferida, e a jornada de restauração estava "
				+ "apenas começando.");
		System.out.println();
		System.out.println("Seis meses se passaram desde a queda de Saruman, e aos poucos, a vida começou a renascer "
				+ "no Condado. Os hobbits, unidos em prol da restauração, dedicaram-se a curar as feridas da "
				+ "terra e reconstruir o que foi perdido. O caminho da recuperação era longo e árduo, mas a "
				+ "esperança brilhava no coração de todos.");
		System.out.println("E assim, o Condado se tornou um exemplo vivo de resiliência e renovação. "
				+ "Os hobbits aprenderam que a destruição era fácil e rápida, mas a restauração exigia "
				+ "paciência, esforço coletivo e respeito pela vida em todas as suas formas. A lição foi gravada na "
				+ "memória dos hobbits, para que nunca se esquecessem do poder transformador do cuidado com o meio "
				+ "ambiente.");
		System.out.println();
		System.out.println("A história de " + name + ", com sua coragem e determinação, se tornou uma inspiração para as "
				+ "gerações futuras. Os hobbits aprenderam que a proteção do meio ambiente não era apenas uma "
				+ "necessidade, mas uma responsabilidade que lhes cabia. A preservação da Terra Média, e de qualquer "
				+ "mundo, exigia ações conscientes e uma mudança de mentalidade. Aprendeu-se que a harmonia entre o "
				+ "homem e a natureza era essencial para um futuro próspero e sustentável. E, assim, o legado de "
				+ name + " viveu além dos limites do tempo, como um lembrete eterno da importância de sermos guardiões "
				+ "responsáveis da natureza, protegendo-a para as gerações presentes e futuras.");
		System.out.println();
		System.out.println("Que essa história inspire a todos nós a cuidar e preservar nosso próprio mundo, "
				+ "lembrando que o destino de nossa existência está entrelaçado com o destino da natureza que nos "
				+ "cerca. Pois somos parte dela e somos chamados a protegê-la com todo o nosso "
				+ "amor e dedicação.");
		Input.anythingToContinue();
	}
}
