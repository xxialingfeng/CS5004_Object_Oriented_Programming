import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.ChessPiece;
import chess.Color;
import chess.King;
import chess.Pawn;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for king piece.
 */
public class PawnTest {
  private Pawn PawnOne;
  private Pawn PawnTwo;
  private Pawn PawnThree;

  /**
   * Set up some default value.
   */
  @Before
  public void setUp() {
    PawnOne = new Pawn(3,6, Color.BLACK);
    PawnTwo = new Pawn(1,1,Color.WHITE);
    PawnThree = new Pawn(4,4,Color.BLACK);
  }

  /**
   * Test if can get the row of the piece.
   */
  @Test
  public void getRowTest() {
    assertEquals(3, PawnOne.getRow());
    assertEquals(2, PawnTwo.getRow());
    assertEquals(4,PawnThree.getRow());
  }

  /**
   * Test if can get the column of the piece.
   */
  @Test
  public void getColumnTest() {
    assertEquals(6, PawnOne.getColumn());
    assertEquals(1, PawnTwo.getColumn());
    assertEquals(4,PawnThree.getColumn());
  }

  /**
   * Test if can get the color of the piece.
   */
  @Test
  public void getColorTest() {
    assertEquals(Color.BLACK, PawnOne.getColor());
    assertEquals(Color.WHITE, PawnTwo.getColor());
    assertEquals(Color.BLACK, PawnThree.getColor());
  }

  /**
   * Test some invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Pawn PawnFour = new Pawn(2,-2,Color.BLACK);
    Pawn PawnFive = new Pawn(1, 0, Color.WHITE);
  }

  /**
   * Test if can move at some given situations.
   */
  @Test
  public void canMoveTest() {
    assertFalse(PawnOne.canMove(2, 4));
    assertFalse(PawnTwo.canMove(3, 3));
    assertFalse(PawnOne.canMove(5, 5));
    assertFalse(PawnOne.canMove(1, 3));
    assertFalse(PawnThree.canMove(2,4));
    assertTrue(PawnTwo.canMove(3,1));
  }

  /**
   * Test if can kill at some situations.
   */
  @Test
  public void canKillTest() {
    ChessPiece pieceOne = new Bishop(1,3,Color.BLACK);
    ChessPiece pieceTwo = new King(4,5,Color.BLACK);
    assertFalse(PawnOne.canKill(pieceOne));
    assertFalse(PawnTwo.canKill(pieceOne));
    assertFalse(PawnOne.canKill(pieceTwo));
    assertFalse(PawnOne.canKill(pieceTwo));
    ChessPiece pieceThree = new King(2,6,Color.WHITE);
    assertFalse(PawnOne.canKill(pieceThree));
    ChessPiece pieceFour = new King(2,5,Color.WHITE);
    assertTrue(PawnOne.canKill(pieceFour));
    ChessPiece pieceFive = new King(2,6,Color.BLACK);
    assertFalse(PawnOne.canKill(pieceFive));
  }
}

