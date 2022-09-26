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
 * This is a test class for bishop piece.
 */
public class bishopTest {
  private Bishop bishopOne;
  private Bishop bishopTwo;
  private Bishop bishopThree;

  /**
   * Set up some default value.
   */
  @Before
  public void setUp() {
    bishopOne = new Bishop(1,1, Color.WHITE);
    bishopTwo = new Bishop(2,3,Color.WHITE);
    bishopThree = new Bishop(5,6,Color.BLACK);
  }

  /**
   * Test if can get the row of the piece.
   */
  @Test
  public void getRowTest() {
    assertEquals(1, bishopOne.getRow());
    assertEquals(2, bishopTwo.getRow());
  }

  /**
   * Test if can get the column of the piece.
   */
  @Test
  public void getColumnTest() {
    assertEquals(1, bishopOne.getColumn());
    assertEquals(3, bishopTwo.getColumn());
  }

  /**
   * Test if can get the color of the piece.
   */
  @Test
  public void getColorTest() {
    assertEquals(Color.WHITE, bishopOne.getColor());
    assertEquals(Color.WHITE, bishopTwo.getColor());
  }

  /**
   * Test some invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Bishop bishopFour = new Bishop(-1,0,Color.BLACK);
    Bishop bishopFive = new Bishop(2, -3, Color.WHITE);
  }

  /**
   * Test if can move at some given situations.
   */
  @Test
  public void canMoveTest() {
    assertFalse(bishopOne.canMove(2, 3));
    assertFalse(bishopTwo.canMove(3, 3));
    assertTrue(bishopOne.canMove(5, 5));
    assertFalse(bishopOne.canMove(1, 1));
    assertFalse(bishopThree.canMove(2,4));
  }

  /**
   * Test if can kill at some situations.
   */
  @Test
  public void canKillTest() {
    ChessPiece pieceOne = new Bishop(2,3,Color.WHITE);
    ChessPiece pieceTwo = new King(4,5,Color.BLACK);
    assertFalse(bishopOne.canKill(pieceOne));
    assertFalse(bishopTwo.canKill(pieceOne));
    assertFalse(bishopOne.canKill(pieceTwo));
    assertFalse(bishopOne.canKill(pieceTwo));
  }

}
