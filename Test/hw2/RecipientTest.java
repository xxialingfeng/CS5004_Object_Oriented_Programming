package hw2;

import org.junit.Test;

/**
 * This is a test class for recipient object.
 */
public class RecipientTest {

  /**
   * Test if can get the information in given format.
   */
  @Test
  public void testToString() {
    Recipient recipientOne = new Recipient("Lingfeng", "Xia", "xia.lin@123.com");
    assertEquals("Lingfeng Xia xia.lin@123.com", recipientOne.toString());
  }
}