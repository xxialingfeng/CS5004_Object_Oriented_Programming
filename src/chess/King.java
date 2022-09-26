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
    int[] newRow = new int[]{1, 0, -1};
    int[] newCol = new int[]{1, 0, -1};
    boolean flag = false;
    for (int j : newRow) {
      for (int k : newCol) {
        if (row == this.row + newRow[j] && col == this.col + newCol[k]) {
          flag = true;
          break;
        }
      }
    }
    return flag && super.canMove(row, col);
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return canMove(piece.getRow(), piece.getColumn()) && super.canKill(piece);
  }

}
