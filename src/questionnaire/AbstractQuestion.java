package questionnaire;

/**
 * This is an abstract class for Question.
 */
public class AbstractQuestion implements Question {
  protected final String prompt;
  protected final boolean isRequired;
  protected String answer;
  protected String identifier;

  /**
   * This is a constructor of question type with text and required.
   * @param prompt Text of the question.
   * @param isRequired boolean whether the question is required.
   * @throws IllegalArgumentException
   *     If question text is null or empty, throw exception.
   */
  public AbstractQuestion(String prompt, boolean isRequired) throws IllegalArgumentException {
    if (prompt == null || prompt.equals("")) {
      throw new IllegalArgumentException();
    }
    this.prompt = prompt;
    this.isRequired = isRequired;
    this.answer = "";
  }

  /**
   * This is a method for GetPrompt(question text).
   * @return String of question form.
   */
  @Override
  public String getPrompt() {
    return this.prompt;
  }

  /**
   * This is a method for getting required field.
   * @return boolean Required.
   */
  @Override
  public boolean isRequired() {
    return this.isRequired;
  }


  /**
   * This is a general method for answer method.
   * @param str string form of answer user inputs.
   * @throws IllegalArgumentException ""
   */
  @Override
  public void answer(String str) throws IllegalArgumentException {
    if (str == null || str.equals("")) {
      throw new IllegalArgumentException();
    }
    answer = str;
  }

  /**
   * This is a getter for answer method.
   * @return string form of answer.
   */
  @Override
  public String getAnswer() {
    return this.answer;
  }


  /**
   * This is a copy method for copy the Question.
   * @return the copy of Question.
   */
  @Override
  public Question copy() throws IllegalArgumentException {
    return null;
  }

  /**
   * add identifier.
   * @param identifier string.
   */
  @Override
  public void AddIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Get identifier.
   * @return identifier
   */
  @Override
  public String GetIdentifier() {
    return this.identifier;
  }
}
