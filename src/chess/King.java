package chess;

/**
 * This is a King class representing king piece.
 */
public class King extends AbstractChessPiece {

  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */

  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (this.getRow() == row && this.getColumn() == col) {
      return false;
    }
    double distance = Math.sqrt((row - this.getRow())
        * (row - this.getRow()) + (col - this.getColumn()) * (col - this.getColumn()));
    return super.canMove(row, col) && distance <= Math.sqrt(2);
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return canMove(piece.getRow(), piece.getColumn()) && super.canKill(piece);
  }

}
