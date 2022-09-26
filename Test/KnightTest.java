import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;
import chess.King;
import chess.Knight;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for king piece.
 */
public class KnightTest {
  private Knight KnightOne;
  private Knight KnightTwo;
  private Knight KnightThree;

  /**
   * Set up some default value.
   */
  @Before
  public void setUp() {
    KnightOne = new Knight(4,2, Color.WHITE);
    KnightTwo = new Knight(3,1,Color.WHITE);
    KnightThree = new Knight(2,3,Color.BLACK);
  }

  /**
   * Test if can get the row of the piece.
   */
  @Test
  public void getRowTest() {
    assertEquals(4, KnightOne.getRow());
    assertEquals(3, KnightTwo.getRow());
    assertEquals(2,KnightThree.getRow());
  }

  /**
   * Test if can get the column of the piece.
   */
  @Test
  public void getColumnTest() {
    assertEquals(2, KnightOne.getColumn());
    assertEquals(1, KnightTwo.getColumn());
    assertEquals(3,KnightThree.getColumn());
  }

  /**
   * Test if can get the color of the piece.
   */
  @Test
  public void getColorTest() {
    assertEquals(Color.WHITE, KnightOne.getColor());
    assertEquals(Color.WHITE, KnightTwo.getColor());
    assertEquals(Color.BLACK, KnightThree.getColor());
  }

  /**
   * Test some invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Knight KnightFour = new Knight(-1,-2,Color.BLACK);
    Knight KnightFive = new Knight(0, -3, Color.WHITE);
  }

  /**
   * Test if can move at some given situations.
   */
  @Test
  public void canMoveTest() {
    assertFalse(KnightOne.canMove(1, 1));
    assertTrue(KnightTwo.canMove(2, 3));
    assertTrue(KnightOne.canMove(5, 4));
    assertFalse(KnightOne.canMove(6, 2));
    assertTrue(KnightThree.canMove(1,1));
  }

  /**
   * Test if can kill at some situations.
   */
  @Test
  public void canKillTest() {
    ChessPiece pieceOne = new Bishop(1,3,Color.WHITE);
    ChessPiece pieceTwo = new King(4,5,Color.BLACK);
    assertFalse(KnightOne.canKill(pieceOne));
    assertFalse(KnightTwo.canKill(pieceOne));
    assertFalse(KnightOne.canKill(pieceTwo));
    assertFalse(KnightOne.canKill(pieceTwo));
  }
}
