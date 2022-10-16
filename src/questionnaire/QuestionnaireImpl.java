package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * This is a class that implements Questionnaire interface.
 */
public class QuestionnaireImpl implements Questionnaire {
  private List<Question> ListOfQuestion;

  /**
   * This is a constructor that takes no argument.
   */
  public QuestionnaireImpl() {
    this.ListOfQuestion = new ArrayList<>();
  }

  /**
   * This is an addQuestion method for identifier and question.
   * @param identifier a name for the question <b>unique</b> within this questionnaire. Not null
   *        or empty.
   * @param q the {@link Question} to be added to the questionnaire
   * @throws IllegalArgumentException
   *     if identifier is null or empty,
   *     throw exception
   */
  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || identifier.equals("") || q == null) {
      throw new IllegalArgumentException();
    }
    q.AddIdentifier(identifier);
    ListOfQuestion.add(q);
  }

  @Override
  public void removeQuestion(String identifier) throws NoSuchElementException,
      IllegalArgumentException {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException();
    }
    for (Question q : ListOfQuestion) {
      if (q.GetIdentifier().equals(identifier)) {
        ListOfQuestion.remove(q);
        return;
      }
    }
    throw new NoSuchElementException();
  }

  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (num < 0 || num > ListOfQuestion.size()) {
      throw new IndexOutOfBoundsException();
    }
    return ListOfQuestion.get(num - 1);
  }

  @Override
  public Question getQuestion(String identifier) throws NoSuchElementException,
      IllegalArgumentException {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException();
    }
    for (Question q : ListOfQuestion) {
      if (q.GetIdentifier().equals(identifier)) {
        return q;
      }
    }
    throw new NoSuchElementException();
  }

  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> RequiredList = new ArrayList<>();
    for (Question q: ListOfQuestion) {
      if (q.isRequired()) {
        RequiredList.add(q);
      }
    }
    return RequiredList;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    List<Question> OptionalList = new ArrayList<>();
    for (Question q: ListOfQuestion) {
      if (!q.isRequired()) {
        OptionalList.add(q);
      }
    }
    return OptionalList;
  }

  @Override
  public boolean isComplete() {
    for (Question q: getRequiredQuestions()) {
      if (q.getAnswer().equalsIgnoreCase("") || q.getAnswer() == null) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<String> getResponses() {
    List<String> ResponseList = new ArrayList<>();
    for (Question q: ListOfQuestion) {
      ResponseList.add(q.getAnswer());
    }
    return ResponseList;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) throws IllegalArgumentException {
    if (pq == null) {
      throw new IllegalArgumentException("Can't have a null predicate.");
    }

    Questionnaire filteredQuestions = new QuestionnaireImpl();

    this.ListOfQuestion
        .stream()
        .filter(pq)
        .forEach(u -> filteredQuestions.addQuestion(u.GetIdentifier(), u.copy()));
    return filteredQuestions;
  }

  @Override
  public void sort(Comparator<Question> comp) throws IllegalArgumentException {
    if (ListOfQuestion == null || ListOfQuestion.size() == 0) {
      throw new IllegalArgumentException("Question List is null");
    }
    if (comp == null) {
      throw new IllegalArgumentException("Comparator is null");
    }
    ListOfQuestion.sort(comp);
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) throws IllegalArgumentException {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException();
    }
    for (Question q : ListOfQuestion) {
      seed = bf.apply(q, seed);
    }
    return seed;
  }

  /**
   * This is an overriding method for toString method.
   * @return String form of question and answer text.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Question q : ListOfQuestion) {
      sb.append("Question: ");
      sb.append(q.getPrompt()).append("\n\n");
      sb.append("Answer: ");
      sb.append(q.getAnswer()).append("\n\n");
    }
    return sb.substring(0, sb.length() - 2);
  }
}
