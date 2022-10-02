package employee;

import java.text.DecimalFormat;

/**
 * This is a Employee class.
 */
public class Employee {
  private String name;
  private String id;
  private double payRate;
  private boolean isManager;
  private int payInterval;
  private double hoursWorked;
  private final double THRESHOLD = 0;
  private IPaycheck paycheck;

  /**
   * This is a constructor that takes five parameters as salaried employee.
   * @param name name of the employee
   * @param id id of the employee
   * @param payRate pay rate of the employee
   * @param payInterval pay interval
   * @param isManager if the employee is manager
   */
  Employee(String name, String id, double payRate, int payInterval, boolean isManager )
      throws IllegalArgumentException {
    if (name == null || id == null || name.length() == THRESHOLD
        || id.length() == THRESHOLD || payRate < THRESHOLD) {
      throw new IllegalArgumentException();
    }
    if (payInterval != 1 && payInterval != 2 && payInterval != 4 ) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isManager = isManager;
    this.paycheck = new SalariedAbstractPaycheck(payRate, payInterval);
  }

  /**
   * This is a constructor that takes four parameters as hourly employee.
   * @param name name of the employee
   * @param id id of the employee
   * @param payRate pay rate of the employee
   * @param hoursWorked how many hours the employee has worked.
   */
  Employee(String name, String id, double payRate, double hoursWorked)
      throws IllegalArgumentException {
    if (name == null || id == null || name.length() == THRESHOLD
        || id.length() == THRESHOLD || payRate < THRESHOLD || hoursWorked < THRESHOLD) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    this.paycheck = new HourlyAbstractPaycheck(payRate, hoursWorked);
  }

  /**
   * Return if the employee is manager.
   * @return manager or not
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * Return pay check instance.
   * @return pay check instance
   */
  public IPaycheck getPaycheck() {
    return this.paycheck;
  }

  /**
   * This is an overriding method for toString method.
   *     @return string form of the employee information.
   */
  public String toString() {
    String pattern = "###0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    IPaycheck paycheck1 = this.getPaycheck();
    Double payAfterTax = paycheck1.getPayAfterTaxes();
    String format = decimalFormat.format(payAfterTax);
    return "Name: " + this.name + "\n"
        + "ID: " + this.id + "\n"
        + "Payment after taxes: $ " + format;
  }
}
