package quest;

import java.util.Arrays;
import java.util.Objects;

public class Room {
  private String name;
  private String[] items;

  public Room(String name, String[] items) {
    this.name = name;
    this.items = items;
  }

  public boolean isEmpty() {
    return items.length == 0;
  }

  public boolean contains(String nameOfItem) {
    for (String item : items) {
      if (item.equals(nameOfItem)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || this.getClass() != other.getClass()) {
      return false;
    }
    Room room = (Room) other;
    return this.name.equalsIgnoreCase(room.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
