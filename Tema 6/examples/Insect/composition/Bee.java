package composition;

public class Bee extends Insect implements Attack {

	private Attack attack;

	public Bee(int size, String color, Attack attack) {
		super(size, color);
		this.attack = attack;
	}

	@Override
	public void move() {
		attack.move();
	}

	@Override
	public void attack() {
		attack.attack();
	}

}
