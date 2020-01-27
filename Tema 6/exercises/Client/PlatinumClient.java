public class PlatinumClient extends Client{
	int numberOfTrips;
	double travelOffersRate;

	public PlatinumClient(int id, String firstName, String lastName, double amount, int numberOfTrips) {
		super(id, firstName, lastName, amount);
		setNumberOfTrips(numberOfTrips);
	}

	public int getNumberOfTrips(){
		return numberOfTrips;
	}

	public void setNumberOfTrips(int numberOfTrips){
		this.numberOfTrips=numberOfTrips;
	}

	public double getTravelOffersRate(){
		return travelOffersRate;
	}

	public void setTravelOffersRate(){
		travelOffersRate=numberOfTrips*0.01;
	}

	public void addTrips(int n){
		numberOfTrips=numberOfTrips+n;
	}

	public String toString(){
		return super.toString()+"\nNumber of Trips: "+numberOfTrips+"\nTravel Offers Rate: "+travelOffersRate;
	}
}