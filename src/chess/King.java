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
    for (int i = 0; i < newRow.length; i++) {
      for (int j = 0; j < newCol.length; j++) {
        if (i == j && i == 0) {
          continue;
        }
        if (row == this.row + newRow[i] && col == this.col + newCol[j]) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return canMove(piece.getRow(), piece.getColumn()) && super.canKill(piece);
  }

}
