package hw2;

import static org.junit.Assert.assertEquals;

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
    assertEquals("Lingfeng Xia\nxia.lin@123.com", recipientOne.toString());
  }
}