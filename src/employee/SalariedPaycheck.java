package employee;

/**
 * This is a salaried pay check class that extends Paycheck.
 */
public class SalariedPaycheck extends AbstractPaycheck {
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
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    if (payRate < THRESHOLD || payInterval < THRESHOLD) {
      throw new IllegalArgumentException();
    }
    this.payRate = payRate;
    this.payInterval = payInterval;
  }

  /**
   * Get total pay.
   * @return total pay
   */
  @Override
  public double getTotalPay() {
    return this.payInterval * this.payRate / Week;
  }

  /**
   * Return pay interval.
   * @return pay interval
   */
  public int getPayInterval() {
    return this.payInterval;
  }
}
