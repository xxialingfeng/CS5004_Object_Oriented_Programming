import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**.
 * This is a test class for paycheck
 */
public class PaycheckTest {

  /**
   * Test the string representation is the same format as expected.
   */
  @Test
  public void testToString() {
    Paycheck pc = new Paycheck(0.005,1);
    assertEquals("Payment after taxes: $ 0.01", pc.toString());
    pc = new Paycheck(10.5,40);
    assertEquals("Payment after taxes: $ 357.00", pc.toString());
  }

  /**
   * Test if the payment after taxes matches.
   */
  @Test
  public void getPayAfterTaxes() {
    Paycheck pc = new Paycheck(3.4,5);
    assertEquals(15.3,pc.getPayAfterTaxes(),0.000);
    pc = new Paycheck(0.002, 3);
    assertEquals(0.01,pc.getPayAfterTaxes(), 0.000);
  }

  /**
   * Test if total payment matches.
   */
  @Test
  public void getTotalPay() {
    Paycheck pc = new Paycheck(0.04,32);
    assertEquals(1.28, pc.getTotalPay(), 0.000);
    pc = new Paycheck(15, 29);
    assertEquals(435.0, pc.getTotalPay(),0.000);
  }
}