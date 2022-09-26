package chess;

/**
 * This is a abstract chess piece class that has general information about the piece.
 */
public abstract class AbstractChessPiece implements ChessPiece {
  private int row;
  private int col;
  private Color color;
  private final int MIN = 0;
  private final int MAX = 7;

  protected AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {
    verifyRowAndColumn(row, col);
    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.col;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  protected boolean isValid(int n) {
    return n >= 0 && n <= 7;
  }

  protected void verifyRowAndColumn(int row, int column) {
    if (!isValid(row) || !isValid(column)) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    verifyRowAndColumn(row, col);
    return this.row != row || this.col != col;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return this.color == piece.getColor();
  }
}
