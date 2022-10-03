package artists;

/**
 * This is a musician class that extends AbstractArtist.
 */
public class Musician extends AbstractArtist {
  private String recordingCompany;
  private String currentAlbum;

  /**
   * This is a constructor that has six parameters.
   * @param name name of the musician
   * @param age age of the musician
   * @param genres genres of the musician
   * @param awards awards received by the musician
   * @param recordingCompany the current recording of the musician
   * @param lastAlbum the current album of the musician
   * @throws IllegalArgumentException ""
   */
  public Musician(String name, int age, String[] genres, String[] awards,
      String recordingCompany, String lastAlbum)
      throws IllegalArgumentException {
    super(name, age, genres, awards);
    if (recordingCompany == null || lastAlbum == null
        || recordingCompany.length() == 0 || lastAlbum.length() == 0) {
      throw new IllegalArgumentException();
    }
    this.recordingCompany = recordingCompany;
    this.currentAlbum = lastAlbum;
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
}
