package tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class TicTacToeConsoleController implements TicTacToeController {
  private Readable in;
  private Appendable out;

  public TicTacToeConsoleController(Readable in, Appendable out)
      throws IllegalArgumentException {
    if (in == null || out == null) {
      throw new IllegalArgumentException();
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException();
    }
    Scanner sc = new Scanner(in);

    //print an empty board
    try {
      out.append(m.toString()).append("\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }
    // start game
    while (!m.isGameOver()) {
      try {
        out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
      } catch (IOException e) {
        throw new IllegalStateException();
      }

      String r = "";
      String c = "";

      try {
        r = sc.next();
        c = sc.next();
      } catch (Exception e) {
        e.printStackTrace();
      }

      //check quit

      if (r.equalsIgnoreCase("q") || c.equalsIgnoreCase("q")) {
        try {
          out.append("Game quit! Ending game state: \n").append(m.toString()).append("\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        break;
      }

      //check move
      try {
        int row = Integer.parseInt(r);
        int col = Integer.parseInt(c);
        row--;
        col--;
        m.move(row, col);
        out.append(m.toString()).append("\n");
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (IOException e) {
        throw new IllegalStateException();
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException();
      }

      if (m.isGameOver()) {
        try {
          if (m.getWinner() == Player.O) {
            out.append("Game is over! O wins.");
          } else if (m.getWinner() == Player.X) {
            out.append("Game is over! X wins.");
          } else {
            out.append("Game is over! Tie game");
          }
        } catch (IOException e) {
          throw new IllegalStateException();
        }
      }
    }

  }
}
