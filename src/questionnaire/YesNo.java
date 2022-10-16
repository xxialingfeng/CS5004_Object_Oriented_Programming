package questionnaire;

import java.util.List;

/**
 * This is a YesNo class which represents a type of Question.
 */
public class YesNo extends AbstractQuestion {
  private String prompt;
  private boolean isRequired;


  /**
   * This is a constructor that takes two arguments.
   * @param prompt text of the question
   * @param isRequired the question is required or optional
   */
  public YesNo(String prompt, boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String str) throws IllegalArgumentException {
    super.answer(str);
    if (str.equalsIgnoreCase("Yes") || str.equalsIgnoreCase("No")) {
      this.answer = str;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
