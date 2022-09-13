package stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A Junit test class for the Stock class
 */
public class StockTest {

  private Stock apple;

  @Before
  public void setUp() {
    apple = new Stock("Computer", "Apple", 200.0);
    apple.setCurrentPrice(300);
  }

  @Test
  public void testSymbol() {
    assertEquals("Computer", apple.getSymbol());
  }

  @Test
  public void testName() {
    assertEquals("Apple", apple.getName());
  }

  @Test
  public void testCostBasis() {
    assertEquals(200.0, apple.getCostBasis(), 0.00);
  }

  @Test
  public void getCurrentPrice() {
    assertEquals(300, apple.getCurrentPrice(),0.000);
  }

  @Test
  public void testSetCostBasis() {
    Stock stockOne = new Stock("Phone", "Apple", 200);
    stockOne.setCostBasis(250);
    assertEquals(250, stockOne.getCostBasis(), 0.000);
  }

  @Test
  public void testGetChangePercent() {
    Stock stockTwo = new Stock("TV", "Dell", 500);
    stockTwo.setCurrentPrice(600);
    assertEquals(0.5, apple.getChangePercent(), 0.000);
    assertEquals(0.2, stockTwo.getChangePercent(), 0.000);
  }


  @Test
  public void testToString() {
    Stock stockThree = new Stock("Clothes", "NorthFace", 300);
    stockThree.setCurrentPrice(450);
    assertEquals("NorthFace Clothes Current Price: $ 450.0\r\n Gain/Loss: 50.0%", stockThree.toString());
    assertEquals("Apple Computer Current Price: $ 300.0\r\n Gain/Loss: 50.0%", apple.toString());
  }
}