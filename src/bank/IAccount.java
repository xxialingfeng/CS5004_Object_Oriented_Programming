package bank;

/**
 * This interface represents a bank account. It is the super-type for
 * any other type of traditional financial account a bank might offer
 */

public interface IAccount {

  /**
   * Deposit money to the back.
   * @param amount amount of money
   */
  void deposit(double amount);

  /**
   * If can withdraw from the bank.
   * @param amount money
   * @return if can withdraw
   */
  boolean withdraw(double amount);

  /**
   * Get the balance of the account.
   * @return balance
   */
  double getBalance();

  /**
   * Get monthly maintenance.
   */
  void performMonthlyMaintenance();
}
