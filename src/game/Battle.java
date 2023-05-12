package game;

import characters.Enemy;

public class Battle {
	
	/*
	 * "ui": Uma instância da classe "UIMethods" para acessar métodos relacionados à interface do usuário.
	 * "enemy": Um objeto do tipo "Enemy" que representa o inimigo com o qual o jogador está lutando.
	 * "gameLogic": Uma instância da classe "GameLogic" para acessar métodos e atributos relacionados à lógica do jogo.
	 * "isFighting": Um atributo booleano que indica se a batalha está em andamento ou não.
	 */
	UIMethods ui = new UIMethods();
	Enemy enemy;
	GameLogic gameLogic = new GameLogic();
	private boolean isFighting;
	
	/*
	 * Método construtor "Battle(Enemy enemy)": Este método é chamado ao iniciar uma batalha com um inimigo específico. 
	 * Ele recebe um objeto "Enemy" como parâmetro para definir o inimigo com o qual o jogador irá lutar. 
	 * O método inicia a batalha em um loop enquanto "isFighting" for verdadeiro. Dentro do loop, ele realiza as 
	 * seguintes ações:
	 * 	- Limpa o console.
	 * 	- Imprime um cabeçalho com o nome e a vida atual do inimigo.
	 * 	- Imprime um cabeçalho com o nome e a vida atual do jogador.
	 * 	- Solicita ao jogador que escolha uma ação (lutar, usar poção ou fugir).
	 * 	- Lê a entrada do jogador usando o método "read" da classe "Input".
	 * 	- Com base na escolha do jogador, executa o método correspondente: "confront" (para lutar), 
	 * 	  "Heal" (para usar uma poção) ou "Escape" (para fugir).
	 */
	public Battle(Enemy enemy) {
		this.enemy = enemy;
		isFighting = true;
		while(isFighting) {
			//Limpa o Console
			UIMethods.clearConsole();
			
			//Printa um cabeçalho com o nome do inimigo e a vida atual x vida máxima
			UIMethods.printHeading(enemy.getName() + "\nHP: " + enemy.getHp() + "/" + enemy.getMaxHp());
			
			//Printa um cabeçalho com o nome do player e a vida atual x vida máxima
			UIMethods.printHeading(GameLogic.player.getName() + "\nHP: " + GameLogic.player.getHp() + "/" + GameLogic.player.getMaxHp());
			
			//Pede pata que o jogador escolha entre 3 ações
			System.out.println("Escolha uma ação!");
			UIMethods.printSeparator(20);
			System.out.println("(1) Lutar\n(2) Usar Poção\n(3) Fugir!");
			int input = Input.read(3);
			
			//Entra nesse bloco caso o player escolha a 1ª opção (lutar)
			if(input == 1) {
				confront(enemy);
			}
			else if(input ==2) {
				Heal();
			}
			else {
				Escape();
				break;
			}
		}
	}
	
	/*
	 * Método "confront(Enemy enemy)": Este método é chamado quando o jogador escolhe a opção de lutar. 
	 * Ele recebe um objeto "Enemy" como parâmetro que representa o inimigo atual. O método realiza o confronto entre o 
	 * jogador e o inimigo, calculando o dano causado e recebido por ambas as partes. 
	 * Em seguida, atualiza as estatísticas do jogador e do inimigo com base no confronto e exibe mensagens relevantes.
	 */
	public void confront(Enemy enemy) {
		//cria um atributo local que calcula o dano que o jogador causará baseado na equação de ataque da
		//classe Player, subtraindo da equação de defesa da clase Enemy
		int dmg = (GameLogic.player.attack() - enemy.defend());
		
		//cria um atributo local que calcula o dano que o jogador receberá baseado na equação de ataque da
		//classe Enemy, subtraindo da equação de defesa da clase Player
		int dmgTook = (enemy.attack() - GameLogic.player.defend());
		
		if(dmgTook < 0) {
			dmg -= dmgTook/2;
			dmgTook = 0;
		}
		if(dmg < 0) {
			dmg = 0;
		}
		
		GameLogic.player.setHp(GameLogic.player.getHp() - dmgTook);
		enemy.setHp(enemy.getHp() - dmg);
		
		UIMethods.clearConsole();
		UIMethods.printHeading("BATALHA");
		System.out.println("Você causou " + dmg + " de dano em " + enemy.getName() + ".");
		UIMethods.printSeparator(15);
		System.out.println("O " + enemy.getName() + " causou " + dmgTook + " de dano em você.");
		Input.anythingToContinue();
		
		if(GameLogic.player.getHp() <= 0) {
			gameLogic.playerDied();
			isFighting = false;
		}
		else if(enemy.getHp() <= 0) {
			UIMethods.clearConsole();
			System.out.println("Você derrotou o " + enemy.getName() + "!");
			GameLogic.player.setXp(GameLogic.player.getXp() + GameLogic.player.earnXp() + enemy.getXp());
			System.out.println("Você ganhou " + (enemy.getXp() +  GameLogic.player.earnXp()) + "XP!");
			boolean addRest = (Math.random() * 5 + 1 <= 7.25);
			int goldEarned = GameLogic.player.collectGold();
			if(addRest) {
				GameLogic.player.setRests(GameLogic.player.getRests() + 1);
				System.out.println("Você conseguiu uma chance de descansar");
			}
			if(goldEarned > 0) {
				GameLogic.player.setGold(goldEarned);
				System.out.println("Você coletou " + goldEarned + " de ouro do corpo do " + enemy.getName() + "!");
			}
			Input.anythingToContinue();
			isFighting = false;
		}
	}

	/*
	 * Método "Heal()": Este método é chamado quando o jogador escolhe a opção de usar uma poção. 
	 * Ele verifica se o jogador tem poções disponíveis e sua vida não está cheia. Se essas condições forem atendidas, 
	 * o jogador recupera sua vida máxima usando uma poção e as estatísticas são atualizadas. Caso contrário, 
	 * são exibidas mensagens informando que o jogador não possui mais poções ou sua vida está cheia.
	 */
	public void Heal() {
		UIMethods.clearConsole();
		if(GameLogic.player.getPots() > 0 && GameLogic.player.getHp() < GameLogic.player.getMaxHp()) {
			UIMethods.printHeading("Você quer beber uma poção? (" + GameLogic.player.getPots() + " sobrando).");
			System.out.println("(1) Sim\n(2) Não, talvez mais tarde");
			int input = Input.read(2);
			if(input == 1) {
				GameLogic.player.setHp(GameLogic.player.getMaxHp());
				GameLogic.player.setPots(GameLogic.player.getPots() - 1);
				UIMethods.clearConsole();
				UIMethods.printHeading("Sua saúde agora está em: " + GameLogic.player.getMaxHp());
				Input.anythingToContinue();
			}
		}
		else {
			UIMethods.printHeading("Você não possui mais poções ou está com a vida cheia.");
			Input.anythingToContinue();
		}
	}
	
	/*
	 * Método "Escape()": Este método é chamado quando o jogador escolhe a opção de fugir. 
	 * Ele verifica se é possível escapar com base na lógica do jogo e em uma chance de 35%. 
	 * Se o jogador escapar com sucesso, uma mensagem é exibida. Caso contrário, o jogador sofre dano do inimigo e são 
	 * exibidas mensagens relevantes. Se a vida do jogador chegar a zero, o método "playerDied" da classe "GameLogic" é 
	 * chamado.
	 */
	public void Escape() {
		UIMethods.clearConsole();
		if(gameLogic.getAct() != 4) {
			//35% para escapar
			if(Math.random() *10 + 1 >= 3.5) {
				System.out.println("Você escapou!");
				Input.anythingToContinue();
				isFighting = false;
			}
			else {
				UIMethods.printHeading("Você não conseguiu escapar!");
				int dmgTook = enemy.attack();
				System.out.println("Você levou " + dmgTook + " de dano!");
				Input.anythingToContinue();
				if(GameLogic.player.getHp() <= 0) {
					gameLogic.playerDied();
					isFighting = false;
				}
			}
		}
		else {
			isFighting = true;
			System.out.println("Você não pode escapar!");
			Input.anythingToContinue();
		}
	}
}
