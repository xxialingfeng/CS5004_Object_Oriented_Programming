import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;
import chess.King;
import chess.Queen;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for king piece.
 */
public class QueenTest {
  private Queen QueenOne;
  private Queen QueenTwo;
  private Queen QueenThree;

  /**
   * Set up some default value.
   */
  @Before
  public void setUp() {
    QueenOne = new Queen(4,1, Color.BLACK);
    QueenTwo = new Queen(2,3,Color.WHITE);
    QueenThree = new Queen(1,5,Color.BLACK);
  }

  /**
   * Test if can get the row of the piece.
   */
  @Test
  public void getRowTest() {
    assertEquals(4, QueenOne.getRow());
    assertEquals(2, QueenTwo.getRow());
    assertEquals(1,QueenThree.getRow());
  }

  /**
   * Test if can get the column of the piece.
   */
  @Test
  public void getColumnTest() {
    assertEquals(1, QueenOne.getColumn());
    assertEquals(3, QueenTwo.getColumn());
    assertEquals(5,QueenThree.getColumn());
  }

  /**
   * Test if can get the color of the piece.
   */
  @Test
  public void getColorTest() {
    assertEquals(Color.BLACK, QueenOne.getColor());
    assertEquals(Color.WHITE, QueenTwo.getColor());
    assertEquals(Color.BLACK, QueenThree.getColor());
  }

  /**
   * Test some invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Queen QueenFour = new Queen(-4,1,Color.BLACK);
    Queen QueenFive = new Queen(-3, 0, Color.WHITE);
  }

  /**
   * Test if can move at some given situations.
   */
  @Test
  public void canMoveTest() {
    assertFalse(QueenOne.canMove(2, 4));
    assertTrue(QueenTwo.canMove(3, 3));
    assertFalse(QueenOne.canMove(5, 5));
    assertFalse(QueenOne.canMove(1, 3));
    assertFalse(QueenThree.canMove(2,4));
  }

  /**
   * Test if can kill at some situations.
   */
  @Test
  public void canKillTest() {
    ChessPiece pieceOne = new Bishop(1,3,Color.BLACK);
    ChessPiece pieceTwo = new King(4,5,Color.BLACK);
    assertFalse(QueenOne.canKill(pieceOne));
    assertTrue(QueenTwo.canKill(pieceOne));
    assertFalse(QueenOne.canKill(pieceTwo));
    assertFalse(QueenOne.canKill(pieceTwo));
  }
}
