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

  /**
   * Construct a pay check object that has provided pay rate and hours worked.
   * @param payRate a rate the company should pay.
   * @param hoursWorked hours the employee has worked for the company.
   */
  public Paycheck(double payRate, double hoursWorked) {
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    if (this.hoursWorked <= 40) {
      this.pay = this.payRate * this.hoursWorked;
    } else {
      this.pay = 40 * this.payRate + (this.hoursWorked - 40) * 1.5 * this.payRate;
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
    if (this.pay < 400) {
      double payment = this.pay * 0.9;
      payment = payment * 100;
      int temp = (int)payment;
      return temp / 100.0;
    }
    double payment = this.pay * 0.8;
    payment = payment * 100;
    int temp = (int)payment;
    return temp / 100.0;
  }

  /**
   * Return string representing the current payment after taxes are assessed.
   * @return string representing the current payment after taxes are assessed.
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat(".00");
    double payAfterTaxes = getPayAfterTaxes();
    return "Payment after taxes: $ " + df.format(payAfterTaxes);
  }
}
