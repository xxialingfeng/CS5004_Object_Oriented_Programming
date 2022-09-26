package chess;

/**
 * This is a Queen class representing queen piece.
 */
public class Queen extends AbstractChessPiece {
  private Rook rook;
  private Bishop bishop;

  /**
   * This is a constructor that takes row, col, and color as parameters.
   * @param row row pos of the piece
   * @param col col pos of the piece
   * @param color color of the piece
   */

  public Queen(int row, int col, Color color) {
    super(row, col, color);
    this.rook = new Rook(row, col, color);
    this.bishop = new Bishop(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    return super.canMove(row, col) && (rook.canMove(row, col) || bishop.canMove(row, col));
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && canMove(piece.getRow(), piece.getColumn());
  }
}
