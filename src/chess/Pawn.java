package chess;

/**
 * This is a Pawn class representing pawn piece.
 */
public class Pawn extends AbstractChessPiece {
  private static final int START_WHITE = 1;
  private static final int START_BLACK = 6;
  private static final int MOVE_ONE = 1;
  private static final int MOVE_TWO = 2;

  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */

  public Pawn(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
    if (row < START_WHITE || row > START_BLACK) {
      throw new IllegalArgumentException();
    }
    verifyRowAndColumn(row, col);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (this.getRow() == row && this.getColumn() == col) {
      return false;
    }
    if (this.getColor().equals(Color.WHITE)) {
      if (this.getRow() == START_WHITE) {
        return (this.getRow() +MOVE_ONE == row && this.getColumn() == col)
            || (this.getRow() + MOVE_TWO == row && this.getColumn() == col);
      }
      return this.getRow() + MOVE_ONE == row && this.getColumn() == col;
    } else {
      if (this.getRow() == START_BLACK) {
        return (this.getRow() - MOVE_ONE == row && this.getColumn() == col)
            || (this.getRow() - MOVE_TWO == row && this.getColumn() == col);
      }
      return this.getRow() - MOVE_ONE == row && this.getColumn() == col;
    }
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.getColor().equals(Color.WHITE)) {
      return super.canKill(piece) && piece.getRow() - this.getRow() == MOVE_ONE
          && Math.abs(this.getColumn() - piece.getColumn()) == MOVE_ONE;
    }
    return super.canKill(piece) && piece.getRow() - this.getRow() == MOVE_ONE * -1
        && Math.abs(this.getColumn() - piece.getColumn()) == MOVE_ONE;
  }
}
