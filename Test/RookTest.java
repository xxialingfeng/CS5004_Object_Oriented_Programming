import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;
import chess.King;
import chess.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for king piece.
 */
public class RookTest {
  private Rook RookOne;
  private Rook RookTwo;
  private Rook RookThree;

  /**
   * Set up some default value.
   */
  @Before
  public void setUp() {
    RookOne = new Rook(3,1, Color.WHITE);
    RookTwo = new Rook(2,5,Color.WHITE);
    RookThree = new Rook(4,3,Color.BLACK);
  }

  /**
   * Test if can get the row of the piece.
   */
  @Test
  public void getRowTest() {
    assertEquals(3, RookOne.getRow());
    assertEquals(2, RookTwo.getRow());
    assertEquals(4,RookThree.getRow());
  }

  /**
   * Test if can get the column of the piece.
   */
  @Test
  public void getColumnTest() {
    assertEquals(1, RookOne.getColumn());
    assertEquals(5, RookTwo.getColumn());
    assertEquals(3,RookThree.getColumn());
  }

  /**
   * Test if can get the color of the piece.
   */
  @Test
  public void getColorTest() {
    assertEquals(Color.WHITE, RookOne.getColor());
    assertEquals(Color.WHITE, RookTwo.getColor());
    assertEquals(Color.BLACK, RookThree.getColor());
  }

  /**
   * Test some invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Rook RookFour = new Rook(1,-4,Color.BLACK);
    Rook RookFive = new Rook(5, 0, Color.WHITE);
  }

  /**
   * Test if can move at some given situations.
   */
  @Test
  public void canMoveTest() {
    assertTrue(RookOne.canMove(1, 1));
    assertFalse(RookTwo.canMove(4, 2));
    assertFalse(RookOne.canMove(5, 6));
    assertFalse(RookOne.canMove(6, 2));
    assertTrue(RookThree.canMove(4,5));
  }

  /**
   * Test if can kill at some situations.
   */
  @Test
  public void canKillTest() {
    ChessPiece pieceOne = new Bishop(4,1,Color.BLACK);
    ChessPiece pieceTwo = new King(3,2,Color.BLACK);
    assertTrue(RookOne.canKill(pieceOne));
    assertFalse(RookTwo.canKill(pieceOne));
    assertTrue(RookOne.canKill(pieceTwo));
    assertTrue(RookOne.canKill(pieceTwo));
  }
}
