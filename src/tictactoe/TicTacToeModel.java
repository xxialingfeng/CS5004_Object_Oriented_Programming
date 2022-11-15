package tictactoe;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToeModel implements TicTacToe {
  private final Player[][] board;
  private int round;
  // add your implementation here

  /**
   * constructor.
   */
  public TicTacToeModel() {
    board = new Player[3][3];
    round = 1;
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
        row -> " " + Arrays.stream(row).map(
            p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
        .collect(Collectors.joining("\n-----------\n"));

  }

  @Override
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException {
    if (isGameOver()) {
      throw new IllegalStateException();
    } else if (outOfBound(r, c) || board[r][c] != null) {
      throw new IllegalArgumentException();
    }
    board[r][c] = round % 2 == 0 ? Player.O : Player.X;
    round++;
  }

  /**
   * check if args are valid.
   * @param r int
   * @param c int
   * @return true if valid
   */
  public boolean outOfBound(int r, int c) {
    return !(r < 2 && r >= 0 && c < 2 && c >= 0);
  }

  @Override
  public Player getTurn() {
    return round % 2 == 0 ? Player.O : Player.X;
  }

  @Override
  public boolean isGameOver() {
    if (round < 6) {
      return false;
    } else if (round == 10) {
      return true;
    }
    return getWinner() != null;
  }

  @Override
  public Player getWinner() {
    // check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] != null
          && board[i][0] == board[i][1]
          && board[i][1] == board[i][2]) {
        return board[i][0];
      }
    }

    // check cols
    for (int j = 0; j < 3; j++) {
      if (board[0][j] != null
          && board[0][j] == board[1][j]
          && board[1][j] == board[2][j]) {
        return board[0][j];
      }
    }

    // check diagonals
    if (board[1][1] != null
        && ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
        || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
      return board[1][1];
    }

    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] copy = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      System.arraycopy(board[i], 0, copy[i], 0, 3);
    }
    return  copy;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (outOfBound(r, c)) {
      throw new IllegalArgumentException();
    }
    return board[r][c];
  }
}