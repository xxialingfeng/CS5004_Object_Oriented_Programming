package hw2;

import java.lang.IllegalArgumentException;
/**
 * This is a Locker class.
 */

public class Locker {
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private static final int THRESHOLD = 1;
  private MailItem item;

  /**
   * This is a constructor that takes maxWidth, maxHeight, and maxDepth as parameters.
   * @param maxWidth maximum width.
   * @param maxHeight maximum height.
   * @param maxDepth maximum depth.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth)
      throws IllegalArgumentException {
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.item = null;
    if (maxWidth < THRESHOLD || maxHeight < THRESHOLD || maxDepth < THRESHOLD) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Add mail item to the locker if the dimensions of the mail are less than the locker.
   * @param mailItem the mail item
   */
  public void addMail(MailItem mailItem) {
    if (this.item == null && mailItem.getWidth() <= this.maxWidth && mailItem.getHeight() <= this.maxHeight
        && mailItem.getDepth() <= this.maxDepth) {
      this.item = mailItem;
    }
  }

  /**
   * Pick up the mail if the recipient matches and the locker is not null.
   * @param recipient the Recipient
   * @return the mail item if can get the item from the locker.
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.item != null && this.item.getRecipient().equals(recipient)) {
      MailItem pickup = this.item;
      this.item = null;
      return pickup;
    }
    return null;
  }
}
