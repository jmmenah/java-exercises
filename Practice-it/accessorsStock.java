/*
Encapsulate the Stock class below by making the fields private. Also add accessor methods named getSymbol, getTotalShares, and getTotalCost to return the stock's symbol, total shares, and total cost respectively.
*/
public class Stock {
    private String symbol;    // stock symbol, e.g. "YHOO"
    private int totalShares;  // total shares purchased
    private double totalCost;

    public Stock(String theSymbol) {
        if (theSymbol == null) {
            throw new NullPointerException();
        }
        symbol = theSymbol;
        totalShares = 0;
        totalCost = 0.0;
    }
    
    public double getProfit(double currentPrice) {
        if (currentPrice < 0.0) {
            throw new IllegalArgumentException();
        }

        double marketValue = totalShares * currentPrice;
        return marketValue - totalCost;
    }
    
    public void purchase(int shares, double pricePerShare) {
        if (shares < 0 || pricePerShare < 0.0) {
            throw new IllegalArgumentException();
        }
    
        totalShares += shares;
        totalCost += shares * pricePerShare;
    }
    public String getSymbol(){
        return symbol;
    }
    public int getTotalShares(){
        return totalShares;
    }
    public double getTotalCost(){
        return totalCost;
    }
}
