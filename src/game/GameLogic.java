package game;

public class GameLogic {
	static Player player;
	boolean isRunning;
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
	
	public void startGame() {
		boolean nameSet = false;
		String name;
		//print title screen
		UIMethods.clearConsole();
		UIMethods.printSeparator(40);
		UIMethods.printSeparator(30);
		System.out.println("Expurgo do Condado");
		UIMethods.printSeparator(40);
		UIMethods.printSeparator(30);
		Input.anythingToContinue();
		
		do {
			UIMethods.clearConsole();
			UIMethods.printHeading("Whats your name?");
			name = Input.scanner.next();
			//correct name
			UIMethods.clearConsole();
			UIMethods.printHeading("Your name is: " + name + ".\nIs that correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No! I want to change my name!");
			int input = Input.read(2);
			if (input == 1) {
				nameSet = true;
			}
		} while(!nameSet);
		
		//cria o jogador
		player = new Player(name);
		
		isRunning = true;
		
		//começa o jogo
		gameLoop();
	}
	
	public void journeyOptions() {
		UIMethods.clearConsole();
		UIMethods.printHeading(places[place]);
		System.out.println("Select a action: ");
		UIMethods.printSeparator(20);
		System.out.println("(1) Batalhar");
		System.out.println("(2) Informações do Personagem");
		System.out.println("(3) Sair do jogo");
	}
	
	public void characterInfo() {
		UIMethods.clearConsole();
		UIMethods.printHeading("Character Info");
		System.out.println(player.getName() + "\tHP: " + player.getHp() + "/" + player.getMaxHp());
		UIMethods.printSeparator(20);
		System.out.println("XP: " + player.getXp() + "\tGold: " + player.gold);
		UIMethods.printSeparator(20);
		System.out.println("Potions: " + player.pots);
		UIMethods.printSeparator(20);
		
		//printing traits
		if(player.numAtkUpgrades > 0) {
			System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
			UIMethods.printSeparator(20);
		}
		if(player.numDefUpgrades > 0) {
			System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
			UIMethods.printSeparator(20);
		}
		
		Input.anythingToContinue();
	}
	
	public void randomBattle() {
		UIMethods.clearConsole();
		UIMethods.printHeading("Battle Time!");
		Input.anythingToContinue();
		new Battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], GameLogic.player.getXp()));
	}
	
	public void finalBattle() {
		new Battle(new Enemy("Evil Emperor", 300));
		isRunning = false;
	}
	
	public void playerDied() {
		UIMethods.clearConsole();
		System.out.println("YOU DIED! TRY AGAIN!");
		System.out.println("You earned " + GameLogic.player.getXp() + " XP!");
		isRunning = false;
	}
	
	public void gameLoop() {
		while(isRunning) {
			GameFlow gameFlow = new GameFlow();
			gameFlow.sequence();
			journeyOptions();
			int input = Input.read(3);
			if(input == 1) {
				randomBattle();
			}
			else if(input == 2) {
				characterInfo();
			}
			else {
				isRunning = false;
			}
		}
	}
}
