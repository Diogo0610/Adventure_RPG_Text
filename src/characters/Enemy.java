package characters;

import game.GameLogic;

public class Enemy extends Character{
	
	int playerXp;

	public Enemy(String name, int playerXp) {
		super(name, (int)(Math.random() * playerXp / 3 + 5), (int)(Math.random() * (playerXp / 4 + 2) + 1), 0, 0, 0);
		this.playerXp = playerXp;
	}

	@Override
	public int attack() {
		int dmg = 0;
		
		if(GameLogic.player.getXp() == 0) {
			dmg = random.nextInt(2, 10);
			return dmg;
		}
		else {
			dmg = Math.round((random.nextInt(2, 7) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
			if (dmg <= 0) {
				dmg = 5;
				return dmg;
			}
			else {
				return dmg;
			}
		}
	}

	@Override
	public int defend() {
		int def = 0;
		
		if(GameLogic.player.getXp() == 0) {
			def = random.nextInt(0, 6);
			return def;
		}
		else{
			def = Math.round((random.nextInt(0, 6) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
			if(def <= 0) {
				def = 2;
				return def;
			}
			else {
				return def;
			}
		}
	}
}