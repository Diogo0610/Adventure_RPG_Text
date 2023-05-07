package game;

public class GameEvents {
	
	public void shop() {
		UIMethods.clearConsole();
		UIMethods.printHeading("You meet a mysterious Stranger.\nHe offers you something:");
		int price = (int)(Math.random() * (10 + GameLogic.player.pots * 3) + 10 + GameLogic.player.pots);
		System.out.println("- Magic Potion: " + price + " gold.");
		UIMethods.printSeparator(20);
		System.out.println("Do you want to buy one?\n(1) Yes\n(2) No, thank you");
		int input = Input.read(2);
		
		if(input ==1) {
			UIMethods.clearConsole();
			if(GameLogic.player.gold > price) {
				UIMethods.printHeading("You bought a magical potion for " + price + " gold");
				GameLogic.player.pots++;
				GameLogic.player.gold -= price;
			}
			else {
				UIMethods.printHeading("You don't have money to buy this!");
				Input.anythingToContinue();
			}
		}
	}
	
	public void takeRest() {
		UIMethods.clearConsole();
		if(GameLogic.player.restsLefts >= 1) {
			UIMethods.printHeading("Do you want to take a rest?(" + GameLogic.player.restsLefts + " rests lefts).");
			System.out.println("(1) Yes\n(2) No");
			int input = Input.read(2);
			if(input == 1) {
				UIMethods.clearConsole();
				if(GameLogic.player.getHp() < GameLogic.player.getMaxHp()) {
					int hpRestored = (int) (Math.random() * (GameLogic.player.getXp() / 4 + 1) + 10);
					GameLogic.player.setHp(GameLogic.player.getHp() + hpRestored);
					if(GameLogic.player.getHp() > GameLogic.player.getMaxHp()) {
						GameLogic.player.setHp(GameLogic.player.getMaxHp());
					}
					System.out.println("You took a rest and restored " + hpRestored + " hp!");
					System.out.println("You're now at " + GameLogic.player.getHp() + "/" + GameLogic.player.getMaxHp() + " health.");
					GameLogic.player.restsLefts--;
				}
			}
			else {
				System.out.println("You don't rest.");
			}
			Input.anythingToContinue();
		}
	}
}
