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
			ui.printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
			
			//Printa um cabeçalho com o nome do player e a vida atual x vida máxima
			ui.printHeading(GameLogic.player.name + "\nHP: " + GameLogic.player.hp + "/" + GameLogic.player.maxHp);
			
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
		GameLogic.player.hp -= dmgTook;
		enemy.hp -= dmg;
		
		ui.clearConsole();
		ui.printHeading("BATTLE");
		System.out.println("You dealt " + dmg + " damage to " + enemy.name + ".");
		ui.printSeparator(15);
		System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
		GameLogic.anythingToContinue();
		
		if(GameLogic.player.hp <= 0) {
			progression.playerDied();
			isFighting = false;
		}
		else if(enemy.hp <= 0) {
			ui.clearConsole();
			System.out.println("You defeated the " + enemy.name + "!");
			GameLogic.player.xp += enemy.xp;
			System.out.println("You earned " + enemy.xp + "XP!");
			boolean addRest = (Math.random() * 5 + 1 <= 2.25);
			int goldEarned = (int) (Math.random() * enemy.xp);
			if(addRest) {
				GameLogic.player.restsLefts++;
				System.out.println("You have a chance to rest");
			}
			if(goldEarned > 0) {
				GameLogic.player.gold += goldEarned;
				System.out.println("You collect " + goldEarned + " gold from " + enemy.name + "'s corpse!");
			}
			GameLogic.anythingToContinue();
			isFighting = false;
		}
	}

	public void Heal() {
		//Use potion
		ui.clearConsole();
		if(GameLogic.player.pots > 0 && GameLogic.player.hp < GameLogic.player.maxHp) {
			//can take
			ui.printHeading("Do you want to drink a potion? (" + GameLogic.player.pots + " left).");
			System.out.println("(1) Yes\n(2) No, maybe later");
			int input = GameLogic.readInt("->", 2);
			if(input == 1) {
				GameLogic.player.hp = GameLogic.player.maxHp;
				ui.clearConsole();
				ui.printHeading("Your health is now: " + GameLogic.player.maxHp);
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
		if(progression.act != 4) {
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
				if(GameLogic.player.hp <= 0) {
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
