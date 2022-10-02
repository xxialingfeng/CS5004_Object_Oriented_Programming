package employee;

import java.text.DecimalFormat;

/**
 * This is a abstract paycheck class .
 */
abstract public class AbstractPaycheck implements IPaycheck {

  private double payRate;
  private final int TAX_THRESHOLD = 400;
  private final double TAX_MIN = 0.01;
  private final double ratioOne = 0.9;
  private final double ratioTwo = 0.85;


  /**
   * Construct a pay check object that has provided pay rate and hours worked.
   * @param payRate a rate the company should pay.
   */
  public AbstractPaycheck(double payRate) throws IllegalArgumentException {
    if (payRate < 0) {
      throw new IllegalArgumentException();
    }
    this.payRate = payRate;
  }

  /**
   * Return payment after deducting taxes.
   * @return payment after deducting taxes.
   */
  @Override
  public double getPayAfterTaxes() {
    double pay = this.getTotalPay();
    if (pay == 0) {
      return 0.0;
    } else if (pay > 0 && pay < TAX_MIN) {
      return TAX_MIN;
    } else if (pay >= TAX_MIN && pay < TAX_THRESHOLD) {
      return pay * ratioOne;
    }
    return pay * ratioTwo;
  }



  /**
   * This is an overriding method for toString().
   * @return string form of payment after tax.
   */
  public String toString() {
    double PayAfter = this.getPayAfterTaxes();
    String pattern = "###0.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    String format = decimalFormat.format(PayAfter);
    return "Payment after taxes: $ " + format;
  }

  @Override
  public double getPayRate() {
    return this.payRate;
  }
}
