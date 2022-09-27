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

  /**
   * This is a canMove method for Knight.
   *  A knight can move only in an L pattern:
   *  two cells horizontally and one vertically or vice versa.
   *     @param row row of the position.
   *     @param col column of the position.
   *     @return true if it can move to the place.
   */
  @Override
  public boolean canMove(int row, int col) {
    if (this.getRow() == row && this.getColumn() == col) {
      return false;
    }
    return super.canMove(row, col) && Math.abs(this.getRow() - row)
        * Math.abs(this.getColumn() - col) == CHANGE_OF_SPACE ;
  }

  /**
   * This is a canKill method for Knight.
   * It can kill any opponent’s piece if it can move to its place.
   *     @param piece Another ChessPiece object.
   *     @return true if it can move to the place and piece has different color than queen.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && canMove(piece.getRow(), piece.getColumn());
  }

}
