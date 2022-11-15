package tictactoe;

import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) {
    new TicTacToeConsoleController(new InputStreamReader(System.in), System.out)
        .playGame(new TicTacToeModel());
  }
}
