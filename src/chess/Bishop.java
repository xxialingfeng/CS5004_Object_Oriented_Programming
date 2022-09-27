package chess;

/**
 * This is a bishop class representing bishop piece.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */
  public Bishop(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * This is a canMove method for bishop.
   *  A bishop can only move diagonally.
   *     @param row row of the position.
   *     @param col column of the position.
   *     @return true if it can move to the place.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (this.getRow() == row && this.getColumn() == col) {
      return false;
    }
    return super.canMove(row, col) && this.getRow() != row && this.getColumn() != col
        && this.getRow() - row == this.getColumn() - col;
  }

  /**
   * This is a override method for bishop.
   * @param piece ChessPiece
   * @return can kill the piece at given pos.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && canMove(piece.getRow(), piece.getColumn());
  }
}
