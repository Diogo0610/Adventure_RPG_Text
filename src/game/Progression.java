package game;

public class Progression {
	static UIMethods ui = new UIMethods();
	Battle battle;
	private int place = 0;
	private int act = 1;
	public String[] places = {"Ponte do Brandevin", "Beirágua", "Sapântano", "Hobbiton"};
	public String[] enemies = {"Bardeneiro", "Soldado recruta", "Lenhador", "Construtor de represa", "Incendiário"};
	
	public void setPlace(int place) {
		this.place = place;
	}
	
	public int getPlace() {
		return place;
	}
	
	public void setAct(int act) {
		this.act = act;
	}
	public int getAct() {
		return act;
	}
	
	public void takeRest() {
		ui.clearConsole();
		if(GameLogic.player.restsLefts >= 1) {
			ui.printHeading("Do you want to take a rest?(" + GameLogic.player.restsLefts + " rests lefts).");
			System.out.println("(1) Yes\n(2) No");
			int input = GameLogic.readInt("->", 2);
			if(input == 1) {
				ui.clearConsole();
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
			GameLogic.anythingToContinue();
		}
	}
	
	public void randomBattle() {
		ui.clearConsole();
		ui.printHeading("Battle Time!");
		GameLogic.anythingToContinue();
		new Battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], GameLogic.player.getXp()));
	}
	
	public void finalBattle() {
		new Battle(new Enemy("Evil Emperor", 300));
		GameLogic.isRunning = false;
	}
	
	public void journeyOptions() {
		ui.clearConsole();
		ui.printHeading(places[place]);
		System.out.println("Select a action: ");
		ui.printSeparator(20);
		System.out.println("(1) Batalhar");
		System.out.println("(2) Informações do Personagem");
		System.out.println("(3) Sair do jogo");
	}
	
	public void playerDied() {
		ui.clearConsole();
		System.out.println("YOU DIED! TRY AGAIN!");
		System.out.println("You earned " + GameLogic.player.getXp() + " XP!");
		GameLogic.isRunning = false;
	}
}