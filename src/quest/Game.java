package quest;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private List<Room> rooms;

  public Game(List<Room> rooms) {
    this.rooms = rooms;
  }

  public List<Room> getRoomsWith(String item) {
    List<Room> res = new ArrayList<>();
    for (Room room : rooms) {
      if (room.contains(item)) {
        res.add(room);
      }
    }
    return res;
  }

  public List<Room> getEmptyRooms() {
    List<Room> res = new ArrayList<>();
    for (Room room : this.rooms) {
      if (room.isEmpty()) {
        res.add(room);
      }
    }
    return res;
  }
}
