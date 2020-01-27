public class ClientTest {

	public static void main(String args[]) {

		Client c = new Client(1, "Thomas", "Smith", 10);
		GoldenClient g = new GoldenClient(2, "Anna", "Aureate", 20000);
		PlatinumClient p = new PlatinumClient(5, "John", "Silver", 10000, 50);

		System.out.println(c);
		System.out.println(g);
		System.out.println(p);

		c.addMoney(1000000);
		c.subMoney(50000);

		g.subMoney(13000);
		// Comment next line if improving GoldenClient class 
		g.setGoldenLevel();

		p.addTrips(10);

		System.out.println(c);
		System.out.println(g);
		System.out.println(p);
	}
}
