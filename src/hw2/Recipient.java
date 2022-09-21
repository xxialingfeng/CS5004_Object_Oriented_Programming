package hw2;

import java.lang.IllegalArgumentException;
/**
 * This is a recipient class.
 */
public class Recipient {
  private final String firstName;
  private final String LastName;
  private final String email;

  /**
   * This is a constructor that takes first name, last name, and email as parameters.
   * @param firstName the first name.
   * @param lastName the last name.
   * @param email the email.
   */
  public Recipient(String firstName, String lastName, String email)
      throws IllegalArgumentException {
    this.firstName = firstName;
    this.LastName = lastName;
    this.email = email;
    if (firstName == null || lastName == null || email == null) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Return the information as a given format.
   * @return the information as a given format
   */
  public String toString() {
    return this.firstName + " " + this.LastName + " Email:" + this.email;
  }
}
