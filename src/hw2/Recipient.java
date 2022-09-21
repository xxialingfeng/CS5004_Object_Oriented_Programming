package hw2;

import java.lang.IllegalArgumentException;

/**
 * This is a recipient class.
 */

public class Recipient {
  private final String firstName;
  private final String lastName;
  private final String emailAddress;

  /**
   * This is a constructor that takes first name, last name, and email as parameters.
   * @param firstName the first name.
   * @param lastName the last name.
   * @param emailAddress the email.
   */
  public Recipient(String firstName, String lastName, String emailAddress)
      throws IllegalArgumentException {
    String[] input = {firstName, lastName, emailAddress};
    // Checks if any of the input data is null or ""
    if (isNull(input)) throw new IllegalArgumentException("Cannot have null fields.");
    else {
      this.firstName = firstName;
      this.lastName = lastName;
      this.emailAddress = emailAddress;
    }
  }

  /**
   * Checks to see if a string is = to
   * "" or if the value is null.
   *
   * @param input An input array containing strings to be validated.
   * @return Returns true if any index of input is null, otherwise false.
   */
  private boolean isNull(String[] input) {
    for (int i = 0; i < 3; i++) {
      if (input[i] == null || input[i].equals("")) return true;
    }
    return false;
  }

  /**
   * Return the information as a given format.
   * @return the information as a given format
   */
  public String toString() {
    return this.firstName + " " + this.lastName + " Email:" + this.emailAddress;
  }
}
