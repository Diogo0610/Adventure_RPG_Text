package characters;

public class Warrior extends Character implements Player {

	private String className = "Guerreiro";
	
	public Warrior(String name) {
		super(name, 50, 0);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int collectGold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int earnXp() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String showName() {
		return className;
	}
	
}
