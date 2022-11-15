package Shape;

/**
 * This is a interface indicating photo shape.
 */
public interface IShape {

  /**
   * get the position of the shape.
   * @return position
   */
  Position getPosition();

  /**
   * Get the name of the shape.
   * @return name
   */
  String getName();

  /**
   * Get color of IShape object.
   * @return color
   */
  Color getColor();

  /**
   * Move the position of IShape object.
   * @param newPos new Position.
   * @return new IShape object.
   */
  IShape move(Position newPos);


  /**
   * Change color of IShape object.
   * @param newColor new Color.
   * @return new IShape object.
   */
  IShape changeColor(Color newColor);

  /**
   * Change size of IShape object.
   * @param size1 newSize1
   * @param size2 newSize2
   * @return new IShape object.
   */
  IShape changeSize(double size1, double size2);
}
