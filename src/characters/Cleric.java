package characters;

public class Cleric extends Character implements Player {

	private String className = "Clérigo";
	
	public Cleric(String name) {
		super(name, 40, 0);
		// TODO Auto-generated constructor stub
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