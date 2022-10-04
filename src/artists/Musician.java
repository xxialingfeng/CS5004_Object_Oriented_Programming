package artists;

/**
 * This is a musician class that extends AbstractArtist.
 */
public class Musician implements IArtist  {
  private String name;
  private int age;
  private String[] genres;
  private String[] awards;
  private String recordingCompany;
  private String currentAlbum;

  /**
   * This is a constructor that has six parameters.
   * @param name name of the musician
   * @param age age of the musician
   * @param genres genres of the musician
   * @param awards awards received by the musician
   * @param recordingCompany the current recording of the musician
   * @param currentAlbum the current album of the musician
   * @throws IllegalArgumentException ""
   */
  public Musician(String name, int age, String[] genres, String[] awards,
      String currentAlbum, String recordingCompany)
      throws IllegalArgumentException {
    if (recordingCompany == null || currentAlbum == null
        || recordingCompany.length() == 0 || currentAlbum.length() == 0) {
      throw new IllegalArgumentException();
    }
    if (age > 128 || age < 0 || name == null || name.length() == 0) {
      throw new IllegalArgumentException();
    }
    this.recordingCompany = recordingCompany;
    this.currentAlbum = currentAlbum;
    this.name = name;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  /**
   * Return the name of the recording company.
   * @return record company name
   */
  public String getRecordingCompany() {
    return this.recordingCompany;
  }

  /**
   * Return latest record album.
   * @return current album
   */
  public String getLastRecordAlbum() {
    return this.currentAlbum;
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
    return "My name is " + this.name + "\n" + "My age is " + this.age + "\n"
        + "I am an MUSICIAN" + "\n"
        + "I make these types of music: " + getGenre(this.genres) + "\n"
        + "My current album is : " + this.currentAlbum + "\n"
        + "My recording company is: " + this.recordingCompany;
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
