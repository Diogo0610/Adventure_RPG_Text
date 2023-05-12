package characters;
import java.util.Random;

public abstract class Character {
	
	/*
	 * name: O nome do personagem.
	 * maxHp: A quantidade máxima de pontos de vida do personagem.
	 * hp: A quantidade atual de pontos de vida do personagem.
	 * xp: A quantidade atual de experiência do personagem.
	 * gold: A quantidade atual de ouro do personagem.
	 * pots: A quantidade atual de poções do personagem.
	 * rests: A quantidade atual de descansos do personagem.
	 * random: Um objeto da classe Random para gerar números aleatórios.
	 */
	private String name;
	private int maxHp, hp, xp, gold, pots, rests;
	Random random = new Random();
	
	/*
	 * Character(String name, int maxHp, int xp, int gold, int pots, int rests): 
	 * Constrói um objeto Character com os atributos iniciais fornecidos.
	 */
	public Character(String name, int maxHp, int xp, int gold, int pots, int rests) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.xp = xp;
		this.pots = pots;
		this.rests = rests;
	}
	
	//Define o nome do personagem.
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getHp() {
		return hp;
	}
	
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getXp() {
		return xp;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setPots(int pots) {
		this.pots = pots;
	}
	
	public int getPots() {
		return pots;
	}

	public int getRests() {
		return rests;
	}

	public void setRests(int rests) {
		this.rests = rests;
	}

	//Um método abstrato que representa o ataque do personagem. Deve ser implementado nas subclasses.
	public abstract int attack();
	
	//Um método abstrato que representa a defesa do personagem. Deve ser implementado nas subclasses.
	public abstract int defend();
}
