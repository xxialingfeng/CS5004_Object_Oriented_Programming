package chess;

/**
 * This is a Rook class representing rook piece.
 */
public class Rook extends AbstractChessPiece {

  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */

  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }

  /**
   * This is a canMove method for Rook.
   * A rook can move horizontally or vertically.
   *
   * @param row row of the position.
   * @param col column of the position.
   * @return true if it can move to the place.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (this.getRow() == row && this.getColumn() == col) {
      return false;
    }
    return super.canMove(row, col) && this.getRow() == row || this.getColumn() == col;
  }

  /**
   * This is a override method for rook.
   * @param piece ChessPiece
   * @return can kill the piece at given pos.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && canMove(piece.getRow(), piece.getColumn());
  }

}
