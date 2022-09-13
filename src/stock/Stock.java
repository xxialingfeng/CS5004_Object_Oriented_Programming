package stock;

import java.text.DecimalFormat;

/**.
 * This class represents stock.
 * @author Lingfeng Xia
 */
public class Stock {
  private String symbol;
  private String name;
  private double costBasis;
  private double currentPrice;

  /**
   * Construct a stock object that has provided symbol, name, and costbasis.
   * @param symbol the name of the stock
   * @param name stock name
   * @param costBasis the start price of the stock
   */
  public Stock(String symbol, String name, double costBasis) {
    this.symbol = symbol;
    this.name = name;
    this.costBasis = costBasis;
  }

  /**
   * Return the symbol of the stock.
   *
   * @return the symbol of the stock
   */
  public String getSymbol() {
    return this.symbol;
  }

  /**
   * Return the name of the stock.
   *
   * @return the name of the stock
   */
  public String getName() {
    return this.name;
  }

  /**
   * Return the cost basis of the stock.
   *
   * @return the cost basis of the stock
   */
  public double getCostBasis() {
    return this.costBasis;
  }

  /**
   * Return the current price of the stock.
   *
   * @return the current price of the stock
   */
  public double getCurrentPrice() {
    return this.currentPrice;
  }

  /**
   * Set the cost basis of the stock.
   *
   * @param costBasis set the cost basis of the stock
   */
  public void setCostBasis(double costBasis) {
    this.costBasis = costBasis;
  }

  /**
   * Set the instance of the stock.
   *
   * @param currentPrice set the instance of the stock
   */
  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }

  /**
   * Return the change percent of the stock.
   *
   * @return the change percent of the stock
   */
  public double getChangePercent() {
    double initial = (this.currentPrice - this.costBasis) / this.costBasis;
    //return ((int)(initial * 10000)) / 10000.0;
    //String str = String.format("%.4f", initial);
    //return Double.parseDouble(str);
    DecimalFormat df = new DecimalFormat("#.0000");
    return Double.parseDouble(df.format(initial));
  }

  /**
   * Return the information about the stock in string format.
   *
   * @return the information about the stock in string format
   */
  public String toString() {
    String ans = "";
    double initial = 100 * (this.currentPrice - this.costBasis) / this.costBasis;
    DecimalFormat df = new DecimalFormat("#.00");
    ans += this.name + " " + "Current Price: $ " + getCurrentPrice();
    ans += "\r\n" + " " + "Gain/Loss: " + df.format(initial) + "%";
    return ans;
  }
}
