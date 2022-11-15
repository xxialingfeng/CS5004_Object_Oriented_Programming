package Shape;

/**
 * This is a class representing rectangle.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;

  /**
   * this is a constructor of rectangle.
   * @param name name of the shape
   * @param color color of the shape
   * @param pos position of the shape
   * @param width width of the shape
   * @param height height of the shape
   * @throws IllegalArgumentException " "
   */
  public Rectangle(String name, Color color, Position pos, double width, double height)
      throws IllegalArgumentException {
    super(name, color, pos);
    this.width = width;
    this.height = height;
  }

  /**
   * Getter method for width.
   * @return width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Getter method for height.
   * @return height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Move Rectangle to a new position.
   * @param newPosition new Position object.
   * @return new Rectangle object.
   */
  @Override
  public IShape move(Position newPosition) {
    return new Rectangle(this.name, this.color, newPosition,
        this.width, this.height);
  }

  /**
   * Change Rectangle color.
   * @param newColor new Color
   * @return new Rectangle object.
   */
  @Override
  public IShape changeColor(Color newColor) {
    return new Rectangle(this.name, newColor, this.pos,
        this.width, this.height);
  }

  /**
   * Change size of IShape object.
   *
   * @param newSize1 newSize1
   * @param newSize2 newSize2
   * @return new IShape object.
   */
  @Override
  public IShape changeSize(double newSize1, double newSize2) {
    return new Rectangle(this.name, this.color, this.pos,
        newSize1, newSize2);
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
        + "Type: rectangle" + "\n"
        + "Min corner: " + this.getPosition().toString()
        + ", " + "Width: " + String.format("%.1f", this.getWidth())
        + ", " + "Height: " + String.format("%.1f", this.getHeight())
        + ", " + "Color: " + this.color.toString();
  }
}
