package chess;

/**
 * This is a King class representing king piece.
 */
public class King extends AbstractChessPiece {
  private int row;
  private int col;
  private Color color;

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
    return super.canMove(row, col) && ((row == this.row + 1 && col == this.col)
        || (row == this.row - 1 && col == this.col)
        || (row == this.row + 1 && col == this.col + 1)
        || (row == this.row - 1 && col == this.col - 1)
        || (row == this.row + 1 && col == this.col - 1)
        || (row == this.row - 1 && col == this.col + 1)
        || (row == this.row && col == this.col + 1)
        || (row == this.row && col == this.col - 1));
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return canMove(piece.getRow(), piece.getColumn()) && super.canKill(piece);
  }

}
