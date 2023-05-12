package game;

public class GameEvents {
	
	public static void shop() {
		int playerPotions = GameLogic.player.getPots();
		UIMethods.clearConsole();
		UIMethods.printHeading("You meet a mysterious Stranger.\nHe offers you something:");
		int price = (int)(Math.random() * (10 + GameLogic.player.getPots() * 3) + 10 + GameLogic.player.getPots());
		System.out.println("- Magic Potion: " + price + " gold.");
		UIMethods.printSeparator(20);
		System.out.println("Do you want to buy one?\n(1) Yes\n(2) No, thank you");
		int input = Input.read(2);
		
		if(input ==1) {
			UIMethods.clearConsole();
			if(GameLogic.player.getGold() > price) {
				UIMethods.printHeading("You bought a magical potion for " + price + " gold");
				GameLogic.player.setPots(playerPotions++);
				GameLogic.player.setGold(-price);
			}
			else {
				UIMethods.printHeading("You don't have money to buy this!");
				Input.anythingToContinue();
			}
		}
	}
	
	public static void takeRest() {
		int playerRests = GameLogic.player.getRests();
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
					GameLogic.player.setRests(playerRests--);
				}
			}
			else {
				System.out.println("You don't rest.");
			}
			Input.anythingToContinue();
		}
		else {
			System.out.println("Você ainda não pode descansar");
			Input.anythingToContinue();
		}
	}
}
