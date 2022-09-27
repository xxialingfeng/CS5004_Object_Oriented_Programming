package bank;

/**
 * This is SavingsAccount class which extends AbstractAccount and implements IAccount.
 * It is unique in withdraw and performMonthlyMaintenance methods.
 */
public class SavingsAccount extends AbstractAccount {
  private static final int PENALTY = 14;
  private int count;
  private static final int NUMBER_OF_WITHDRAW = 6;

  /**
   * This is a constructor method which inherits the AbstractAccount constructor.
   *        @param balance the starter amount of account.
   *        @throws IllegalArgumentException
   *        if starter account is smaller than 1 cent, throw exception.
   */
  public SavingsAccount(double balance) throws IllegalArgumentException {
    super(balance);
    this.count = 0;
  }

  /**
   * This withdraw method inherits the AbstractAcoount withdraw and takes track of withdraw number.
   *        @param amount This is the amount which account deducts.
   *        @return boolean. If successful, return true.
   *        If negative or larger than balance, return false.
   */
  @Override
  public boolean withdraw(double amount) {
    this.count++;
    return super.withdraw(amount);
  }

  /**
   * This is performMonthlyMaintenance method.
   * if the number of withdraw is larger than 6,
   * a transaction penalty of $14 is deducted from the account.
   */
  @Override
  public void performMonthlyMaintenance() {
    if ( count >= NUMBER_OF_WITHDRAW ) {
      this.balance -= PENALTY;
      this.count = 0;
    }
  }
}
