package game;

import characters.Enemy;

public class Battle {
	UIMethods ui = new UIMethods();
	Enemy enemy;
	GameLogic gameLogic = new GameLogic();
	private boolean isFighting;
	
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
			System.out.println("Choose a action");
			UIMethods.printSeparator(20);
			System.out.println("(1) Fight\n(2) Use Potion\n(3) Run!");
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
		UIMethods.printHeading("BATTLE");
		System.out.println("You dealt " + dmg + " damage to " + enemy.getName() + ".");
		UIMethods.printSeparator(15);
		System.out.println("The " + enemy.getName() + " dealt " + dmgTook + " damage to you.");
		Input.anythingToContinue();
		
		if(GameLogic.player.getHp() <= 0) {
			gameLogic.playerDied();
			isFighting = false;
		}
		else if(enemy.getHp() <= 0) {
			UIMethods.clearConsole();
			System.out.println("You defeated the " + enemy.getName() + "!");
			GameLogic.player.setXp(GameLogic.player.getXp() + GameLogic.player.earnXp() + enemy.getXp());
			System.out.println("You earned " + (enemy.getXp() +  GameLogic.player.earnXp()) + "XP!");
			boolean addRest = (Math.random() * 5 + 1 <= 7.25);
			int goldEarned = GameLogic.player.collectGold();
			if(addRest) {
				int rests = GameLogic.player.getRests();
				GameLogic.player.setRests(rests++);
				System.out.println("You have a chance to rest");
			}
			if(goldEarned > 0) {
				GameLogic.player.setGold(goldEarned);
				System.out.println("You collect " + goldEarned + " gold from " + enemy.getName() + "'s corpse!");
			}
			Input.anythingToContinue();
			isFighting = false;
		}
	}

	public void Heal() {
		UIMethods.clearConsole();
		if(GameLogic.player.getPots() > 0 && GameLogic.player.getHp() < GameLogic.player.getMaxHp()) {
			UIMethods.printHeading("Do you want to drink a potion? (" + GameLogic.player.getPots() + " left).");
			System.out.println("(1) Yes\n(2) No, maybe later");
			int input = Input.read(2);
			if(input == 1) {
				GameLogic.player.setHp(GameLogic.player.getMaxHp());
				UIMethods.clearConsole();
				UIMethods.printHeading("Your health is now: " + GameLogic.player.getMaxHp());
				Input.anythingToContinue();
			}
		}
		else {
			UIMethods.printHeading("You don't have any potions or you're at full health");
			Input.anythingToContinue();
		}
	}
	
	public void Escape() {
		UIMethods.clearConsole();
		if(gameLogic.getAct() != 4) {
			//35% para escapar
			if(Math.random() *10 + 1 >= 3.5) {
				System.out.println("You ran away");
				Input.anythingToContinue();
				isFighting = false;
			}
			else {
				UIMethods.printHeading("You didn't escape");
				int dmgTook = enemy.attack();
				System.out.println("You took" + dmgTook + "damage!");
				Input.anythingToContinue();
				if(GameLogic.player.getHp() <= 0) {
					gameLogic.playerDied();
					isFighting = false;
				}
			}
		}
		else {
			System.out.println("You cannot escape");
			Input.anythingToContinue();
		}
	}
}
