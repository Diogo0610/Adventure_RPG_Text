package characters;

public class Enemy extends Character{
	
	int playerXp;

	public Enemy(String name, int playerXp) {
		super(name, (int)(Math.random() * playerXp / 3 + 5), (int)(Math.random() * (playerXp / 4 + 2) + 1));
		this.playerXp = playerXp;
	}

	@Override
	public int attack() {
		return (int)(Math.random() * (playerXp / 4 + 1) + getXp() / 4 + 3);
	}

	@Override
	public int defend() {
		return (int)(Math.random() * (playerXp / 4 + 1) + getXp() / 4 + 3);
	}
}