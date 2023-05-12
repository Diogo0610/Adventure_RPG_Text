package game;
import java.util.Random;

public class GameEvents {
	static Random random = new Random();
	static GameLogic gameLogic = new GameLogic();
	
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
