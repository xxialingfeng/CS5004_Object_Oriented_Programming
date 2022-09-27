import java.lang.IllegalArgumentException;
/**
 * This is a mailItem class.
 */

public class MailItem {

  private final int width;
  private final int height;
  private final int depth;
  private static final int THRESHOLD = 1;
  private final Recipient recipient;

  /**
   * Get width.
   * @return width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Return height.
   * @return height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Get depth.
   * @return depth
   */
  public int getDepth() {
    return this.depth;
  }

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
    if (width < THRESHOLD || height < THRESHOLD || depth < THRESHOLD || recipient == null) {
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