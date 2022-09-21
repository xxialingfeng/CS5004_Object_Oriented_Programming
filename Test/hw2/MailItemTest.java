package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This is a test class for mail item object.
 */
public class MailItemTest {

  /**
   * Test if can get the recipient in mail item.
   */
  @Test
  public void getRecipient() {
    Recipient recipientTwo = new Recipient("Jake","Laden", "jl@123.com");
    MailItem mailItemOne = new MailItem(2,2, 2, recipientTwo);
    assertEquals(recipientTwo, mailItemOne.getRecipient());
  }
}