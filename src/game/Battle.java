package game;

public class Battle {
	UIMethods ui = new UIMethods();
	Enemy enemy;
	static Progression progression = new Progression();
	private boolean isFighting;
	
	public Battle(Enemy enemy) {
		this.enemy = enemy;
		isFighting = true;
		while(isFighting) {
			//Limpa o Console
			ui.clearConsole();
			
			//Printa um cabeçalho com o nome do inimigo e a vida atual x vida máxima
			ui.printHeading(enemy.getName() + "\nHP: " + enemy.getHp() + "/" + enemy.getMaxHp());
			
			//Printa um cabeçalho com o nome do player e a vida atual x vida máxima
			ui.printHeading(GameLogic.player.getName() + "\nHP: " + GameLogic.player.getHp() + "/" + GameLogic.player.getMaxHp());
			
			//Pede pata que o jogador escolha entre 3 ações
			System.out.println("Choose a action");
			ui.printSeparator(20);
			System.out.println("(1) Fight\n(2) Use Potion\n(3) Run!");
			int input = GameLogic.readInt("->", 3);
			
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
		int dmg = GameLogic.player.attack() - enemy.defend();
		
		//cria um atributo local que calcula o dano que o jogador receberá baseado na equação de ataque da
		//classe Enemy, subtraindo da equação de defesa da clase Player
		int dmgTook = enemy.attack() - enemy.defend();
		
		if(dmgTook < 0) {
			dmg -= dmgTook/2;
			dmgTook = 0;
		}
		if(dmg < 0) {
			dmg = 0;
		}
		GameLogic.player.setHp(GameLogic.player.getHp() - dmgTook);
		enemy.setHp(enemy.getHp() - dmg);
		
		ui.clearConsole();
		ui.printHeading("BATTLE");
		System.out.println("You dealt " + dmg + " damage to " + enemy.getName() + ".");
		ui.printSeparator(15);
		System.out.println("The " + enemy.getName() + " dealt " + dmgTook + " damage to you.");
		GameLogic.anythingToContinue();
		
		if(GameLogic.player.getHp() <= 0) {
			progression.playerDied();
			isFighting = false;
		}
		else if(enemy.getHp() <= 0) {
			ui.clearConsole();
			System.out.println("You defeated the " + enemy.getName() + "!");
			GameLogic.player.setXp(GameLogic.player.getXp() + enemy.getXp());
			System.out.println("You earned " + enemy.getXp() + "XP!");
			boolean addRest = (Math.random() * 5 + 1 <= 2.25);
			int goldEarned = (int) (Math.random() * enemy.getXp());
			if(addRest) {
				GameLogic.player.restsLefts++;
				System.out.println("You have a chance to rest");
			}
			if(goldEarned > 0) {
				GameLogic.player.gold += goldEarned;
				System.out.println("You collect " + goldEarned + " gold from " + enemy.getName() + "'s corpse!");
			}
			GameLogic.anythingToContinue();
			isFighting = false;
		}
	}

	public void Heal() {
		//Use potion
		ui.clearConsole();
		if(GameLogic.player.pots > 0 && GameLogic.player.getHp() < GameLogic.player.getMaxHp()) {
			//can take
			ui.printHeading("Do you want to drink a potion? (" + GameLogic.player.pots + " left).");
			System.out.println("(1) Yes\n(2) No, maybe later");
			int input = GameLogic.readInt("->", 2);
			if(input == 1) {
				GameLogic.player.setHp(GameLogic.player.getMaxHp());
				ui.clearConsole();
				ui.printHeading("Your health is now: " + GameLogic.player.getMaxHp());
				GameLogic.anythingToContinue();
			}
		}
		else {
			ui.printHeading("You don't have any potions or you're at full health");
			GameLogic.anythingToContinue();
		}
	}
	
	public void Escape() {
		ui.clearConsole();
		if(progression.getAct() != 4) {
			//35% para escapar
			if(Math.random() *10 + 1 >= 3.5) {
				System.out.println("You ran away");
				GameLogic.anythingToContinue();
				isFighting = false;
			}
			else {
				ui.printHeading("You didn't escape");
				int dmgTook = enemy.attack();
				System.out.println("You took" + dmgTook + "damage!");
				GameLogic.anythingToContinue();
				if(GameLogic.player.getHp() <= 0) {
					progression.playerDied();
					isFighting = false;
				}
			}
		}
		else {
			System.out.println("You cannot escape");
			GameLogic.anythingToContinue();
		}
	}
}
