package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToeModel implements TicTacToe {
  // add your implementation here
  private Player[][] board;
  private int idx = 0;
  public TicTacToeModel() {
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
    /**********
    List<String> rows = new ArrayList<>();
    for(Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for(Player p : row) {
        if(p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);
    ************/
  }

  @Override
  public void move(int r, int c) throws IllegalArgumentException {
    if (outOfBound(r, c)) {
      throw new IllegalArgumentException();
    }
    board[r][c] = getTurn();
  }

  public boolean outOfBound(int r, int c) {
    return r < 0 || r > 2 || c < 0 || c > 2;
  }

  @Override
  public Player getTurn() {
    return idx % 2 == 0 ? Player.X : Player.O;
  }

  @Override
  public boolean isGameOver() {
    if (idx < 6) {
      return false;
    } else if (idx == 10) {
      return true;
    }
    Player p = getTurn();
    //check row
    for (int i = 0; i < 3; i++) {
      if (isSame(board[i])) {
        return true;
      }
    }
    //check col
    for (int j = 0; j < 3; j++) {
      boolean flag = true;
      for (int i = 1; i < 3; i++) {
        if (board[i][j] != board[i - 1][j]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return true;
      }
    }

    //check diagonals
    Player[] left = new Player[3];
    Player[] right = new Player[3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          left[j] = board[i][j];
        }
        if (isSame(left)) {
          return true;
        }
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i + j == 2) {
          left[j] = board[i][j];
        }
        if (isSame(right)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isSame(Player[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

  @Override
  public Player getWinner() {
    if (isGameOver() && idx > 5 && idx < 10) {
      return getTurn();
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] res = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      System.arraycopy(board[i], 0, res[i], 0, 3);
    }
    return res;
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if (outOfBound(r, c)) {
      throw new IllegalArgumentException();
    }
    return board[r][c];
  }
}
