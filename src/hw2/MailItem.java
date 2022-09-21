package hw2;

import java.lang.IllegalArgumentException;
/**
 * This is a mailItem class.
 */

public class MailItem {

  public final int width;
  public final int height;
  public final int depth;
  Recipient recipient;

  /**
   * A constructor takes width, height, depth and recipient as parameters.
   * @param width the width of the mailItem.
   * @param height the height of the mailItem.
   * @param depth the depth of the mailItem.
   * @param recipient the recipient.
   */
  public MailItem(int width, int height, int depth, Recipient recipient)
      throws IllegalArgumentException {
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
    if (width < 1 || height < 1 || depth < 1 || recipient == null) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Return the recipient of the mailItem.
   * @return the recipient of the mailItem.
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
