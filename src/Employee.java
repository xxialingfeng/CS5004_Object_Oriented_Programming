/**
 * This class represents employee.
 * @author Lingfeng Xia
 */
public class Employee {

  private String name;
  private String ID;
  private double workHours;
  private double payRate;

  /**
   * Construct a employee object that has name, ID, and pay rate.
   * @param name Employee's name.
   * @param ID Employee's ID.
   * @param payRate Employee's pay rate
   */
  public Employee(String name, String ID, double payRate) {
    this.name = name;
    this.ID = ID;
    this.payRate = payRate;
    this.workHours = 0;
  }

  /**.
   * add employee's work hours
   * @param hours add employee's work hours
   */
  public void addHoursWorked(double hours) {
    this.workHours += hours;
    if (this.workHours < 0) {
      this.workHours = 0;
    }
  }

  /**
   * Set employee's working hours to 0.
   */
  public void resetHoursWorked() {
    this.workHours = 0;
  }

  /**
   * Return how many hours the employee has worked.
   * @return how many hours the employee has worked.
   */
  public double getHoursWorked() {
    return this.workHours;
  }

  /**
   * Return a Paycheck contains employee's pay rate and work hours.
   * @return a Paycheck contains employee's pay rate and work hours.
   */
  public Paycheck getWeeklyCheck() {
    return new Paycheck(this.payRate, this.workHours);
  }

  /**
   * Return a string containing information about employees name, ID, and pay check.
   * @return a string containing information about employees name, ID, and pay check.
   */
  public String toString() {
    Paycheck pc = getWeeklyCheck();
    String str = "";
    str += "Name: " + this.name + "\n";
    str += "ID: " + this.ID + "\n";
    str += pc.toString();
    return str;
  }
}
