package game;

public abstract class Character {
	
	private String name;
	private int maxHp, hp, xp;
	
	public Character(String name, int maxHp, int xp) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.xp = xp;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setMaxhp(int maxHp) {
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
	
	public abstract int attack();
	public abstract int defend();
}
