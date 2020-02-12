package inheritance;

public class Bee extends Insect {

	public Bee(int size, String color) {
		super(size, color);
	}

	public void move() {
		System.out.println("Fly");
	}

	public void attack() {
		move();
		//super.attack();
		 System.out.println("Attack");
	}
}
