package chess;

/**
 * This is a abstract chess piece class that has general information about the piece.
 */
public class AbstractChessPiece implements ChessPiece {
  private int row;
  private int col;
  private Color color;
  private final int MIN = 0;
  private final int MAX = 7;

  protected AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {
    if (row < MIN || row > MAX || col < MIN || col > MAX) {
      throw new IllegalArgumentException();
    }
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

  @Override
  public boolean canMove(int row, int col) {
    if (this.row == row && this.col == col) {
      return false;
    }
    return row >= MIN && row <= MAX && col >= MIN && col <= MAX;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return this.color == piece.getColor();
  }
}
