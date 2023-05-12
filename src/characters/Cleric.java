package characters;

import game.GameLogic;

public class Cleric extends Character implements Player {

	private String className = "Clérigo";
	
	public Cleric(String name) {
		super(name, 25, 0, 10, 2, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int attack() {
		int dmg = 0;
		
		if(getXp() == 0) {
			dmg = random.nextInt(2, 4);
			return dmg;
		}
		else {
			dmg = Math.round((random.nextInt(2, 4) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
			if (dmg <= 0) {
				dmg = 2;
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
		
		if(getXp() == 0) {
			def = random.nextInt(4, 8);
			return def;
		}
		else{
			def = Math.round((random.nextInt(4, 8) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
			if(def <= 0) {
				def = 1;
				return def;
			}
			else {
				return def;
			}
		}
	}

	@Override
	public int collectGold() {
		int gold = Math.round((random.nextInt(0, 3)));
		return gold;
	}

	@Override
	public int earnXp() {
		int xp = 2;
		return xp;
	}
	
	public String showName() {
		return className;
	}
}