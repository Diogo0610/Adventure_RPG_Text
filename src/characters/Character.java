package characters;
import java.util.Random;

public abstract class Character {

	private String name;
	private int maxHp, hp, xp, gold, pots, rests;
	Random random = new Random();
	
	public Character(String name, int maxHp, int xp, int gold, int pots, int rests) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.xp = xp;
		this.pots = pots;
		this.rests = rests;
	}
	
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
