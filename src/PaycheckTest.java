import static org.junit.Assert.*;

import org.junit.Test;

public class PaycheckTest {

  @Test
  public void getPayAfterTaxes() {
    Paycheck pc = new Paycheck(0.005,1);
    assertEquals(0.01, pc.getPayAfterTaxes(), 0.000);
  }
}