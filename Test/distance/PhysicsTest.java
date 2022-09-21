package distance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**.
 * A test class for Physics
 */
public class PhysicsTest {

  /**.
   * Test if the velocity is what expected
   */
  @Test
  public void velocityTest() {
    Point3D one = new Point3D(1,1,1);
    Point3D two = new Point3D(2,2,2);
    double elapsedTime = 5;
    assertEquals(0.3464, Physics.velocity(one, two, elapsedTime), 0.000);
  }

  /**
   * Checks that a constructor with invalid inputs
   * properly throws an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInput() {
    Point3D pointEight = new Point3D(2,2,2);
    Point3D pointNine = new Point3D(4,4,4);
    double elapsedTime = -1;
    Physics.velocity(pointEight,pointNine,elapsedTime);
  }
}