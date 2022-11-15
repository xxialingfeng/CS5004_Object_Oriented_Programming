package Shape;

import java.text.DecimalFormat;

/**
 * This is a color class indicating the color of the shape.
 */
public class Color {
  private double r;
  private double g;
  private double b;

  /**
   * This is a color constructor.
   * @param r double
   * @param g double
   * @param b double
   */
  public Color(double r, double g, double b) throws IllegalArgumentException {
    if (outOfBound(r, g, b)) {
      throw new IllegalArgumentException("color r, g, and b must between 0 - 255!");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Check if r, g, and b is within the right range.
   * @param r double
   * @param g double
   * @param b double
   * @return whether the r, g, and b is within the right range
   */
  private boolean outOfBound(double r, double g, double b) {
    return r <= 255 && r >= 0 && g <= 255 && g >= 0 && b >= 0 && b <= 255;
  }

  /**
   * ToString method.
   * @return String form of color.
   */
  @Override
  public String toString() {
    String pattern = "##0.0";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String formatR = decimalFormat.format(this.r);
    String formatG = decimalFormat.format(this.g);
    String formatB = decimalFormat.format(this.b);
    return "(" + formatR
        + "," + formatG + ","
        + formatB + ")";
  }
}
