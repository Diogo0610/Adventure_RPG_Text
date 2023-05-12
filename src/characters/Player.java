package characters;

/*
 * A interface Player define um conjunto de métodos que são necessários para representar um jogador no jogo. 
 * Esses métodos devem ser implementados nas classes de jogadores específicas, como
 * Warrior, Ranger, Druid, Bard e Cleric, para fornecer a funcionalidade adequada a cada classe.
 */
public interface Player{

	//Representa o ataque do jogador. Retorna um valor inteiro que representa o dano causado.
	public abstract int attack();
	
	//Representa a defesa do jogador. Retorna um valor inteiro que representa a quantidade de dano reduzido.
	public abstract int defend();
	
	//Representa a coleta de ouro pelo jogador. Retorna um valor inteiro que representa a quantidade de ouro coletada.
	public abstract int collectGold();
	
	// Representa o ganho de experiência pelo jogador. Retorna um valor inteiro que representa a quantidade de experiência ganha.
	public abstract int earnXp();
	
	//Retorna a quantidade atual de pontos de vida do jogador.
	public abstract int getHp();
	
	//Retorna a quantidade atual de experiência do jogador.
	public abstract int getXp();
	
	//Retorna a quantidade atual de ouro do jogador.
	public abstract int getGold();
	
	//Retorna a quantidade atual de poções do jogador.
	public abstract int getPots();
	
	//Retorna a quantidade atual de descansos do jogador.
	public abstract int getRests();
	
	//Retorna a quantidade máxima de pontos de vida do jogador.
	public abstract int getMaxHp();
	
	//Retorna o nome do jogador.
	public abstract String getName();
	
	//Define a quantidade atual de pontos de vida do jogador.
	public abstract void setHp(int hp);
	
	//Define a quantidade atual de experiência do jogador.
	public abstract void setXp(int xp);
	
	// Define a quantidade atual de ouro do jogador.
	public abstract void setGold(int gold);
	
	//Define a quantidade atual de poções do jogador.
	public abstract void setPots(int pots);
	
	//Define a quantidade atual de descansos do jogador.
	public abstract void setRests(int rests);
	
	//Define a quantidade máxima de pontos de vida do jogador.
	public abstract void setMaxHp(int maxHp);
	
	//Retorna uma representação legível do nome do jogador.
	public abstract String showName();
}