package questionnaire;

/**
 * This is a class representing Likert question with QuestionText and required.
 */
public class Likert extends AbstractQuestion {
  /**
   * This is the constructor for Likert question.
   * @param prompt text of question.
   * @param isRequired boolean whether question is required or not.
   */
  public Likert(String prompt, boolean isRequired) throws IllegalArgumentException {
    super(prompt, isRequired);
  }

  /**
   * This is answer method for Likert question.
   * The answer must be among likertResponseList.
   * @param str string form of answer user inputs.
   * @throws IllegalArgumentException
   *     if answer is null or empty or not in the list of response,
   *     throw exception.
   */
  @Override
  public void answer(String str) throws IllegalArgumentException {
    super.answer(str);
    LikertResponseOption[] OptionArray = LikertResponseOption.values();
    for (LikertResponseOption i : OptionArray) {
      if (str.equalsIgnoreCase(i.getText())) {
        this.answer = str;
        return;
      }
    }
    throw new IllegalArgumentException();
  }
}
