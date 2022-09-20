package hw2;

/**.
 * This is a Room class representing hotel's rooms.
 */
public class Room {
  private final int SINGLE_MAX = 1;
  private final int DOUBLE_MAX = 2;
  private final int FAMILY_MAX = 4;
  private double price;
  private int num;
  private final RoomType room;
  enum RoomType {
    SINGLE_ROOM, DOUBLE_ROOM, FAMILY_ROOM;
  }

  /**.
   * This is a constructor representing a hotel room
   * @param room room type
   * @param price the price of the room
   */
  public Room(RoomType room, double price) {
    this.price = price;
    if (price < 0) {
      throw new IllegalArgumentException("price can not below zero!");
    }
    this.num = 0;
    this.room = room;
  }

  /**.
   * Return if the room is available to be booked.
   * @return if the room is available to be booked.
   */
  public boolean isAvailable() {
    return this.num == 0;
  }

  /**.
   * Book a room if meet the conditions
   * @param num the number of guests assigned to the room
   */
  public void bookRoom(int num) {
    if (isAvailable() && num > 0) {
      if (this.room == RoomType.SINGLE_ROOM) {
        if (num <= SINGLE_MAX) {
          this.num = num;
        }
      } else if (this.room == RoomType.DOUBLE_ROOM) {
        if (num <= DOUBLE_MAX) {
          this.num = num;
        }
      } else {
        if (num <= FAMILY_MAX) {
          this. num = num;
        }
      }
    }
  }

  /**.
   * Return the number of guests assigned to the room.
   * @return the number of guests assigned to the room.
   */
  public int getNumberOfGuests() {
    return this.num;
  }

}

