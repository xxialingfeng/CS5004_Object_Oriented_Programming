package cs5004.collcetions;

public class EmptyPQ implements PriorityQueue {
  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    return new ListPriorityQueue(priority, value);
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    return other != null && this.getClass() == other.getClass();
  }
}
