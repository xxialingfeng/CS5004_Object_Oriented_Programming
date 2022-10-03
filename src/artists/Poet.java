package artists;

/**
 * This is a poet class extends AbstractArtist.
 */
public class Poet extends AbstractArtist {
  private String publisher;

  /**
   * This is a constructor that takes five parameters.
   * @param name name of the poet
   * @param age age of the poet
   * @param genres genres of the poet
   * @param awards awards received by the poets
   * @param publisher the publisher name
   * @throws IllegalArgumentException ""
   */
  public Poet(String name, int age, String[] genres, String[] awards, String publisher)
      throws IllegalArgumentException {
    super(name, age, genres, awards);
    if (publisher.length() == 0) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Return the name of the publisher.
   * @return publisher name
   */
  public String getPublisher() {
    return publisher;
  }
}
