package chess;

/**
 * This is a Pawn class representing pawn piece.
 */
public class Pawn extends AbstractChessPiece {
  private final int START_WHITE = 1;
  private final int START_BLACK = 6;

  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */

  public Pawn(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (this.getColor().equals(Color.WHITE)) {
      if (this.getRow() == START_WHITE) {
        return (this.getRow() + 1 == row && this.getColumn() == col)
            || (this.getRow() + 2 == row && this.getColumn() == col);
      }
      return this.getRow() + 1 == row && this.getColumn() == col;
    } else {
      if (this.getRow() == START_BLACK) {
        return (this.getRow() - 1 == row && this.getColumn() == col)
            || (this.getRow() - 2 == row && this.getColumn() == col);
      }
      return this.getRow() - 1 == row && this.getColumn() == col;
    }
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && canMove(piece.getRow(), piece.getColumn());
  }
}
