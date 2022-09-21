package hw2;

/**.
 * This is a Room class representing hotel's rooms.
 */
public class Room {
  private int occupancy;
  private double price;
  private int num;

  /**.
   * This is a constructor representing a hotel room
   * @param room room type
   * @param price the price of the room
   */
  public Room(RoomType room, double price)
      throws IllegalArgumentException {
    if (price < 0) {
      throw new IllegalArgumentException("price can not below zero!");
    }
    this.price = price;
    this.num = 0;
    this.occupancy = room.getMaxOccupancy();
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
   * @param numOfGuests the number of guests assigned to the room
   */
  public void bookRoom(int numOfGuests) {
    num = numOfGuests <= occupancy && numOfGuests > 0 && isAvailable()
        ? numOfGuests : num;
  }

  /**.
   * Return the number of guests assigned to the room.
   * @return the number of guests assigned to the room.
   */
  public int getNumberOfGuests() {
    return this.num;
  }

  /**
   * Return the price of the room.
   * @return the price of the room
   */
  public double getPrice() {
    return this.price;
  }

}

