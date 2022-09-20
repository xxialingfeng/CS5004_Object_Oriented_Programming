import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**.
 * This is a text class Employee
 */
public class EmployeeTest {

  /**.
   * Construct a personA object to test if work hours can be added.
   */
  @Test
  public void addHoursWorked() {
    Employee personA = new Employee("Jeff", "SUPS-111", 3.25);
    personA.addHoursWorked(2.5);
    assertEquals(2.5,personA.getHoursWorked(),0.000);
    personA.addHoursWorked(-1.5);
    assertEquals(1.0,personA.getHoursWorked(),0.000);
    personA.addHoursWorked(-0.1);
    assertEquals(0.9,personA.getHoursWorked(),0.000);
  }

  /**
   * Construct a personB object to test if work hours can be reset.
   */
  @Test
  public void resetHoursWorked() {
    Employee personB = new Employee("Zoey", "SUPS-112", 2.6);
    personB.addHoursWorked(3);
    personB.resetHoursWorked();
    assertEquals(0, personB.getHoursWorked(), 0.000);
  }

  /**.
   * Construct a personC object to test if we can get how many hours he/she has worked.
   */
  @Test
  public void getHoursWorked() {
    Employee personC = new Employee("Connor", "SUPS-113", 3.8);
    personC.addHoursWorked(2.5);
    assertEquals(2.5,personC.getHoursWorked(), 0.000);
  }

  /**
   * Construct a personD object to test the string representation is the same format as expected.
   */
  @Test
  public void testToString() {
    Employee personD = new Employee("Nina", "SUPS-114", 5.6);
    personD.addHoursWorked(15);
    assertEquals("Name: Nina\nID: SUPS-114\nPayment after taxes: $ 75.60", personD.toString());
  }
}