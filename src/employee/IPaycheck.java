package employee;

/**
 * This is the paycheck interface.
 */
public interface IPaycheck {

  /**
   * Return total pay.
   * @return total pay.
   */
  double getTotalPay();

  /**
   * Return pay after taxes.
   * @return pay after taxes.
   */
  double getPayAfterTaxes();

  /**
   * Return pay rate.
   * @return pay rate.
   */
  double getPayRate();
}
