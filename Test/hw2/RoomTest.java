package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This is a test class for Object room.
 */
public class RoomTest {

  /**
   * Test if the room is available to be booked.
   */
  @Test
  public void isAvailable() {
    Room roomOne = new Room(RoomType.SINGLE,150);
    assertTrue(roomOne.isAvailable());
    roomOne.bookRoom(1);
    assertFalse(roomOne.isAvailable());
  }

  /**
   * This test makes sure that if a negative value
   * for price passed into the constructor the
   * proper exception is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoom() {
    Room testSingleRoom = new Room(RoomType.SINGLE, -234.1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomTwo() {
    Room testFamilyRoom = new Room(RoomType.FAMILY, -123345.3);
  }

  /**
   * Test if the room can be booked.
   */
  @Test
  public void bookRoomTest() {
    Room roomTwo = new Room(RoomType.SINGLE, 80);
    roomTwo.bookRoom(1);
    assertEquals(1, roomTwo.getNumberOfGuests());
    roomTwo.bookRoom(1);
    assertEquals(1, roomTwo.getNumberOfGuests());
    Room roomThree = new Room(RoomType.DOUBLE, 160);
    roomThree.bookRoom(3);
    assertEquals(0, roomThree.getNumberOfGuests());
    Room roomFour = new Room(RoomType.FAMILY, 220);
    roomFour.bookRoom(4);
    assertEquals(4,roomFour.getNumberOfGuests());
    roomFour.bookRoom(2);
    assertEquals(4,roomFour.getNumberOfGuests());
  }

  /**
   * Test if this method can get the number of guests.
   */
  @Test
  public void getNumberOfGuests() {
    Room roomFive = new Room(RoomType.SINGLE, 140);
    assertEquals(0,roomFive.getNumberOfGuests());
    roomFive.bookRoom(1);
    assertEquals(1,roomFive.getNumberOfGuests());
  }
}