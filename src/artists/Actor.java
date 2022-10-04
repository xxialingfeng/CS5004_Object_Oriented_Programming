package artists;

/**
 * This is a Actor class.
 */
public class Actor implements IArtist  {
  private String name;
  private int age;
  private String[] genres;
  private String[] awards;
  private String[] movies;

  /**
   * This is a constructor that takes four parameters.
   * @param name name of the actor
   * @param age age of the actor
   * @param genres genres of the actor
   * @param awards awards received by the actor
   */
  public Actor(String name, int age, String[] genres, String[] awards, String[] movies)
      throws IllegalArgumentException {
    if (age > 128 || age < 0 || name == null || name.length() == 0) {
      throw new IllegalArgumentException();
    }
    this.movies = movies;
    this.name = name;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  /**
   * Return movies the actor acted in.
   * @return list string of movies name
   */
  public String[] getMovies() {
    return this.movies;
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

  /**
   * Override of the toString() method that answers
   * the basic information held by the AbstractArtist.
   * @return (String)
   */
  public String toString() {
    return "My name is " + this.name + "\n" + "My age is " + this.age
        + "\n" + "I am an ACTOR" + "\n"
        + "I make these types of movies: " + getGenre(this.genres)
        + "\n" + "I have acted in these movies: " + getGenre(this.movies);

  }

  /**
   * Return String in the given format.
   * @param genre list of string
   * @return string
   */
  public String getGenre(String[] genre) {
    String str = "[";
    for (String s : genre) {
      str += s;
      str += ", ";
    }
    String temp = str.substring(0, str.length() - 2);
    temp += "]";
    return temp;
  }
}
