package cs5004.collcetions;

import java.util.Objects;

public class ListPriorityQueue implements PriorityQueue {
  private int priority;
  private String value;
  private PriorityQueue rest;
  private final int UpperBound = 10;
  private final int LowerBound = 10;

  public ListPriorityQueue(int priority, String value)
      throws IllegalArgumentException {
    if (priority > UpperBound || priority < LowerBound || value == null) {
      throw new IllegalArgumentException();
    }
    this.priority = priority;
    this.value = value;
    this.rest = new EmptyPQ();
  }

  public ListPriorityQueue(int priority, String value, PriorityQueue rest)
      throws IllegalArgumentException {
    if (priority > UpperBound || priority < LowerBound || value == null) {
      throw new IllegalArgumentException();
    }
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  public int getPriority() {
    return priority;
  }

  public String getValue() {
    return value;
  }

  public PriorityQueue getRest() {
    return rest;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority > UpperBound || priority < LowerBound || value == null) {
      throw new IllegalArgumentException();
    }
    ListPriorityQueue queue;
    if (priority > getPriority()) {
      queue = new ListPriorityQueue(priority, value,
          new ListPriorityQueue(getPriority(), getValue(), getRest()));
    } else {
      queue = new ListPriorityQueue(getPriority(),getValue(),this.rest.add(priority, value));
    }
    return queue;
  }

  /**
   * Create a static method for createEmpty.
   */
  public static PriorityQueue createEmpty() {
    return new EmptyPQ();
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return this.getValue();
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    if (this.rest.isEmpty()) {
      return new EmptyPQ();
    } else {
      return (ListPriorityQueue) rest;
    }
  }

  /**
   * Create an equals method to compare 2 ListPriorityQueue object.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      ListPriorityQueue o = (ListPriorityQueue) other;
      if (o.isEmpty() && this.isEmpty()) {
        return true;
      }
      else if (this.rest.isEmpty() && ((ListPriorityQueue) other).rest.isEmpty()) {
        return Objects.equals(this.value, ((ListPriorityQueue) other).value)
            && this.priority == ((ListPriorityQueue) other).priority;
      }
      else if (this.rest == null && o.rest == null) {
        return  Objects.equals(this.getValue(), o.getValue())
            && this.getPriority() == o.getPriority();
      }
      else if (this.rest != null && o.rest != null) {
        return Objects.equals(this.getValue(), o.getValue())
            && this.getPriority() == o.getPriority()
            && Objects.equals(this.rest, o.rest);
      }
      return false;
    }
    return false;
  }

  /**
   * Create a hashcode.
   */
  public int hashCode() {
    return Objects.hash(getPriority(), getValue(), getRest());
  }

  /**
   * Create a toString method.
   */
  public String toString() {
    return "Priority: " + this.getPriority()
        + " Value: " + this.getValue()
        + " Next: " + this.getRest().toString();
  }
}

