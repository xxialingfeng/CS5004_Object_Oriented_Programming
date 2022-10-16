package questionnaire;

import java.util.List;

/**
 * This represents a Question interface.
 */
public interface Question {

  /**
   * Return the text of the question.
   * @return text of the question
   */
  String getPrompt();

  /**
   * Return the status of the question.
   * @return status
   */
  boolean isRequired();

  /**
   * allows one to enter answer as a string.
   * @param str answer
   */
  void answer(String str);

  /**
   * Return answer.
   * @return answer
   */
  String getAnswer();

  /**
   * Return a list of questions.
   * @return copy of the question including all its data
   */
  Question copy();
}
