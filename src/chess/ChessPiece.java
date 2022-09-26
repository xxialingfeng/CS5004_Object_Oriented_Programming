package chess;

/**
 * This is a chessPiece interface.
 */
public interface ChessPiece {

  /**
   * get row pos of the piece.
   * @return row pos
   */
  int getRow();

  /**
   * get col pos of the piece.
   * @return col pos
   */
  int getColumn();

  /**
   * Get the color of the piece.
   * @return color
   */
  Color getColor();

  /**
   * Return if the piece can move to the given pos.
   * @param row row pos
   * @param col col pos
   * @return can move to the pos given
   */
  boolean canMove(int row, int col);

  /**
   * Return if the piece can kill another piece in the given pos.
   * @param piece ChessPiece
   * @return can kill another piece
   */
  boolean canKill(ChessPiece piece);

}