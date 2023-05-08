package characters;

public interface Player{

	public abstract int attack();
	public abstract int defend();
	public abstract int collectGold();
	public abstract int earnXp();
	public abstract int getHp();
	public abstract int getXp();
	public abstract int getGold();
	public abstract int getPots();
	public abstract int getMaxHp();
	public abstract String getName();
	public abstract void setHp(int hp);
	public abstract void setXp(int xp);
	public abstract void setGold(int gold);
	public abstract void setPots(int pots);
	public abstract void setMaxHp(int maxHp);
	public abstract String showName();
}