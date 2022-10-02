package employee;

/**
 * This is a salaried pay check class that extends Paycheck.
 */
public class SalariedPaycheck extends Paycheck {
  private final int THRESHOLD = 0;
  private int payInterval;
  private double payRate;
  private final int Week = 52;

  /**
   * This is a constructor that takes pay rate and pay interval as parameters.
   * @param payRate pay rate
   * @param payInterval pay interval
   * @throws IllegalArgumentException " "
   */
  SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    if (payRate < THRESHOLD || payInterval < THRESHOLD) {
      throw new IllegalArgumentException();
    }
    this.payRate = payRate;
    this.payInterval = payInterval;
  }

  @Override
  public double getTotalPay() {
    return this.payInterval * this.payRate / Week;
  }
}
