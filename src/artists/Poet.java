package artists;

/**
 * This is a poet class extends AbstractArtist.
 */
public class Poet implements IArtist {
  private String name;
  private int age;
  private String[] genres;
  private String[] awards;
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
    if (publisher.length() == 0) {
      throw new IllegalArgumentException();
    }
    if (age > 128 || age < 0 || name == null || name.length() == 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  /**
   * Return the name of the publisher.
   * @return publisher name
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * This method adds another award to the list of awards won by the artist.
   * @param award (String)
   */
  @Override
  public void receiveAward(String award) {
    int size = this.awards.length; // get the current size of the array

    // Iterate through the current array, copy the values, then add the new value
    String [] updatedAwards = new String[size + 1];
    System.arraycopy(this.awards, 0, updatedAwards, 0, size);
    updatedAwards[size] = award;
    this.awards = updatedAwards;
  }

  /**
   * Answers the awards earned by the artist.
   * @return (String [])
   */
  @Override
  public String [] getAwards() {
    return this.awards;
  }
}
