package game;

import characters.Enemy;

public class Battle {
	
	Enemy enemy;
	GameLogic gameLogic = new GameLogic();
	private boolean isFighting;

	public Battle(Enemy enemy) {
		this.enemy = enemy;
		isFighting = true;
		while(isFighting) {
			UIMethods.clearConsole();
			
			UIMethods.printHeading(enemy.getName() + "\nHP: " + enemy.getHp() + "/" + enemy.getMaxHp());
			
			UIMethods.printHeading(GameLogic.player.getName() + "\nHP: " + GameLogic.player.getHp() + "/" + GameLogic.player.getMaxHp());
			
			System.out.println("Escolha uma ação!");
			UIMethods.printSeparator(20);
			System.out.println("(1) Lutar\n(2) Usar Poção\n(3) Fugir!");
			int input = Input.read(3);
			
			if(input == 1) {
				confront(enemy);
			}
			else if(input == 2) {
				Heal();
			}
			else {
				Escape();
				break;
			}
		}
	}

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
			System.out.println("Você derrotou " + enemy.getName() + "!");
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
