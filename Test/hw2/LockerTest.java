package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * This is a test class for locker.
 */
public class LockerTest {

  /**
   * Test if the locker can add mail.
   */
  @Test
  public void addMail() {
    Locker lockerOne = new Locker(4,4,4);
    Recipient recipientOne = new Recipient("Kyle","Lopez", "kl@123.com");
    MailItem mailItemOne = new MailItem(3,3,3, recipientOne);
    lockerOne.addMail(mailItemOne);
    assertEquals(mailItemOne, lockerOne.item);
    Locker lockerTwo = new Locker(3,3,3);
    Recipient recipientTwo = new Recipient("Linda","Wan","lw@123.com");
    MailItem mailItemTwo = new MailItem(3,2,3, recipientTwo);
    lockerTwo.addMail(mailItemTwo);
    assertEquals(mailItemTwo, lockerTwo.item);
    Locker lockerThree = new Locker(4,5,3);
    MailItem mailItemThree = new MailItem(3,6,3,recipientTwo);
    lockerThree.addMail(mailItemThree);
    assertNull(lockerThree.item);
  }
}