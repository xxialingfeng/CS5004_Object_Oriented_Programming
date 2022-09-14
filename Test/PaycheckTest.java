import static org.junit.Assert.*;

import org.junit.Test;

public class PaycheckTest {

  @Test
  public void testToString() {
    Paycheck pc = new Paycheck(0.005,1);
    assertEquals("Payment after taxes: $ 0.01", pc.toString());

  }
}