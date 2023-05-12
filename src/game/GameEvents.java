package game;
import java.util.Random;

public class GameEvents {
	static Random random = new Random();
	static GameLogic gameLogic = new GameLogic();
	
	/*
	 * Método "shop()": Este método representa a interação do jogador com uma loja no jogo. 
	 * Ele realiza as seguintes ações:
	 * - Limpa o console.
	 * - Imprime um cabeçalho informando que o jogador está sendo atendido por Tom Bombadil.
	 * - Calcula o preço da poção restauradora com base em um valor aleatório entre 4 e 16, somado 
	 *   ao valor retornado pelo método "getAct()" da classe "GameLogic".
	 * - Imprime o preço da poção.
	 * - Imprime um separador.
	 * - Pergunta ao jogador se ele deseja comprar uma poção.
	 * -Lê a entrada do jogador usando o método "read" da classe "Input".
	 * 
	 * Se o jogador escolher comprar uma poção (valor 1), o método continua com as seguintes ações:
	 * - Limpa o console.
	 * - Verifica se o jogador possui ouro suficiente para comprar a poção.
	 * - Se o jogador tiver ouro suficiente, imprime uma mensagem informando que ele comprou uma poção, 
	 *   atualiza a quantidade de poções e o ouro do jogador, e aguarda a entrada do jogador para continuar.
	 *   Caso contrário, imprime uma mensagem informando que o jogador não tem ouro suficiente para comprar 
	 *   a poção e aguarda a entrada do jogador para continuar.
	 */
	public static void shop() {
		UIMethods.clearConsole();
		UIMethods.printHeading("Você chamou Tom Bombadil.\nEle te oferece uma coisa:");
		int price = (random.nextInt(4, 16) + gameLogic.getAct()) ;
		System.out.println("- Poção restauradora: " + price + " de ouro.");
		UIMethods.printSeparator(20);
		System.out.println("Você quer comprar uma?\n(1) Sim\n(2) Não, obrigado");
		int input = Input.read(2);
		
		if(input ==1) {
			UIMethods.clearConsole();
			if(GameLogic.player.getGold() > price) {
				UIMethods.printHeading("Você comprou uma poção por " + price + " ouro");
				GameLogic.player.setPots(GameLogic.player.getPots() + 1);
				GameLogic.player.setGold(GameLogic.player.getGold() - price);
				Input.anythingToContinue();
			}
			else {
				UIMethods.printHeading("Você não tem ouro para comprar isso!");
				Input.anythingToContinue();
			}
		}
	}
	
	/*
	 * Método "takeRest()": Este método representa a interação do jogador com a opção de descansar no jogo. 
	 * Ele realiza as seguintes ações:
	 * - Limpa o console.
	 * - Verifica se o jogador possui descansos disponíveis.
	 * - Se o jogador tiver descansos disponíveis, imprime uma mensagem informando o número de descansos restantes e 
	 *   pergunta ao jogador se ele deseja descansar.
	 * - Lê a entrada do jogador usando o método "read" da classe "Input".
	 * 
	 * Se o jogador escolher descansar (valor 1), o método continua com as seguintes ações:
	 * - Limpa o console.
	 * - Verifica se a vida do jogador está abaixo da vida máxima.
	 * - Se a vida do jogador estiver abaixo da vida máxima, calcula a quantidade de 
	 *   pontos de vida a serem restaurados com base em um valor aleatório entre 0 e "xp/4 + 1" 
	 *   (sendo "xp" o valor retornado pelo método "getXp()" da classe "GameLogic") somado a 10.
	 * - Atualiza a vida do jogador adicionando os pontos de vida restaurados. Se a vida do jogador exceder a vida máxima, define a vida do jogador como a vida máxima.
	 * - Imprime uma mensagem informando a quantidade de pontos de vida restaurados e a saúde atual do jogador.
	 * - Reduz a quantidade de descansos restantes do jogador em 1.
	 * - Caso o jogador escolha não descansar (valor 2), imprime uma mensagem informando que o jogador não descansou.
	 * - Aguarda a entrada do jogador para continuar.
	 */
	public static void takeRest() {
		UIMethods.clearConsole();
		if(GameLogic.player.getRests() >= 1) {
			UIMethods.printHeading("Você deseja descansar?(" + GameLogic.player.getRests() + " descansos restantes).");
			System.out.println("(1) Sim\n(2) Não");
			int input = Input.read(2);
			if(input == 1) {
				UIMethods.clearConsole();
				if(GameLogic.player.getHp() < GameLogic.player.getMaxHp()) {
					int hpRestored = (int) (Math.random() * (GameLogic.player.getXp() / 4 + 1) + 10);
					GameLogic.player.setHp(GameLogic.player.getHp() + hpRestored);
					if(GameLogic.player.getHp() > GameLogic.player.getMaxHp()) {
						GameLogic.player.setHp(GameLogic.player.getMaxHp());
					}
					System.out.println("Você descansou e restaurou " + hpRestored + " de hp!");
					System.out.println("Você está agora com " + GameLogic.player.getHp() + "/" + GameLogic.player.getMaxHp() + " de saúde.");
					GameLogic.player.setRests(GameLogic.player.getRests() - 1);
				}
			}
			else {
				System.out.println("Você não descansou.");
			}
			Input.anythingToContinue();
		}
		else {
			System.out.println("Você ainda não pode descansar");
			Input.anythingToContinue();
		}
	}
}
