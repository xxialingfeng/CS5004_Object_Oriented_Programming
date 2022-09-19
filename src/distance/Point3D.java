package distance;

import java.text.DecimalFormat;

/**.
 * This represents a point-3D class
 */
public class Point3D {
  private int x;
  private int y;
  private int z;

  /**.
   * This represents a constructor that takes no parameters
   */
  public Point3D() {

  }

  /**
   * This represents a constructor that takes x, y, z as parameters.
   * @param x x-value
   * @param y y-value
   * @param z z-value
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**.
   * Return x value.
   * @return x value
   */
  public int getX() {
    return this.x;
  }

  /**
   * Return y value.
   * @return v value.
   */
  public int getY() {
    return this.y;
  }

  /**.
   * Return z value.
   * @return z value.
   */
  public int getZ() {
    return this.z;
  }

  /**.
   * Return the distance of this point3D object to another Point3D object.
   * @param other Point3D object.
   * @return the distance of this point3D object to another Point3D object.
   */
  public double distanceTo(Point3D other) {
    DecimalFormat df = new DecimalFormat("#.0000");
    Double distance = Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
        + ((this.y - other.getY()) * (this.y - other.getY()))
        + (this.z - other.getZ()) * (this.z - other.getZ()));
    return Double.parseDouble(df.format(distance));
  }

  /**.
   * Override equal method
   * @param other A Point3D object
   * @return if this Point3D object is equal to another Point3D object
   */
  public boolean equals(Point3D other) {
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    if (this == other) {
      return true;
    }
    return this.x == other.getX() && this.y == other.getY() && this.z == other.getZ();
  }

  /**.
   * Override hashCode() method, return a int representing hashcode
   * @return a int representing hashcode
   */
  public int hashCode() {
    return 31 * x + x + 31 * 2 * y + y + 31 * 3 * z + z;
  }
}