package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for locker.
 */
public class LockerTest {
  private Locker testLocker1;
  private MailItem validMail;
  private Recipient testRecipient1 = new Recipient("John", "Xia",
      "John_xia@yahoo.com");
  /**
   * Initializes a new valid Locker and MailItem
   * object prior to running each unit test.
   */
  @Before
  public void setUp() {
    Locker testLocker1 = new Locker(4, 6, 5);
    MailItem validMail = new MailItem(1, 2, 3, testRecipient1);
    this.testLocker1 = testLocker1;
    this.validMail = validMail;
  }

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

  /**
   * Checks that a constructor with invalid inputs
   * properly throws an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Locker invalidLocker1 = new
        Locker(-1, 2, 5);
  }

  /**
   * Checks that a constructor with invalid inputs
   * properly throws an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    Locker invalidLocker1 = new
        Locker(5, 2, -5);
  }

  /**
   * Tests if pickupmail() properly returns
   * the mailitem object in the locker.
   */
  @Test
  public void pickupMail() {
    testLocker1.addMail(validMail);
    assertEquals(testLocker1.pickupMail(testRecipient1), validMail);

    Locker testLocker2 = new Locker(100,500,300);
    testLocker2.addMail(validMail);
    assertEquals(testLocker2.pickupMail(testRecipient1), validMail);
  }


  /**
   * Tests if pickupMail() properly handles attempts
   * to pickup mail from a locker that's empty and
   * picking up mail with the wrong recipient name.
   */
  @Test
  public void pickupInvalidMail() {
    // Try to pick up mail from an empty locker.
    assertEquals(testLocker1.pickupMail(testRecipient1), null);

    // Try to pickup mail with the wrong recipient name.
    testLocker1.addMail(validMail);
    assertEquals(testLocker1.pickupMail(new Recipient("Leon", "Masker",
        "Leon_masker@protonmail.com")), null);
  }
}
