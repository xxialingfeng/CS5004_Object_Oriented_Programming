package stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A Junit test class for the Stock class.
 */
public class StockTest {

  private Stock apple;

  /**
   * Create a stock class.
   */
  @Before
  public void setUp() {
    apple = new Stock("Computer", "Apple", 200.0);
    apple.setCurrentPrice(300);
  }

  /**
   * Test if symbol of stock matches.
   */
  @Test
  public void testSymbol() {
    assertEquals("Computer", apple.getSymbol());
  }

  /**
   * Test if name of stock matches.
   */
  @Test
  public void testName() {
    assertEquals("Apple", apple.getName());
  }

  /**
   * Test if cost basis matches.
   */
  @Test
  public void testCostBasis() {
    assertEquals(200.0, apple.getCostBasis(), 0.00);
  }

  /**
   * Test if current price matches.
   */
  @Test
  public void getCurrentPrice() {
    assertEquals(300, apple.getCurrentPrice(),0.000);
  }

  /**
   * Test if stock can be set new cost basis.
   */
  @Test
  public void testSetCostBasis() {
    Stock stockOne = new Stock("Phone", "Apple", 200);
    stockOne.setCostBasis(250);
    assertEquals(250, stockOne.getCostBasis(), 0.000);
  }

  /**
   * Test if change percent matches.
   */
  @Test
  public void testGetChangePercent() {
    Stock stockTwo = new Stock("TV", "Dell", 500);
    stockTwo.setCurrentPrice(600);
    assertEquals(0.5, apple.getChangePercent(), 0.000);
    assertEquals(0.2, stockTwo.getChangePercent(), 0.000);
  }

  /**
   * Test if to String matches.
   */
  @Test
  public void testToString() {
    Stock stockThree = new Stock("Clothes", "NorthFace", 192.20);
    stockThree.setCurrentPrice(202.12);
    assertEquals("NorthFace Current Price: $ 202.12\n Gain/Loss: 5.16%", stockThree.toString());
    assertEquals("Apple Current Price: $ 300.0\n Gain/Loss: 50.00%", apple.toString());
  }
}