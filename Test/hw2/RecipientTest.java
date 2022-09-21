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
    assertEquals("Lingfeng Xia Email:xia.lin@123.com", recipientOne.toString());
  }

  /**
   * Test if the constructor will properly raise an IllegalArgumentException.
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient1() {
    Recipient testRecipient1 = new Recipient("John", "", "");
  }
}