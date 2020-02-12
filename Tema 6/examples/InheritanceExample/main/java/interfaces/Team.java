package main.java.interfaces;

public class Team implements BasketballTeam, FootballTeam {

	private String name = null;
	
	public Team(String name) {
		this.name = name;
	}

	@Override
	public void printFootballName() {
		System.out.println("Football Team: \"" + name + " F.C.\"");
	}

	@Override
	public void printBasketballName() {
		System.out.println("Basketball Team: \"" + name + " B.C.\"");
	}
	
	public static void main(String[] args) {
		Team t = new Team("Team A");
		t.printBasketballName();
		t.printFootballName();
	}
}
