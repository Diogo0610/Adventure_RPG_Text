package characters;

import game.GameLogic;

public class Druid extends Character implements Player {

	private String className = "Druida";
	
	public Druid(String name) {
		super(name, 35, 0, 5, 1, 1);
	}

	@Override
	public int attack() {
		int dmg = 0;
		
		if(getXp() == 0) {
			dmg = random.nextInt(4, 6);
			return dmg;
		}
		else {
			dmg = Math.round((random.nextInt(4, 6) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
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
			def = random.nextInt(4, 6);
			return def;
		}
		else{
			def = Math.round((random.nextInt(4, 6) * GameLogic.player.getXp()) / GameLogic.player.getXp() - random.nextInt(1, 3));
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
		int gold = Math.round((random.nextInt(1, 3)));
		return gold;
	}

	@Override
	public int earnXp() {
		int xp = 1;
		return xp;
	}
	
	public String showName() {
		return className;
	}
}
