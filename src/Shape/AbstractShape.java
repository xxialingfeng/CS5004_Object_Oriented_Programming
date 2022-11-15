package Shape;

import java.util.Objects;

/**
 * This is a abstract class for Shape.
 */
public class AbstractShape implements IShape {
  protected String name;
  protected Color color;
  protected Position pos;

  /**
   * This is the constructor for AbstractShape.
   * @param name String name.
   * @param pos Position object.
   * @param color Color object.
   * @throws IllegalArgumentException if name is null.
   */
  protected AbstractShape(String name, Color color, Position pos)
      throws IllegalArgumentException {
    if (name.length() == 0) {
      throw new IllegalArgumentException("name should not be empty!");
    }
    this.name = name;
    this.color = color;
    this.pos = pos;
  }

  @Override
  public Position getPosition() {
    return this.pos;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public IShape move(Position newPos) {
    return null;
  }

  @Override
  public IShape changeColor(Color newColor) {
    return null;
  }

  @Override
  public IShape changeSize(double size1, double size2) {
    return null;
  }

  /**
   * Equal method to compare shape objects.
   * @param o IShape object.
   * @return boolean whether two objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return name.equals(that.name) && pos.equals(that.pos) && color.equals(that.color);
  }

  /**
   * HashCode of IShape object.
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, pos, color);
  }
}
