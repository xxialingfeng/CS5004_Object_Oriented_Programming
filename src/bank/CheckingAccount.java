package bank;

/**
 * This is a CheckingAccount class which extends AbstractAccount and implements IAccount.
 * It is unique in method performMonthlyMaintenance.
 */
public class CheckingAccount extends AbstractAccount {
  private boolean isBelow;
  private static final int THRESHOLD = 100;
  private static final int FEES = 5;

  /**
   * This is a constructor method which inherits the AbstractAccount constructor.
   *        @param balance the starter amount of account.
   *        @throws IllegalArgumentException
   *        if starter account is smaller than 1 cent, throw exception.
   */
  public CheckingAccount(double balance) throws IllegalArgumentException {
    super(balance);
    this.isBelow = balance < THRESHOLD;
  }

  /**
   * This is a checkAmount method which checks the current balance.
   * @return AmountBelow boolean.
   */
  public boolean checkIfBelow() {
    if (this.balance < THRESHOLD) {
      this.isBelow = true;
    }
    return this.isBelow;
  }

  /**
   *  This is a deposit method which takes in non-negative amount and deposit into the account.
   *      @param amount This is the amount which account takes and deposit.
   *      @throws IllegalArgumentException
   *      If the amount is negative, throw exception.
   *      CheckAmount in the end.
   */
  @Override
  public void deposit(double amount) throws IllegalArgumentException {
    super.deposit(amount);
    checkIfBelow();
  }

  /**
   * This is a withdraw method which takes in non-negative amount and withdraw from the account.
   * Return true if the transaction succeeds.
   * @param amount This is the amount which account deducts.
   * @return boolean. If the withdraw account is larger than curAmount,
   *      or negative, return false.
   *      check amount in the end.
   */
  @Override
  public boolean withdraw(double amount) throws IllegalArgumentException {
    checkIfBelow();
    return super.withdraw(amount);
  }

  /**
   * This is a performMonthlyMaintenance method.
   * if the balance falls below $100 at ANY time before maintenance is performed,
   * account maintenance fee of $5 is charged.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (checkIfBelow()) {
      this.balance -= FEES;
    }
    this.isBelow = false;
    checkIfBelow();
  }
}
