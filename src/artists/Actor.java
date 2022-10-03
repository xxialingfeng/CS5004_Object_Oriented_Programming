package artists;

/**
 * This is a Actor class.
 */
public class Actor extends AbstractArtist {
  private String [] movies;

  /**
   * This is a constructor that takes four parameters.
   * @param name name of the actor
   * @param age age of the actor
   * @param genres genres of the actor
   * @param awards awards received by the actor
   */
  public Actor(String name, int age, String[] genres, String[] awards, String[] movies) {
    super(name, age, genres, awards);
    this.movies = movies;
  }

  /**
   * Return movies the actor acted in.
   * @return list string of movies name
   */
  public String[] getMovies() {
    return this.movies;
  }
}
