package distance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**.
 * This is a test class for Point3D class
 */
public class Point3DTest {

  /**
   *Create a Point3D object to test if we can get the x value of the object.
   */
  @Test
  public void getXTest() {
    Point3D pointOne = new Point3D(1,2,3);
    assertEquals(1, pointOne.getX());
  }

  /**
   * Create a Point3D object to test if we can get the y value of the object.
   */
  @Test
  public void getYTest() {
    Point3D pointTwo = new Point3D(2,3,4);
    assertEquals(3, pointTwo.getY());
  }

  /**
   * Create a Point3D object to test if we can get the z value of the object.
   */
  @Test
  public void getZTest() {
    Point3D pointThree = new Point3D(3,4,5);
    assertEquals(5, pointThree.getZ());
  }

  /**
   * Create two Point3D objects to test if we can get the distance of two objects..
   */
  @Test
  public void distanceToTest() {
    Point3D pointFour = new Point3D(4,5,6);
    Point3D pointFive = new Point3D(1,2,3);
    assertEquals(5.196, pointFour.distanceTo(pointFive), 0.000);
  }

  /**.
   * Test if one object equals to another
   */
  @Test
  public void testEquals() {
    Point3D pointSix = new Point3D(7,8,9);
    Point3D pointSeven = new Point3D(7,8,9);
    assertEquals(true, pointSix.equals(pointSeven));
  }
}