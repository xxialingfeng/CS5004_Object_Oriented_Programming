import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;
import chess.King;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for king piece.
 */
public class KingTest {
  private King KingOne;
  private King KingTwo;
  private King KingThree;

  /**
   * Set up some default value.
   */
  @Before
  public void setUp() {
    KingOne = new King(2,3, Color.WHITE);
    KingTwo = new King(1,5,Color.WHITE);
    KingThree = new King(2,6,Color.BLACK);
  }

  /**
   * Test if can get the row of the piece.
   */
  @Test
  public void getRowTest() {
    assertEquals(2, KingOne.getRow());
    assertEquals(1, KingTwo.getRow());
    assertEquals(2,KingThree.getRow());
  }

  /**
   * Test if can get the column of the piece.
   */
  @Test
  public void getColumnTest() {
    assertEquals(3, KingOne.getColumn());
    assertEquals(5, KingTwo.getColumn());
    assertEquals(6,KingThree.getColumn());
  }

  /**
   * Test if can get the color of the piece.
   */
  @Test
  public void getColorTest() {
    assertEquals(Color.WHITE, KingOne.getColor());
    assertEquals(Color.WHITE, KingTwo.getColor());
    assertEquals(Color.BLACK, KingThree.getColor());
  }

  /**
   * Test some invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    King KingFour = new King(-1,0,Color.BLACK);
    King KingFive = new King(2, -3, Color.WHITE);
  }

  /**
   * Test if can move at some given situations.
   */
  @Test
  public void canMoveTest() {
    assertTrue(KingOne.canMove(2, 4));
    assertFalse(KingTwo.canMove(3, 3));
    assertFalse(KingOne.canMove(5, 5));
    assertTrue(KingOne.canMove(1, 3));
    assertFalse(KingThree.canMove(2,4));
  }

  /**
   * Test if can kill at some situations.
   */
  @Test
  public void canKillTest() {
    ChessPiece pieceOne = new Bishop(1,3,Color.BLACK);
    ChessPiece pieceTwo = new King(4,5,Color.BLACK);
    assertTrue(KingOne.canKill(pieceOne));
    assertFalse(KingTwo.canKill(pieceOne));
    assertFalse(KingOne.canKill(pieceTwo));
    assertFalse(KingOne.canKill(pieceTwo));
  }
}
