package Model;

import java.io.InputStreamReader;

/**
 * This is the main function.
 */
public class Main {

  /**
   * This is the main function.
   * @param args string[]
   */
  public static void main(String[] args) {
    new ShapeController(new InputStreamReader(System.in),
        System.out).ShapeGame(new ShapeModel());
  }
}
