package chess;

/**
 * This is a Knight class representing knight piece.
 */
public class Knight extends AbstractChessPiece {
  private static final int CHANGE_OF_SPACE = 2;
  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */

  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }


  @Override
  public boolean canMove(int row, int col) {
    if (this.getRow() == row && this.getColumn() == col) {
      return false;
    }
    return super.canMove(row, col) && Math.abs(this.getRow() - row)
        * Math.abs(this.getColumn() - col) == CHANGE_OF_SPACE ;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && canMove(piece.getRow(), piece.getColumn());
  }

}
