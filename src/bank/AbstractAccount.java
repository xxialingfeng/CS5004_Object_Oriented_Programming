package bank;

import java.text.DecimalFormat;

/**
 * This is a abstract class that implements IAccount interface.
 */
public class AbstractAccount implements IAccount {
  protected double balance;
  private static final double START_THRESHOLD = 0.01;
  private static final double MONEY_THRESHOLD = 0.0;

  /**
   * This is a constructor that takes startMoney as parameter.
   * @param startMoney starter amount
   */
  public AbstractAccount(double startMoney) throws IllegalArgumentException {
    if (startMoney < START_THRESHOLD) {
      throw new IllegalArgumentException();
    }
    this.balance = startMoney;
  }

  @Override
  public void deposit(double amount) throws IllegalArgumentException {
    if (amount < MONEY_THRESHOLD) {
      throw new IllegalArgumentException();
    }
    this.balance += amount;
  }

  @Override
  public boolean withdraw(double amount) {
    if (amount < MONEY_THRESHOLD || this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    return true;
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

  @Override
  public void performMonthlyMaintenance() {
    this.balance = 0;
  }

  /**
   * This is a toString method that print the balance information in the given format.
   * @return a string
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("##0.00");
    String str = df.format(this.balance);
    return "$" + str;
  }
}
