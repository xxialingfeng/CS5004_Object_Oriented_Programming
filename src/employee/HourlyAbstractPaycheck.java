package employee;

/**
 * This is a hourly pay check class that extends Paycheck.
 */
public class HourlyAbstractPaycheck extends AbstractPaycheck {
  private final int THRESHOLD = 0;
  private final double coefficient = 1.5;
  private final int hourThreshold = 40;
  private double hoursWorked;

  /**
   * This is a constructor that takes pay rate and hours worked as parameters.
   * @param payRate pay rate
   * @param hoursWorked how many hours word.
   * @throws IllegalArgumentException " "
   */
  HourlyAbstractPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    if (payRate < THRESHOLD || hoursWorked < THRESHOLD) {
      throw new IllegalArgumentException();
    }
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double getTotalPay() {
    if (getHoursWorked() <= hourThreshold) {
      return getHoursWorked() * this.getPayRate();
    } else {
      return hourThreshold * this.getPayRate()
          + (getHoursWorked() - hourThreshold) * this.getPayRate() * coefficient;
    }
  }

  /**
   * This is a method for adding work hours.
   * Negative adding hours are acceptable, but total working hours have to be non-negative.
   *     @param hoursAdded adding work hours. can be positive or negative.
   */
  public void addHoursWorked(double hoursAdded) {
    this.hoursWorked += hoursAdded;
    if (this.hoursWorked < 0) {
      this.hoursWorked = 0;
    }
  }

  /**
   * This is a setter method for working hours.
   * Reset hours worked to 0.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

  /**
   * This is a getter method for working hours.
   *     @return hours worked(double)
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }
}
