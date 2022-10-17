package questionnaire;

/**
 * This is a class representing shortanswer question.
 */
public class ShortAnswer extends AbstractQuestion {
  private final int MAX_LENGTH = 280;

  /**
   * This is a constructor for shortanswer.
   * @param prompt the string form of question text.
   * @param isRequired boolean for required field.
   */
  public ShortAnswer(String prompt, boolean isRequired) throws IllegalArgumentException {
    super(prompt, isRequired);
  }

  /**
   * This is an answer method for short answer question type.
   * @param str string form of answer user inputs.
   * @throws IllegalArgumentException ""
   */
  @Override
  public void answer(String str) throws IllegalArgumentException {
    super.answer(str);
    if (str.length() > MAX_LENGTH) {
      throw new IllegalArgumentException();
    }
    this.answer = str;
  }

  @Override
  public Question copy() {
    Question copy = new ShortAnswer(this.prompt, this.isRequired);
    copy.answer(this.answer);
    return copy;
  }
}
