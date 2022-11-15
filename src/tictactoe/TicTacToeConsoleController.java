package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * implementing controller.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private Readable in;
  private Appendable out;

  /**
   * constructor.
   * @param in readable
   * @param out appendable
   * @throws IllegalArgumentException " "
   */
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
    Scanner s = new Scanner(in);
    //print empty board
    try {
      out.append(m.toString()).append("\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }

    //start game
    while (!m.isGameOver()) {
      try {
        out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
      } catch (IOException e) {
        throw new IllegalStateException();
      }

      String input1 = "";
      String input2 = "";
      try {
        input1 = s.next();
        input2 = s.next();
      } catch (Exception e) {
        e.printStackTrace();
      }

      //check game quit
      if (input1.equalsIgnoreCase("q") || input2.equalsIgnoreCase("q")) {
        try {
          out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        break;
      }

      //chess move
      try {
        int row = Integer.parseInt(input1);
        int col = Integer.parseInt(input2);
        row -= 1;
        col -= 1;
        m.move(row, col);
        out.append(m.toString()).append("\n");
      } catch (NumberFormatException e) {
        e.printStackTrace();
      } catch (IOException e) {
        throw new IllegalStateException();
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException();
      }

      //check game is over
      if (m.isGameOver()) {
        try {
          if (m.getWinner() == Player.X) {
            out.append("Game over! X wins.");
          } else if (m.getWinner() == Player.O) {
            out.append(("Game over! O wins."));
          } else {
            out.append("Game over! Tie game");
          }
        } catch (IOException e) {
          throw new IllegalStateException();
        }
      }
    }
  }
}
