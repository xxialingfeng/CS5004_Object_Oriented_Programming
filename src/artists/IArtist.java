package artists;

/**
 * This is a artist interface.
 */
public interface IArtist {

  /**
   * Receive award.
   * @param award name of the award
   */
  void receiveAward(String award);

  /**
   * get awards.
   * @return a list of string containing the name of the awards.
   */
  String [] getAwards();
}