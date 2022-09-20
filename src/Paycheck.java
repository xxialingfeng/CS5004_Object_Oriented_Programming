import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * This class represents pay check.
 * @author  Lingfeng Xia
 */
public class Paycheck {

  private double payRate;
  private double hoursWorked;
  private double pay;
  private final int TAX_THRESHOLD = 400;
  private final int HOURS_THRESHOLD = 40;
  private final double TAX_MIN = 0.01;

  /**
   * Construct a pay check object that has provided pay rate and hours worked.
   * @param payRate a rate the company should pay.
   * @param hoursWorked hours the employee has worked for the company.
   */
  public Paycheck(double payRate, double hoursWorked) {
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    if (this.hoursWorked <= HOURS_THRESHOLD) {
      this.pay = this.payRate * this.hoursWorked;
    } else {
      this.pay = HOURS_THRESHOLD * this.payRate
          + (this.hoursWorked - HOURS_THRESHOLD) * 1.5 * this.payRate;
    }
  }

  /**
   * Return the payment for the employee.
   * @return the payment for the employee.
   */
  public double getTotalPay() {
    return this.pay;
  }

  /**
   * Return payment after deducting taxes.
   * @return payment after deducting taxes.
   */
  public double getPayAfterTaxes() {
    if (this.pay == 0) {
      return 0.0;
    } else if (this.pay > 0 && this. pay < TAX_MIN) {
      return TAX_MIN;
    } else if (this. pay >= TAX_MIN && this.pay < TAX_THRESHOLD) {
      return this.pay * 0.9;
    }
    return this.pay * 0.85;
  }


  /**
   * Return string representing the current payment after taxes are assessed.
   * @return string representing the current payment after taxes are assessed.
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.00");
    double payAfterTaxes = getPayAfterTaxes();
    if (payAfterTaxes < 1) {
      return "Payment after taxes: $ 0" + df.format(payAfterTaxes);
    }
    return "Payment after taxes: $ " + df.format(payAfterTaxes);
  }
}
