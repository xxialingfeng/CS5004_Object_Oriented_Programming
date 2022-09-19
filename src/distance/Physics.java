package distance;

import java.text.DecimalFormat;

/**.
 * This represents a class called Physics which mainly calculates the velocity
 */
public class Physics {

  /**
   * This is a static method which returns the velocity of two objects.
   * @param one Point3D object
   * @param two Point3D object
   * @param elapsedTime double
   * @return the velocity of two objects.
   * @throws IllegalArgumentException elapse time can not be zero or lower.
   */
  public static double velocity(Point3D one, Point3D two, double elapsedTime) throws IllegalArgumentException {
    if (elapsedTime < 0) {
      throw new IllegalArgumentException("elapsed time can not be zero or below!");
    }
    DecimalFormat df = new DecimalFormat("#.00");
    Double velocity = one.distanceTo(two) / elapsedTime;
    return Double.parseDouble(df.format(velocity));
  }

  /**.
   * main method
   * @param args main method.
   */
  public static void main(String [] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1,1,1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 0);
      System.out.println("Prof. Keith is on the move! His Velocity =" + velocity);
      velocity = Physics.velocity(one, two, 5);
      System.out.println("Velocity =" + velocity);
    } catch(IllegalArgumentException e) {
      System.out.println("Encountered an error: " + e.getMessage());
    }
  }
}
