package game;

import characters.*;

public class GameLogic {
	public String[] places = {"Ponte do Brandevin", "Beirágua", "Sapântano", "Hobbiton"};
	public String[] enemies = {"Bardeneiro", "Soldado recruta", "Lenhador", "Construtor de represa", "Incendiário"};
	private static int place = 0, act = 1;
	private static boolean isRunning;
	public static Player player;
	Battle battle;
	
	public void setPlace(int place) {
		GameLogic.place = place;
	}
	
	public int getPlace() {
		return place;
	}
	
	public void setAct(int act) {
		GameLogic.act = act;
	}
	
	public int getAct() {
		return act;
	}
	
	public void setIsRunning(boolean isRunning) {
		GameLogic.isRunning = isRunning;
	}
	
	public void startGame() {
		boolean nameSet = false;
		boolean characterSet = false;
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
			UIMethods.printHeading("Qual é o seu nome?");
			name = Input.scanner.next();
			//correct name
			UIMethods.clearConsole();
			UIMethods.printHeading("Seu nome é: " + name + ".\nEstá correto?");
			System.out.println("(1) Sim!");
			System.out.println("(2) Não! Eu quero trocar meu nome!");
			int input = Input.read(2);
			if (input == 1) {
				nameSet = true;
			}
		} while(!nameSet);
		
		//cria o jogador
		do {
			UIMethods.clearConsole();
			UIMethods.printHeading("\"Escolha sua classe:\n1 - Guerreiro \n2 - Arqueiro \n3 - Druida \n4 - Bardo \n5 - Clérigo\"");
			int input = Input.read(5);
			switch(input) {
				case 1:
					player = new Warrior(name);
					break;
				case 2:
					player = new Ranger(name);
					break;
				case 3:
					player = new Druid(name);
					break;
				case 4:
					player = new Bard(name);
					break;
				case 5:
					player = new Cleric(name);
					break;
			}
			UIMethods.clearConsole();
			UIMethods.printHeading("Você escolheu a classe: " + player.showName() + ".\nTem certeza?");
			System.out.println("(1) Sim!");
			System.out.println("(2) Não! Eu quero trocar minha classe!");
			input = Input.read(2);
			if (input == 1) {
				characterSet = true;
			}
		} while(!characterSet);
		
		isRunning = true;
		
		//começa o jogo
		gameLoop();
	}
	
	public void journeyOptions() {
		UIMethods.clearConsole();
		UIMethods.printHeading(places[place]);
		System.out.println("Selecione uma ação: ");
		UIMethods.printSeparator(20);
		System.out.println("(1) Batalhar");
		System.out.println("(2) Informações do Personagem");
		System.out.println("(3) Sair do jogo");
	}
	
	public void characterInfo() {
		UIMethods.clearConsole();
		UIMethods.printHeading("Character Info");
		System.out.println("Classe: " + player.showName());
		UIMethods.printSeparator(20);
		System.out.println(player.getName() + "\tHP: " + player.getHp() + "/" + player.getMaxHp());
		UIMethods.printSeparator(20);
		System.out.println("XP: " + player.getXp() + "\tGold: " + player.getGold());
		UIMethods.printSeparator(20);
		System.out.println("Potions: " + player.getPots());
		UIMethods.printSeparator(20);
		
		Input.anythingToContinue();
	}
	
	public void randomBattle() {
		UIMethods.clearConsole();
		UIMethods.printHeading("Você encontrou um oponente!");
		Input.anythingToContinue();
		new Battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], GameLogic.player.getXp()));
	}
	
	public void finalBattle() {
		new Battle(new Enemy("Evil Emperor", 300));
		isRunning = false;
	}
	
	public void playerDied() {
		UIMethods.clearConsole();
		System.out.println("Você morreu! Tente novamente!");
		System.out.println("Você obteve nessa jogada " + GameLogic.player.getXp() + " de XP!");
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
