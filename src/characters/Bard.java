package characters;

import game.GameLogic;

public class Bard extends Character implements Player {

	private String className = "Bardo";
	
	public Bard(String name) {
		super(name, 40, 0, 2, 1, 2);
	}

	@Override
	public int attack() {
		int dmg = 0;
		
		if(getXp() == 0) {
			dmg = random.nextInt(1, 4);
			return dmg;
		}
		else {
			dmg = Math.round((random.nextInt(1, 4) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
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
			def = random.nextInt(2, 5);
			return def;
		}
		else{
			def = Math.round((random.nextInt(2, 5) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
			if(def <= 0) {
				def = 2;
				return def;
			}
			else {
				return def;
			}
		}
	}

	@Override
	public int collectGold() {
		int gold = Math.round((random.nextInt(3, 6)));
		return gold;
	}

	@Override
	public int earnXp() {
		int xp = 3;
		return xp;
	}
	
	public String showName() {
		return className;
	}
}
